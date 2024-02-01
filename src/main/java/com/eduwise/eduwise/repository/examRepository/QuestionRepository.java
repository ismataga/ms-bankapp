package com.eduwise.eduwise.repository.examRepository;

import com.eduwise.eduwise.entity.examEntity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
}
