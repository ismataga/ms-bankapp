package com.eduwise.eduwise.controller.admin;

import com.eduwise.eduwise.entity.LessonEntities.RatingEntity;
import com.eduwise.eduwise.model.adminDto.RatingStatistic;
import com.eduwise.eduwise.model.adminDto.requests.CourseRequest;
import com.eduwise.eduwise.model.adminDto.requests.RatingRequest;
import com.eduwise.eduwise.model.adminDto.responses.CourseResponse;
import com.eduwise.eduwise.service.lessonService.CourseService;
import com.eduwise.eduwise.service.lessonService.RatingService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@SecurityRequirement(name = "bearerAuth")
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
@RestController
@Slf4j
public class CourseController {

    private final CourseService courseService;
    private final RatingService ratingService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addCourse(@RequestBody CourseRequest courseRequest) {
        log.info("getAllCourses().start");
        courseService.addCourse(courseRequest);
        log.info("getAllCourses().end" + courseRequest);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CourseResponse getCourseById(@PathVariable Integer id) {
        return courseService.getCourseById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CourseResponse> getAllCourses() {
        return courseService.getAllCourses();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateCourseById(@PathVariable Integer id, @RequestBody CourseRequest courseRequest) {
        courseService.updateCourseById(id, courseRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCourseById(@PathVariable Integer id) {
        courseService.deleteCourseById(id);
    }

    @GetMapping("/{courseId}/ratings/waiting")
    @ResponseStatus(HttpStatus.OK)

    public List<RatingEntity> getWaitingReviews(@PathVariable Long courseId) {
        return ratingService.getWaitingReviews(courseId);
    }

    @PostMapping("/ratings/approve/{reviewId}")
    @ResponseStatus(HttpStatus.OK)
    public void approveReview(@PathVariable Long reviewId) {
        ratingService.approveReview(reviewId);
    }

    @PostMapping("/rate")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public RatingStatistic rate(@RequestHeader("user_id") Long userId,
                                @RequestBody @Valid RatingRequest ratingRequest) {
        return ratingService.rate(userId, ratingRequest);
    }
}
