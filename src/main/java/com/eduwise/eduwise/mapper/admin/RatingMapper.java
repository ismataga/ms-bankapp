package com.eduwise.eduwise.mapper.admin;

import com.eduwise.eduwise.entity.LessonEntities.RatingEntity;
import com.eduwise.eduwise.model.adminDto.requests.RatingRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RatingMapper {
    RatingEntity toRatingEntity(Long userId, RatingRequest ratingRequest);
}
