package com.eduwise.eduwise.service.lessonService;

import static com.eduwise.eduwise.model.enums.ExceptionConstants.BLOG_NOT_FOUND;
import static com.eduwise.eduwise.model.enums.ExceptionConstants.CERTIFICATE_NOT_FOUND;

import com.eduwise.eduwise.entity.LessonEntities.CertificateEntity;
import com.eduwise.eduwise.exception.AppException;
import com.eduwise.eduwise.mapper.admin.CertificateMapper;
import com.eduwise.eduwise.model.adminDto.requests.CertificateRequest;
import com.eduwise.eduwise.model.adminDto.responses.CertificateResponse;
import com.eduwise.eduwise.repository.lessonRepository.CertificateRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@Transactional
@RequiredArgsConstructor
public class CertificateService {
    private final CertificateMapper certificateMapper;
    private final CertificateRepository certificateRepository;

    public void addCertificate(CertificateRequest certificateRequest) {
        log.info("addCertificate().start" + certificateRequest);
        CertificateEntity certificateEntity = certificateMapper.requestToEntity(certificateRequest);
        certificateRepository.save(certificateEntity);
        log.info("addCertificate ().start");
    }

    public CertificateResponse getCertificateById(Integer id) {
        log.info("getBlogById().start " + id);
        CertificateEntity certificateEntity = certificateRepository.findById(id)
                .orElseThrow(() -> new AppException(id, CERTIFICATE_NOT_FOUND));
        CertificateResponse certificateResponse = certificateMapper.entityToBlogResponse(certificateEntity);
        log.info("getBlogById().end " + certificateEntity);
        return certificateResponse;
    }

    public List<CertificateResponse> getAllCertificates() {
        log.info("getAllBlogs().start");
        List<CertificateEntity> certificateEntity = certificateRepository.findAll();
        List<CertificateResponse> certificateResponse = certificateMapper.entityToBlogResponseList(certificateEntity);
        log.info("getAllBlogs().end");
        return certificateResponse;
    }

    public void updateCertificateById(Integer id, CertificateRequest certificateRequest) {
        log.info("updateCertificateById().start " + id);
        CertificateEntity certificateEntity = certificateRepository.
                findById(id).orElseThrow(() ->new AppException(id, CERTIFICATE_NOT_FOUND));
        if (Objects.nonNull(certificateRequest.getCourseId())) {
            certificateEntity.setCertificateId(certificateRequest.getCertificateId());
        }

        log.info("updateCertificateById().end " + id);
    }

    public void deleteCertificateById(Integer id) {
        log.info("deleteCertificateById().start " + id);
        certificateRepository.findById(id).orElseThrow(() -> new RuntimeException("Lesson not found " + id));
        certificateRepository.deleteById(id);
        log.info("deleteCertificateById().end " + id);
    }
}