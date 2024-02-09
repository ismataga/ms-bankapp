package com.eduwise.eduwise.mapper.admin;

import com.eduwise.eduwise.entity.LessonEntities.LessonEntity;
import com.eduwise.eduwise.entity.LessonEntities.SectionEntity;
import com.eduwise.eduwise.model.adminDto.requests.LessonRequest;
import com.eduwise.eduwise.model.adminDto.responses.LessonResponse;
import java.time.Duration;
import java.util.List;
import java.util.Optional;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface LessonMapper {
//    @Mapping(source = "sectionId", target = "section")
//    @Mapping(target = "duration", source = "duration", qualifiedByName = "toMinutes")
    LessonEntity requestToEntity(LessonRequest lessonRequest);

//    @Mapping(target = "duration", source = "duration", qualifiedByName = "fromMinutes")
    LessonResponse entityToLessonResponse(LessonEntity lessonEntity);

    List<LessonResponse> entityToLessonResponseList(List<LessonEntity> lessonEntities);

    SectionEntity map(Integer sectionId);
    @Named("toMinutes")
    public static Long toMinutes(Duration duration) {
        return Optional.ofNullable(duration).map(Duration::toMinutes).orElse(null);
    }

    @Named("fromMinutes")
    public static Duration fromMinutes(Long durationMinutes) {
        return Optional.ofNullable(durationMinutes).map(Duration::ofMinutes).orElse(null);
    }

}