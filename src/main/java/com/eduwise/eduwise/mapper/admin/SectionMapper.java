package com.eduwise.eduwise.mapper.admin;

import com.eduwise.eduwise.entity.LessonEntities.SectionEntity;
import com.eduwise.eduwise.model.adminDto.requests.SectionRequest;
import com.eduwise.eduwise.model.adminDto.responses.SectionResponse;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {LessonMapper.class})
public interface SectionMapper {
//    @Mapping(source = "courseId", target = "courseId.id")
//    @Mapping(target = "duration", source = "duration", qualifiedByName = "toMinutes")
    SectionEntity sectionRequestToSectionEntity(SectionRequest sectionRequest);

    @Mapping(source = "lessons", target = "lessons", ignore = true)
//    @Mapping(target = "duration", source = "duration", qualifiedByName = "fromMinutes")
    SectionResponse sectionEntityToSectionResponse(SectionEntity sectionEntity);

    List<SectionResponse> entityToSectionResponseList(List<SectionEntity> sectionEntities);
//    @Named("toMinutes")
//    public static Long toMinutes(Duration duration) {
//        return Optional.ofNullable(duration).map(Duration::toMinutes).orElse(null);
//    }
//
//    @Named("fromMinutes")
//    public static Duration fromMinutes(Long durationMinutes) {
//        return Optional.ofNullable(durationMinutes).map(Duration::ofMinutes).orElse(null);
//    }
}

