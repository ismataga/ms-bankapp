package com.eduwise.eduwise.mapper.examMapper;

import com.eduwise.eduwise.entity.examEntity.Exam;
import com.eduwise.eduwise.model.examDto.ExamRequest;
import com.eduwise.eduwise.model.examDto.ExamResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExamMapper {
    Exam mapToEntity(ExamRequest examRequest);

    ExamResponse mapToDto(Exam exam);

}
