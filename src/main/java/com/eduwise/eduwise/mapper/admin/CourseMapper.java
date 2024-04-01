package com.eduwise.eduwise.mapper.admin;

import com.eduwise.eduwise.entity.LessonEntities.CourseEntity;
import com.eduwise.eduwise.entity.LessonEntities.RatingEntity;
import com.eduwise.eduwise.entity.User;
import com.eduwise.eduwise.model.adminDto.RatingStatistic;
import com.eduwise.eduwise.model.adminDto.requests.CourseRequest;
import com.eduwise.eduwise.model.adminDto.responses.CourseResponse;
import com.eduwise.eduwise.repository.lessonRepository.RatingRepository;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", uses = {RatingEntity.class, InstructorMapper.class, User.class})
public abstract class CourseMapper {
    @Autowired
    private RatingRepository ratingRepository;

    @Mapping(target = "instructor.user.name", source = "instructorName")
    @Mapping(target = "instructor.instructorPhoto", source = "instructorPhoto")
    public abstract CourseEntity mapToEntity(CourseRequest courseRequest);

    @Mapping(target = "ratings", expression = "java(mapRatingEntitiesToRatingStatistics(courseEntity.getId()))")
    @Mapping(target = "instructorResponse.fullname", expression = "java(instructorEntity.getUser().getName() + \" \" + instructorEntity.getUser().getSurname())")
    @Mapping(target = "instructorResponse.instructorPhoto", source = "instructor.instructorPhoto")
    public abstract CourseResponse entityToCourseResponse(CourseEntity courseEntity);


    public abstract List<CourseResponse> entityToCourseResponseList(List<CourseEntity> courseEntities);

    public RatingStatistic mapRatingEntitiesToRatingStatistics(Long courseId) {
        return ratingRepository.getRatingStatistic(courseId).orElse(null);
    }
}
