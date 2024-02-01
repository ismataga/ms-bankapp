package com.eduwise.eduwise.controller.examController;


import com.eduwise.eduwise.model.examDto.ExamSubjectRequest;
import com.eduwise.eduwise.model.examDto.ExamSubjectResponse;
import com.eduwise.eduwise.service.examService.ExamSubjectService;
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
@RequestMapping("/api/v1/examsSubject")
@SecurityRequirement(name = "bearerAuth")
public class ExamSubjectController {
    private final ExamSubjectService examSubjectService;

    @PostMapping
    public ExamSubjectResponse createExamSubject(@RequestBody ExamSubjectRequest examSubjectRequest) {
        return examSubjectService.createExamSubject(examSubjectRequest);
    }

    @GetMapping("/{examSubjectId}")
    public ExamSubjectResponse getExamSubject(@PathVariable Integer examSubjectId) {
        return examSubjectService.getExamSubjectById(examSubjectId);
    }

    @PutMapping("/{examSubjectId}")
    public ExamSubjectResponse updateExamSubject(@PathVariable Integer examSubjectId, @RequestBody ExamSubjectRequest examSubjectRequest) {
        return examSubjectService.updateExamSubject(examSubjectId, examSubjectRequest);
    }

    @DeleteMapping("/{examSubjectId}")
    public void deleteExamSubject(@PathVariable Integer examSubjectId) {
        examSubjectService.deleteExamSubject(examSubjectId);
    }

}
