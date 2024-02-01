package com.eduwise.eduwise.mapper.examMapper;

import com.eduwise.eduwise.entity.examEntity.ExamPublish;
import com.eduwise.eduwise.model.examDto.ExamPublishRequest;
import com.eduwise.eduwise.model.examDto.ExamPublishResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExamPublishMapper {
    ExamPublish mapToEntity(ExamPublishRequest examPublishRequest);

    ExamPublishResponse mapToDto(ExamPublish examPublish);

}
