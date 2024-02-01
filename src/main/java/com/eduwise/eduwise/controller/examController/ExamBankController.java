package com.eduwise.eduwise.controller.examController;

import com.eduwise.eduwise.model.examDto.ExamBankRequest;
import com.eduwise.eduwise.model.examDto.ExamBankResponse;
import com.eduwise.eduwise.model.examDto.ExamRequest;
import com.eduwise.eduwise.model.examDto.ExamResponse;
import com.eduwise.eduwise.model.examDto.FolderResponse;
import com.eduwise.eduwise.service.examService.ExamBankService;
import com.eduwise.eduwise.service.examService.ExamService;
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
@RequestMapping("/api/v1/examsBank")
@SecurityRequirement(name = "bearerAuth")
public class ExamBankController {
    private final ExamBankService examBankService;

    @PostMapping
    public ExamBankResponse createExamBank(@RequestBody ExamBankRequest examBankRequest) {
        ExamBankResponse createdExamBank = examBankService.createExamBank(examBankRequest);
        return createdExamBank;
    }

    @GetMapping("/{examId}")
    public ExamBankResponse getExamBank(@PathVariable Integer examId) {
        ExamBankResponse exam = examBankService.getExamBankById(examId);
        return exam;
    }

    @GetMapping
    public List<ExamBankResponse> getExamBankList() {
        return examBankService.getExamBankList();
    }

    @PutMapping("/{examId}")
    public void updateExamBank(@PathVariable Integer examId, @RequestBody ExamBankRequest examBankRequest) {
     examBankService.updateBankExam(examId, examBankRequest);
    }

    @DeleteMapping("/{examId}")
    public void deleteExamBank(@PathVariable Integer examId) {
        examBankService.deleteBankExam(examId);
    }
}
