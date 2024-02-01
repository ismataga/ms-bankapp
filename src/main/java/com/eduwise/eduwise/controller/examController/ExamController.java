package com.eduwise.eduwise.controller.examController;

import com.eduwise.eduwise.model.examDto.ExamRequest;
import com.eduwise.eduwise.model.examDto.ExamResponse;
import com.eduwise.eduwise.service.examService.ExamService;
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
@RequestMapping("/api/v1/exams")
@SecurityRequirement(name = "bearerAuth")
public class ExamController {

    private final ExamService examService;

    @PostMapping
    public ExamResponse createExam(@RequestBody ExamRequest examRequestDTO) {
        ExamResponse createdExam = examService.createExam(examRequestDTO);
        return createdExam;
    }

    @GetMapping("/{examId}")
    public ExamResponse getExam(@PathVariable Integer examId) {
        ExamResponse exam = examService.getExamById(examId);
        return exam;
    }

    @PutMapping("/{examId}")
    public ExamResponse updateExam(@PathVariable Integer examId, @RequestBody ExamRequest examRequestDTO) {
        ExamResponse updatedExam = examService.updateExam(examId, examRequestDTO);
        return updatedExam;
    }

    @DeleteMapping("/{examId}")
    public void deleteExam(@PathVariable Integer examId) {
        examService.deleteExam(examId);
    }
}

