package com.eduwise.eduwise.service.lessonService;

import static com.eduwise.eduwise.model.enums.ExceptionConstants.COURSE_NOT_FOUND;
import static com.eduwise.eduwise.model.enums.ExceptionConstants.SECTION_NOT_FOUND;

import com.eduwise.eduwise.entity.LessonEntities.CourseEntity;
import com.eduwise.eduwise.entity.LessonEntities.SectionEntity;
import com.eduwise.eduwise.exception.AppException;
import com.eduwise.eduwise.mapper.admin.SectionMapper;
import com.eduwise.eduwise.model.adminDto.requests.SectionRequest;
import com.eduwise.eduwise.model.adminDto.responses.SectionResponse;
import com.eduwise.eduwise.repository.lessonRepository.CourseRepository;
import com.eduwise.eduwise.repository.lessonRepository.SectionRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@Transactional
@RequiredArgsConstructor
public class SectionService {
    private final CourseRepository courseRepository;
    private final SectionRepository sectionRepository;
    private final SectionMapper sectionMapper;

    public void addSection(SectionRequest sectionRequest, Integer courseId) {
        log.info("addSection().start " + sectionRequest + courseId);

        CourseEntity courseEntity = courseRepository.findById(courseId)
                .orElseThrow(() -> new AppException(courseId, COURSE_NOT_FOUND));

        SectionEntity sectionEntity = sectionMapper.sectionRequestToSectionEntity(sectionRequest);

        sectionRepository.save(sectionEntity);

        courseRepository.save(courseEntity);

        log.info("addSection().end " + sectionRequest + courseId);

    }

    public SectionResponse getSectionById(Integer id) {
        log.info("getSectionById().start " + id);
        SectionEntity sectionEntity = sectionRepository.findById(id)
                .orElseThrow(() -> new AppException(id, SECTION_NOT_FOUND));
        SectionResponse sectionResponse = sectionMapper.sectionEntityToSectionResponse(sectionEntity);
        log.info("getSectionById().end " + id);
        return sectionResponse;
    }

    public List<SectionResponse> getAllSections() {
        log.info("getAllSection().start");
        List<SectionEntity> sectionEntities = sectionRepository.findAll();
        List<SectionResponse> sectionResponses = sectionMapper.entityToSectionResponseList(sectionEntities);
        log.info("getAllSection().end");
        return sectionResponses;
    }

    public void updateSectionById(Integer id, SectionRequest sectionRequest) {
        log.info("updateSectionById().start " + id);
        SectionEntity sectionEntity = sectionRepository.findById(id).
                orElseThrow(() -> new AppException(id, SECTION_NOT_FOUND));
        if (Objects.nonNull(sectionRequest.getName())) {
            sectionEntity.setName(sectionRequest.getName());
        }

        log.info("updateSectionById().end " + id);
    }

    public void deleteSectionById(Integer id) {
        log.info("deleteSectionById().start " + id);
        sectionRepository.findById(id).orElseThrow(() -> new AppException(id, SECTION_NOT_FOUND));
        sectionRepository.deleteById(id);
        log.info("deleteSectionById().end " + id);
    }
}
