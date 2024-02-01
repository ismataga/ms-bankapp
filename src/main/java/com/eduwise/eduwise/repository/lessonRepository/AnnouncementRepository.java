package com.eduwise.eduwise.repository.lessonRepository;

import com.eduwise.eduwise.entity.LessonEntities.AnnouncementsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnouncementRepository extends JpaRepository<AnnouncementsEntity,Integer> {
}
