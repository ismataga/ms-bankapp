package com.eduwise.eduwise.service.lessonService;

import static com.eduwise.eduwise.model.enums.ExceptionConstants.COURSE_NOT_FOUND;
import static com.eduwise.eduwise.model.enums.ExceptionConstants.LESSON_NOT_FOUND;
import static com.eduwise.eduwise.model.enums.ExceptionConstants.SECTION_NOT_FOUND;

import com.eduwise.eduwise.entity.LessonEntities.CourseEntity;
import com.eduwise.eduwise.entity.LessonEntities.LessonEntity;
import com.eduwise.eduwise.entity.LessonEntities.SectionEntity;
import com.eduwise.eduwise.exception.AppException;
import com.eduwise.eduwise.mapper.admin.LessonMapper;
import com.eduwise.eduwise.model.adminDto.requests.LessonRequest;
import com.eduwise.eduwise.model.adminDto.responses.LessonResponse;
import com.eduwise.eduwise.repository.lessonRepository.CourseRepository;
import com.eduwise.eduwise.repository.lessonRepository.LessonRepository;
import com.eduwise.eduwise.repository.lessonRepository.SectionRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class LessonService {
    private final LessonMapper lessonMapper;
    private final LessonRepository lessonRepository;
    private final SectionRepository sectionRepository;
    private final CourseRepository courseRepository;

    public void addLesson(LessonRequest lessonRequest, Integer sectionId) {
        log.info("addLessonById().start " + lessonRequest + sectionId);

        SectionEntity section = sectionRepository.findById(sectionId)
                .orElseThrow(() -> new AppException(sectionId, SECTION_NOT_FOUND));

        LessonEntity lessonEntity = lessonMapper.requestToEntity(lessonRequest);
        lessonEntity.setSectionId(sectionId);

        lessonRepository.save(lessonEntity);

        updateSectionDuration(section);

        log.info("addLessonById().end " + lessonRequest + sectionId);

    }

    private void updateSectionDuration(SectionEntity section) {
        log.info("updateSectionDuration().start " + section);

        Long newSectionDuration = section.getLessons().stream()
                .mapToLong(LessonEntity::getDuration)
                .sum();

        section.setDuration(newSectionDuration);
        sectionRepository.save(section);
        // Retrieve the course
        Long courseId = section.getCourseId();
        CourseEntity courseEntity = courseRepository.findById(Math.toIntExact(courseId))
                .orElseThrow(() -> new AppException(courseId, COURSE_NOT_FOUND));

        // Calculate the new course duration by summing up the durations of all sections in the course
        Long newCourseDuration = courseEntity.getSections().stream()
                .mapToLong(SectionEntity::getDuration)
                .sum();

        // Update the course duration
        courseEntity.setDuration(newCourseDuration);
        courseRepository.save(courseEntity);
        log.info("updateSectionDuration().end " + section);
    }

    public LessonResponse getLessonById(Integer id) {
        log.info("getLessonById().start " + id);
        LessonEntity lessonEntity = lessonRepository.findById(id)
                .orElseThrow(() -> new AppException(id, LESSON_NOT_FOUND));
        LessonResponse lessonResponse = lessonMapper.entityToLessonResponse(lessonEntity);
        log.info("getLessonById().end " + id);
        return lessonResponse;
    }

    public List<LessonResponse> getAllLessons() {
        log.info("getAllLessons().start");
        List<LessonEntity> lessonEntities = lessonRepository.findAll();
        List<LessonResponse> lessonResponses = lessonMapper.entityToLessonResponseList(lessonEntities);
        log.info("getAllLessons().end");
        return lessonResponses;
    }

    public void updateLessonById(Integer id, LessonRequest lessonRequest) {
        log.info("updateLessonById().start " + id);
        LessonEntity lessonEntity = lessonRepository.findById(id)
                .orElseThrow(() -> new AppException(id, LESSON_NOT_FOUND));
        if (Objects.nonNull(lessonRequest.getTitle())) {
            lessonEntity.setTitle(lessonRequest.getTitle());
        }

        if (Objects.nonNull(lessonRequest.getDescription())) {
            lessonEntity.setDescription(lessonRequest.getDescription());
        }
        if (Objects.nonNull(lessonRequest.getDuration())) {
            lessonEntity.setDuration(lessonRequest.getDuration());
            SectionEntity section = sectionRepository.findById(lessonEntity.getSectionId())
                    .orElseThrow(() -> new AppException(lessonEntity.getSectionId(), SECTION_NOT_FOUND));

            Long newSectionDuration = section.getLessons().stream()
                    .mapToLong(LessonEntity::getDuration)
                    .sum();

            section.setDuration(newSectionDuration);
            sectionRepository.save(section);
            // Retrieve the course
            Long courseId = section.getCourseId();
            CourseEntity courseEntity = courseRepository.findById(Math.toIntExact(courseId))
                    .orElseThrow(() -> new AppException(courseId, COURSE_NOT_FOUND));

            // Calculate the new course duration by summing up the durations of all sections in the course
            Long newCourseDuration = courseEntity.getSections().stream()
                    .mapToLong(SectionEntity::getDuration)
                    .sum();

            // Update the course duration
            courseEntity.setDuration(newCourseDuration);
            courseRepository.save(courseEntity);
        }
        if (Objects.nonNull(lessonRequest.getLessonType())) {
            lessonEntity.setLessonType(lessonRequest.getLessonType());
        }
        if (Objects.nonNull(lessonRequest.getUrl())) {
            lessonEntity.setUrl(lessonRequest.getUrl());
        }

        log.info("updateLessonById().end " + id);
    }

    public void deleteLessonById(Integer id) {
        log.info("deleteLessonById().start " + id);
        lessonRepository.findById(id).orElseThrow(() -> new AppException(id, LESSON_NOT_FOUND));
        lessonRepository.deleteById(id);
        log.info("deleteLessonById().end " + id);
    }
}
