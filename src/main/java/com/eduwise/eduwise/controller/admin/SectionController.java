package com.eduwise.eduwise.controller.admin;

import com.eduwise.eduwise.model.adminDto.requests.SectionRequest;
import com.eduwise.eduwise.model.adminDto.responses.SectionResponse;
import com.eduwise.eduwise.service.lessonService.SectionService;
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

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/sections")
@SecurityRequirement(name = "bearerAuth")
@Slf4j
public class SectionController {
    private final SectionService sectionService;

    @PostMapping
    public void addSection(@RequestBody SectionRequest sectionRequest,Integer courseId){
        log.info("addSection().controller.start"+sectionRequest);
        sectionService.addSection(sectionRequest,courseId);
        log.info("addSection().controller.end");
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SectionResponse getSectionById(@PathVariable Integer id) {
        return sectionService.getSectionById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<SectionResponse> getAllSections() {
        return sectionService.getAllSections();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateSectionById(@PathVariable Integer id, @RequestBody SectionRequest sectionRequest) {
        sectionService.updateSectionById(id, sectionRequest);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteSectionById(@PathVariable Integer id) {
        sectionService.deleteSectionById(id);
    }
}
