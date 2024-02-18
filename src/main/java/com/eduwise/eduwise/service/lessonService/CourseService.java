package com.eduwise.eduwise.service.lessonService;

import static com.eduwise.eduwise.model.enums.ExceptionConstants.CERTIFICATE_NOT_FOUND;
import static com.eduwise.eduwise.model.enums.ExceptionConstants.COURSE_NOT_FOUND;

import com.eduwise.eduwise.entity.LessonEntities.CourseEntity;
import com.eduwise.eduwise.exception.AppException;
import com.eduwise.eduwise.mapper.admin.CourseMapper;
import com.eduwise.eduwise.model.adminDto.requests.CourseRequest;
import com.eduwise.eduwise.model.adminDto.responses.CourseResponse;
import com.eduwise.eduwise.repository.lessonRepository.CourseRepository;
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
public class CourseService {
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    public void addCourse(CourseRequest courseRequest) {
        log.info("addCourse().start :" +courseRequest);
        CourseEntity courseEntity = courseMapper.mapToEntity(courseRequest);
        courseRepository.save(courseEntity);
        log.info("addCourse().end :"+courseEntity);
    }
    public CourseResponse getCourseById(Integer id) {
        log.info("getCourseById().start " + id);
        CourseEntity courseEntity = courseRepository.findById(id)
                .orElseThrow(() -> new AppException(id, COURSE_NOT_FOUND));
        CourseResponse courseResponse = courseMapper.entityToCourseResponse(courseEntity);
        log.info("getCourseById().end " + id);
        return courseResponse;
    }

    public List<CourseResponse> getAllCourses() {

        log.info("getAllCourses().start");
        List<CourseEntity> courseEntities = courseRepository.findAll();
        List<CourseResponse> courseResponses = courseMapper.entityToCourseResponseList(courseEntities);
        log.info("getAllCourses().end");
        return courseResponses;
    }

    public void updateCourseById(Integer id, CourseRequest courseRequest) {
        log.info("updateCourseById().start " + id);

        CourseEntity courseEntity = courseRepository.findById(id)
                .orElseThrow(() -> new AppException(id, COURSE_NOT_FOUND));

        if (Objects.nonNull(courseRequest.getName())) {
            courseEntity.setName(courseRequest.getName());
        }

        if (Objects.nonNull(courseRequest.getDescription())) {
            courseEntity.setDescription(courseRequest.getDescription());
        }

        if (Objects.nonNull(courseRequest.getMonthlyPrice())) {
            courseEntity.setMonthlyPrice(courseRequest.getMonthlyPrice());
        }

        if (Objects.nonNull(courseRequest.getQuarterlyPrice())) {
            courseEntity.setQuarterlyPrice(courseRequest.getQuarterlyPrice());
        }

        if (Objects.nonNull(courseRequest.getAnnuallyPrice())) {
            courseEntity.setAnnuallyPrice(courseRequest.getAnnuallyPrice());
        }

        if (Objects.nonNull(courseRequest.getSemiAnnuallyPrice())) {
            courseEntity.setSemiAnnuallyPrice(courseRequest.getSemiAnnuallyPrice());
        }

        courseRepository.save(courseEntity);

        log.info("updateCourseById().end " + id);
    }


    public void deleteCourseById(Integer id) {
        log.info("deleteCourseById().start " + id);
        courseRepository.findById(id).orElseThrow(() -> new RuntimeException("Course not found " + id));
        courseRepository.deleteById(id);
        log.info("deleteCourseById().end " + id);
    }
}
