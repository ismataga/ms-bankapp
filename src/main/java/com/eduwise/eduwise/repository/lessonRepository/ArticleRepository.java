package com.eduwise.eduwise.repository.lessonRepository;

import com.eduwise.eduwise.entity.LessonEntities.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<ArticleEntity,Integer> {

}
