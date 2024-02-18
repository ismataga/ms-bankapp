package com.eduwise.eduwise.mapper.admin;

import com.eduwise.eduwise.entity.LessonEntities.SectionEntity;
import com.eduwise.eduwise.model.adminDto.requests.SectionRequest;
import com.eduwise.eduwise.model.adminDto.responses.SectionResponse;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {LessonMapper.class})
public interface SectionMapper {
    SectionEntity sectionRequestToSectionEntity(SectionRequest sectionRequest);

    SectionResponse sectionEntityToSectionResponse(SectionEntity sectionEntity);

    List<SectionResponse> entityToSectionResponseList(List<SectionEntity> sectionEntities);

}

