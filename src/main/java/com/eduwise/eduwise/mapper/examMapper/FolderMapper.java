package com.eduwise.eduwise.mapper.examMapper;

import com.eduwise.eduwise.entity.examEntity.Folder;
import com.eduwise.eduwise.model.examDto.FolderRequest;
import com.eduwise.eduwise.model.examDto.FolderResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FolderMapper {
    FolderResponse mapToResponse(Folder folder);

    Folder mapToEntity(FolderRequest request);
}
