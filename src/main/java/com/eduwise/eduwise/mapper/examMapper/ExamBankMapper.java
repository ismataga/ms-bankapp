package com.eduwise.eduwise.mapper.examMapper;

import com.eduwise.eduwise.entity.examEntity.ExamBank;
import com.eduwise.eduwise.model.examDto.ExamBankRequest;
import com.eduwise.eduwise.model.examDto.ExamBankResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExamBankMapper {
    ExamBank mapToEntity(ExamBankRequest examBankRequestDTO);

    ExamBankResponse mapToDto(ExamBank examBank);

    ExamBankResponse mapToResponse(ExamBank examBank);
}
