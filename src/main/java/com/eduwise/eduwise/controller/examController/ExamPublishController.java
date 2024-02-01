package com.eduwise.eduwise.controller.examController;

import com.eduwise.eduwise.model.examDto.ExamPublishRequest;
import com.eduwise.eduwise.model.examDto.ExamPublishResponse;
import com.eduwise.eduwise.service.examService.ExamPublishService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/examsPublish")
@SecurityRequirement(name = "bearerAuth")
public class ExamPublishController {
    private final ExamPublishService examPublishService;

    @PostMapping
    public ExamPublishResponse createExamPublish(@RequestBody ExamPublishRequest examPublishRequest) {
        return examPublishService.createExamPublish(examPublishRequest);
    }

    @GetMapping("/{examPublishId}")
    public ExamPublishResponse getExamPublish(@PathVariable Integer examPublishId) {
        return examPublishService.getExamPublishById(examPublishId);
    }

    @PutMapping("/{examPublishId}")
    public ExamPublishResponse updateExamPublish(@PathVariable Integer examPublishId, @RequestBody ExamPublishRequest examPublishRequest) {
        return examPublishService.updateExamPublish(examPublishId, examPublishRequest);
    }

    @DeleteMapping("/{examPublishId}")
    public void deleteExamPublish(@PathVariable Integer examPublishId) {
        examPublishService.deleteExamPublish(examPublishId);
    }
}
