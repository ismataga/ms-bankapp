package com.eduwise.eduwise.controller.admin;

import com.eduwise.eduwise.model.adminDto.requests.LessonRequest;
import com.eduwise.eduwise.model.adminDto.responses.LessonResponse;
import com.eduwise.eduwise.service.lessonService.LessonService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/lessons")
@SecurityRequirement(name = "bearerAuth")
public class LessonController {
    private final LessonService lessonService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addLesson(@RequestBody LessonRequest lessonRequest,Integer sectionId) {
        lessonService.addLesson(lessonRequest, sectionId);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public LessonResponse getLessonById(@PathVariable Integer id) {
        return lessonService.getLessonById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<LessonResponse> getAllLessons() {
        return lessonService.getAllLessons();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateLessonById(@PathVariable Integer id, @RequestBody LessonRequest lessonRequest) {
        lessonService.updateLessonById(id, lessonRequest);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteLessonById(@PathVariable Integer id) {
        lessonService.deleteLessonById(id);
    }

}
