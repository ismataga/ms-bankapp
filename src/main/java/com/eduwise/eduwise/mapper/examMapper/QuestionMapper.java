package com.eduwise.eduwise.mapper.examMapper;

import com.eduwise.eduwise.entity.examEntity.Question;
import com.eduwise.eduwise.model.examDto.QuestionRequest;
import com.eduwise.eduwise.model.examDto.QuestionResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QuestionMapper {
    QuestionResponse mapToResponse(Question question);

    Question mapToEntity(QuestionRequest request);
}
