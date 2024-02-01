package com.eduwise.eduwise.mapper.examMapper;

import com.eduwise.eduwise.entity.examEntity.ExamDetails;
import com.eduwise.eduwise.model.examDto.ExamDetailsRequest;
import com.eduwise.eduwise.model.examDto.ExamDetailsResponse;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface ExamDetailsMapper {
    ExamDetails mapToEntity(ExamDetailsRequest examDetailsRequestD);

    ExamDetailsResponse mapToDto(ExamDetails examDetails);

    List<ExamDetailsResponse> mapToDtoList(List<ExamDetails> examDetailsList);
}
