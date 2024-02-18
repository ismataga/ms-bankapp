package com.eduwise.eduwise.mapper.admin;

import com.eduwise.eduwise.entity.LessonEntities.LessonEntity;
import com.eduwise.eduwise.entity.LessonEntities.SectionEntity;
import com.eduwise.eduwise.model.adminDto.requests.LessonRequest;
import com.eduwise.eduwise.model.adminDto.responses.LessonResponse;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LessonMapper {
    LessonEntity requestToEntity(LessonRequest lessonRequest);

    LessonResponse entityToLessonResponse(LessonEntity lessonEntity);

    List<LessonResponse> entityToLessonResponseList(List<LessonEntity> lessonEntities);

    SectionEntity map(Integer sectionId);


}