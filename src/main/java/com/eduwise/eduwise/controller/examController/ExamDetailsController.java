package com.eduwise.eduwise.controller.examController;

import com.eduwise.eduwise.model.examDto.ExamDetailsRequest;
import com.eduwise.eduwise.model.examDto.ExamDetailsResponse;
import com.eduwise.eduwise.service.examService.ExamDetailService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import java.util.List;
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
@RequestMapping("/api/v1/examsDetails")
@SecurityRequirement(name = "bearerAuth")
public class ExamDetailsController {

    private final ExamDetailService examDetailService;

    @PostMapping
    public ExamDetailsResponse createExamDetails(@RequestBody ExamDetailsRequest examBankRequest) {
        return examDetailService.createExamDetails(examBankRequest);
    }

    @GetMapping("/{examId}")
    public ExamDetailsResponse getExamDetails(@PathVariable Integer examId) {
        return examDetailService.getExamDetailsById(examId);
    }

    @GetMapping
    public List<ExamDetailsResponse> getExamDetailsList() {
        return examDetailService.getExamDetailsList();
    }

    @PutMapping("/{examId}")
    public void updateExamDetails(@PathVariable Integer examId, @RequestBody ExamDetailsRequest examDetailsRequest) {
        examDetailService.updateExamDetails(examId, examDetailsRequest);
    }

    @DeleteMapping("/{examId}")
    public void deleteExamDetails(@PathVariable Integer examId) {
        examDetailService.deleteExamDetails(examId);
    }
}
