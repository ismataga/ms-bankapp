package com.eduwise.eduwise.mapper.examMapper;

import com.eduwise.eduwise.entity.examEntity.QuestionBank;
import com.eduwise.eduwise.model.examDto.QuestionBankRequest;
import com.eduwise.eduwise.model.examDto.QuestionBankResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QuestionBankMapper {
    QuestionBankResponse mapToResponse(QuestionBank questionBank);

    QuestionBank mapToEntity(QuestionBankRequest request);
}
