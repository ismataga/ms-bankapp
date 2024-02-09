package com.eduwise.eduwise.mapper.admin;

import com.eduwise.eduwise.entity.LessonEntities.RatingEntity;
import com.eduwise.eduwise.model.adminDto.requests.RatingRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RatingMapper {

    @Mapping(target = "userId")
    RatingEntity toRatingEntity(Long userId, RatingRequest ratingRequest);
}
