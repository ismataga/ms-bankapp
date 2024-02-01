package com.eduwise.eduwise.controller.examController;

import com.eduwise.eduwise.model.examDto.FolderRequest;
import com.eduwise.eduwise.model.examDto.FolderResponse;
import com.eduwise.eduwise.service.examService.FolderService;
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
@SecurityRequirement(name = "bearerAuth")
@RequiredArgsConstructor
@RequestMapping("/api/v1/folders")
@SecurityRequirement(name = "bearerAuth")
public class FolderController {
    private final FolderService folderService;
    @GetMapping
    public List<FolderResponse> getAllFolders() {
        return folderService.getAllFolders();
    }

    @GetMapping("/{id}")
    public FolderResponse getFolderById(@PathVariable Integer id) {
        return folderService.getFolderById(id);
    }

    @PostMapping
    public Integer createFolder(@RequestBody FolderRequest request) {
        return folderService.createFolder(request);
    }

    @PutMapping("/{id}")
    public void updateFolder(@PathVariable Integer id, @RequestBody FolderRequest request) {
        folderService.updateFolder(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteFolder(@PathVariable Integer id) {
        folderService.deleteFolder(id);
    }
}
