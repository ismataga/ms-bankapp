package com.eduwise.eduwise.controller.examController;

import com.eduwise.eduwise.model.examDto.QuestionBankRequest;
import com.eduwise.eduwise.model.examDto.QuestionBankResponse;
import com.eduwise.eduwise.service.examService.QuestionBankService;
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
@RequestMapping("/api/v1/questionsBanks")
@SecurityRequirement(name = "bearerAuth")
public class QuestionBankController {
    private final QuestionBankService questionBankService;
    @GetMapping
    public List<QuestionBankResponse> getAllQuestionsBank() {
        return questionBankService.getAllQuestionsBank();
    }

    @GetMapping("/{id}")
    public QuestionBankResponse getQuestionBankById(@PathVariable Integer id) {
        return questionBankService.getQuestionBankById(id);
    }

    @PostMapping
    public Integer createQuestionBank(@RequestBody QuestionBankRequest request) {
        return questionBankService.createQuestionBank(request);
    }

    @PutMapping("/{id}")
    public void updateQuestionBank(@PathVariable Integer id, @RequestBody QuestionBankRequest request) {
        questionBankService.updateQuestionBank(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteQuestionBank(@PathVariable Integer id) {
        questionBankService.deleteQuestionBank(id);
    }
}
