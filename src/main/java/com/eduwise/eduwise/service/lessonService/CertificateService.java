package com.eduwise.eduwise.service.lessonService;

import static com.eduwise.eduwise.model.enums.ExceptionConstants.CERTIFICATE_NOT_FOUND;
import static com.eduwise.eduwise.model.enums.ExceptionConstants.COURSE_NOT_FOUND;

import com.eduwise.eduwise.entity.LessonEntities.CertificateEntity;
import com.eduwise.eduwise.entity.LessonEntities.CourseEntity;
import com.eduwise.eduwise.entity.LessonEntities.LessonEntity;
import com.eduwise.eduwise.entity.User;
import com.eduwise.eduwise.exception.AppException;
import com.eduwise.eduwise.mapper.admin.CertificateMapper;
import com.eduwise.eduwise.model.adminDto.requests.CertificateRequest;
import com.eduwise.eduwise.model.adminDto.responses.CertificateResponse;
import com.eduwise.eduwise.repository.lessonRepository.CertificateRepository;
import com.eduwise.eduwise.repository.lessonRepository.CourseRepository;
import jakarta.transaction.Transactional;

import java.util.Date;
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
    private final CourseRepository courseRepository;

    public void generateCertificate(User user, Integer courseId) {

        CourseEntity courseEntity = courseRepository.findById(courseId)
                .orElseThrow(() -> new AppException(courseId, COURSE_NOT_FOUND));

        boolean allLessonsCompleted = courseEntity.getSections().stream()
                .flatMap(section -> section.getLessons().stream())
                .allMatch(LessonEntity::getIsCompleted);

        if (allLessonsCompleted) {
            CertificateEntity certificate = new CertificateEntity();
            certificate.setUserId(user.getId());
            certificate.setCourseId(courseEntity.getId());
            certificate.setCompletionDate(new Date());
            certificateRepository.save(certificate);

        } else {
            throw new AppException(courseId, COURSE_NOT_FOUND);
        }

    }

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
                findById(id).orElseThrow(() -> new AppException(id, CERTIFICATE_NOT_FOUND));


        log.info("updateCertificateById().end " + id);
    }

    public void deleteCertificateById(Integer id) {
        log.info("deleteCertificateById().start " + id);
        certificateRepository.findById(id).orElseThrow(() -> new RuntimeException("Lesson not found " + id));
        certificateRepository.deleteById(id);
        log.info("deleteCertificateById().end " + id);
    }
}
