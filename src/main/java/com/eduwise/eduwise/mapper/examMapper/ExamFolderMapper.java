package com.eduwise.eduwise.mapper.examMapper;

import com.eduwise.eduwise.entity.examEntity.ExamFolder;
import com.eduwise.eduwise.model.examDto.ExamFolderRequest;
import com.eduwise.eduwise.model.examDto.ExamFolderResponse;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExamFolderMapper {
    ExamFolder mapToEntity(ExamFolderRequest examFolderRequest);

    ExamFolderResponse mapToDto(ExamFolder examFolder);

    List<ExamFolderResponse> mapToDtoList(List<ExamFolder> examFolderList);

}
