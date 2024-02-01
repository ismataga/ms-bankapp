package com.eduwise.eduwise.repository.lessonRepository;

import com.eduwise.eduwise.entity.LessonEntities.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<CourseEntity,Integer> {
}
