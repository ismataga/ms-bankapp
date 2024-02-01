package com.eduwise.eduwise.repository.examRepository;

import com.eduwise.eduwise.entity.examEntity.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepository extends JpaRepository<Exam, Integer> {
}
