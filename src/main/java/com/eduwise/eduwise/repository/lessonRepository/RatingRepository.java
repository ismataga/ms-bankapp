package com.eduwise.eduwise.repository.lessonRepository;

import com.eduwise.eduwise.entity.LessonEntities.RatingEntity;
import com.eduwise.eduwise.model.adminDto.RatingStatistic;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository  extends JpaRepository<RatingEntity, Long> {
    List<RatingEntity> findByCourseIdAndIsWaiting(Long courseId, boolean isWaiting);
    List<RatingEntity> findByCourseId(Long courseId);
    @Query("""
                    SELECT new com.eduwise.eduwise.model.adminDto.RatingStatistic(
                        courseId,
                        ROUND(AVG(rate), 1),
                        COUNT(*),
                        COUNT(CASE WHEN rate = 1 THEN 1 END),
                        COUNT(CASE WHEN rate = 2 THEN 1 END),
                        COUNT(CASE WHEN rate = 3 THEN 1 END),
                        COUNT(CASE WHEN rate = 4 THEN 1 END),
                        COUNT(CASE WHEN rate = 5 THEN 1 END)
                    )
                    FROM RatingEntity
                    WHERE courseId = :courseId
                    GROUP BY courseId
            """)
    Optional<RatingStatistic> getRatingStatistic(Long courseId);

}