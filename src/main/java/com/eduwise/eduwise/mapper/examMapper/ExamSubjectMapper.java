package com.eduwise.eduwise.mapper.examMapper;

import com.eduwise.eduwise.entity.examEntity.ExamSubject;
import com.eduwise.eduwise.model.examDto.ExamSubjectRequest;
import com.eduwise.eduwise.model.examDto.ExamSubjectResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExamSubjectMapper {

    ExamSubject mapToEntity(ExamSubjectRequest examSubjectRequest);

    ExamSubjectResponse mapToDto(ExamSubject examSubject);

}
