package com.eduwise.eduwise.repository.lessonRepository;

import com.eduwise.eduwise.entity.LessonEntities.InstructorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<InstructorEntity,Long> {
}
