package com.eduwise.eduwise.repository.examRepository;


import com.eduwise.eduwise.entity.examEntity.QuestionBank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionBankRepository extends JpaRepository<QuestionBank, Integer> {
}
