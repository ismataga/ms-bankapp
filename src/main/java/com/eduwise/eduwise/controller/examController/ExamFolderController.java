package com.eduwise.eduwise.controller.examController;

import com.eduwise.eduwise.model.examDto.ExamFolderRequest;
import com.eduwise.eduwise.model.examDto.ExamFolderResponse;
import com.eduwise.eduwise.service.examService.ExamFolderService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
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
@RequestMapping("/api/v1/examsFolder")
@SecurityRequirement(name = "bearerAuth")
public class ExamFolderController {
    private final ExamFolderService examFolderService;

    @PostMapping
    public ExamFolderResponse createExamFolder(@RequestBody ExamFolderRequest examFolderRequest) {
        return examFolderService.createExamFolder(examFolderRequest);
    }

    @GetMapping("/{examFolderId}")
    public ExamFolderResponse getExamFolder(@PathVariable Integer examFolderId) {
        return examFolderService.getExamFolderById(examFolderId);
    }

    @GetMapping
    public List<ExamFolderResponse> getExamFolderList() {
        return examFolderService.getExamFolderList();
    }

    @PutMapping("/{examFolderId}")
    public ExamFolderResponse updateExamFolder(@PathVariable Integer examFolderId, @RequestBody ExamFolderRequest examFolderRequest) {
        return examFolderService.updateExamFolder(examFolderId, examFolderRequest);
    }

    @DeleteMapping("/{examFolderId}")
    public void deleteExamFolder(@PathVariable Integer examFolderId) {
       examFolderService.deleteExamFolder(examFolderId);
    }
}
