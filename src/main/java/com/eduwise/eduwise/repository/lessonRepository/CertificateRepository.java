package com.eduwise.eduwise.repository.lessonRepository;


import com.eduwise.eduwise.entity.LessonEntities.CertificateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CertificateRepository extends JpaRepository<CertificateEntity,Integer> {
}
