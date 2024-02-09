package com.eduwise.eduwise.service.lessonService;

import static com.eduwise.eduwise.model.enums.ExceptionConstants.LESSON_NOT_FOUND;
import static com.eduwise.eduwise.model.enums.ExceptionConstants.SECTION_NOT_FOUND;

import com.eduwise.eduwise.entity.LessonEntities.CourseEntity;
import com.eduwise.eduwise.entity.LessonEntities.LessonEntity;
import com.eduwise.eduwise.entity.LessonEntities.SectionEntity;
import com.eduwise.eduwise.exception.AppException;
import com.eduwise.eduwise.mapper.admin.LessonMapper;
import com.eduwise.eduwise.model.adminDto.requests.LessonRequest;
import com.eduwise.eduwise.model.adminDto.responses.LessonResponse;
import com.eduwise.eduwise.model.enums.LessonType;
import com.eduwise.eduwise.repository.lessonRepository.LessonRepository;
import com.eduwise.eduwise.repository.lessonRepository.SectionRepository;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.transaction.Transactional;
import java.time.Duration;
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

    public void addLessons(LessonRequest lessonRequest) {
        log.info("addLesson().start" + lessonRequest);
        LessonEntity lessonEntity = lessonMapper.requestToEntity(lessonRequest);
        lessonRepository.save(lessonEntity);
        log.info("addLesson ().start");
    }

    public LessonEntity addLesson(LessonRequest lessonRequest, Integer sectionId) {
        // Retrieve the section
        SectionEntity section = sectionRepository.findById(sectionId)
                .orElseThrow(() -> new AppException(sectionId, SECTION_NOT_FOUND));

        // Set the section for the new lesson
        LessonEntity lessonEntity = lessonMapper.requestToEntity(lessonRequest);
        lessonEntity.setSection(section);

        // Save the new lesson
        LessonEntity savedLesson = lessonRepository.save(lessonEntity);

        // Update the section duration
        updateSectionDuration(section);

        // Save the updated section
        sectionRepository.save(section);

        return savedLesson;
    }

    private void updateSectionDuration(SectionEntity section) {
        // Calculate the new duration by summing up the durations of all lessons in the section
        Long newSectionDuration = section.getLessons().stream()
                .mapToLong(lessonEntity -> lessonEntity.getDuration().toSeconds())
                .sum();

        section.setDuration(newSectionDuration);

        // Retrieve the course
        CourseEntity course = section.getCourse();

        // Calculate the new course duration by summing up the durations of all sections in the course
        Long newCourseDuration = course.getSections().stream()
                .mapToLong(SectionEntity::getDuration)
                .sum();

        // Update the course duration
        course.setDuration(newCourseDuration);
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

        if (Objects.nonNull(lessonRequest.getLastPlaceStay())) {
            lessonEntity.setLastPlaceStay(lessonRequest.getLastPlaceStay());
        }
        if (Objects.nonNull(lessonRequest.getDescription())) {
            lessonEntity.setDescription(lessonRequest.getDescription());
        }
        if (Objects.nonNull(lessonRequest.getDuration())) {
            lessonEntity.setDuration(lessonRequest.getDuration());
        }
        if (Objects.nonNull(lessonRequest.getLessonType())) {
            lessonEntity.setLessonType(lessonRequest.getLessonType());
        }
        if (Objects.nonNull(lessonRequest.getVideoUrl())) {
            lessonEntity.setVideoUrl(lessonRequest.getVideoUrl());
        }

        log.info("updateLessonById().end " + id);
    }

    private Integer id;
    private String title;
    private String videoUrl;
    private String lastPlaceStay;
    private String description;
    private Duration duration;
    private Boolean isCompleted;
    private LessonType lessonType;
    @ManyToOne
    @JoinColumn(name = "section_id")
    private SectionEntity section;

    public void deleteLessonById(Integer id) {
        log.info("deleteLessonById().start " + id);
        lessonRepository.findById(id).orElseThrow(() -> new RuntimeException("Lesson not found " + id));
        lessonRepository.deleteById(id);
        log.info("deleteLessonById().end " + id);
    }
}
