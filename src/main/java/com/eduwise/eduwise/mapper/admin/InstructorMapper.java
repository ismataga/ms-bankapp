package com.eduwise.eduwise.mapper.admin;

import com.eduwise.eduwise.entity.LessonEntities.InstructorEntity;
import com.eduwise.eduwise.model.adminDto.requests.InstructorRequest;
import com.eduwise.eduwise.model.adminDto.responses.InstructorResponse;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InstructorMapper {

    InstructorEntity toEntity(InstructorRequest instructorRequest);

    InstructorResponse toInstructorResponse(InstructorEntity instructorEntity);

    List<InstructorResponse> toInstructorResponseList(List<InstructorEntity> instructorEntity);
}
