package com.eduwise.eduwise.controller.admin;

import com.eduwise.eduwise.model.adminDto.requests.CertificateRequest;
import com.eduwise.eduwise.model.adminDto.requests.InstructorRequest;
import com.eduwise.eduwise.model.adminDto.responses.CertificateResponse;
import com.eduwise.eduwise.model.adminDto.responses.InstructorResponse;
import com.eduwise.eduwise.service.lessonService.CertificateService;
import com.eduwise.eduwise.service.lessonService.InstructorService;
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

@SecurityRequirement(name = "bearerAuth")
@RequestMapping("/api/v1/instructor")
@RequiredArgsConstructor
@RestController
@Slf4j
public class InstructorController {
    private final InstructorService instructorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addInstructor(@RequestBody InstructorRequest instructorRequest) {
        log.info("addInstructor().start" + instructorRequest);
        instructorService.addInstructor(instructorRequest);
        log.info("addInstructor().end");
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public InstructorResponse getInstructorById(@PathVariable Long id) {
        return instructorService.getInstructorById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InstructorResponse> getAllInstructors() {
        return instructorService.getAllInstructors();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateInstructorById(@PathVariable Long id, @RequestBody InstructorRequest instructorRequest) {
        instructorService.updateInstructorById(id, instructorRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteInstructorById(@PathVariable Long id) {
        instructorService.deleteInstructorById(id);
    }

}
