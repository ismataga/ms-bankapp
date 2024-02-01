package com.eduwise.eduwise.controller.admin;

import com.eduwise.eduwise.model.adminDto.requests.CertificateRequest;
import com.eduwise.eduwise.model.adminDto.responses.CertificateResponse;
import com.eduwise.eduwise.service.lessonService.CertificateService;
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

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/certificates")
@SecurityRequirement(name = "bearerAuth")
public class CertificateController {
    private final CertificateService certificateService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addCertificate(@RequestBody CertificateRequest certificateRequest) {
        log.info("addCertificate().start" + certificateRequest);
        certificateService.addCertificate(certificateRequest);
        log.info("addCertificate().end");
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CertificateResponse getCertificateById(@PathVariable Integer id) {
        return certificateService.getCertificateById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CertificateResponse> getAllCertificates() {
        return certificateService.getAllCertificates();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateCertificateById(@PathVariable Integer id, @RequestBody CertificateRequest certificateRequest) {
        certificateService.updateCertificateById(id, certificateRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCertificateById(@PathVariable Integer id) {
        certificateService.deleteCertificateById(id);
    }

}
