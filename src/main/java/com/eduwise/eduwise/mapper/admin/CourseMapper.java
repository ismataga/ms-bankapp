package com.eduwise.eduwise.mapper.admin;

import com.eduwise.eduwise.entity.LessonEntities.CourseEntity;
import com.eduwise.eduwise.entity.LessonEntities.RatingEntity;
import com.eduwise.eduwise.model.adminDto.RatingStatistic;
import com.eduwise.eduwise.model.adminDto.requests.CourseRequest;
import com.eduwise.eduwise.model.adminDto.responses.CourseResponse;
import com.eduwise.eduwise.repository.lessonRepository.RatingRepository;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", uses = {RatingEntity.class})
public abstract class CourseMapper {
    @Autowired
    private RatingRepository ratingRepository;

    public abstract CourseEntity mapToEntity(CourseRequest courseRequest);

    //    @Mapping(source = "ratingEntities", target = "ratingEntities", ignore = true)
    @Mapping(target = "ratings", expression = "java(mapRatingEntitiesToRatingStatistics(courseEntity.getId()))")
    public abstract CourseResponse entityToCourseResponse(CourseEntity courseEntity);

    public abstract List<CourseResponse> entityToCourseResponseList(List<CourseEntity> courseEntities);

    public RatingStatistic mapRatingEntitiesToRatingStatistics(Long courseId) {
        return ratingRepository.getRatingStatistic(courseId).orElse(null);
    }
}
