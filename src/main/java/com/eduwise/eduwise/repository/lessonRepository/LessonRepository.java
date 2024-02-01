package com.eduwise.eduwise.repository.lessonRepository;


import com.eduwise.eduwise.entity.LessonEntities.LessonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonRepository extends JpaRepository<LessonEntity, Integer> {
}
