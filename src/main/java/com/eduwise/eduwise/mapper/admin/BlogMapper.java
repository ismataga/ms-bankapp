package com.eduwise.eduwise.mapper.admin;

import com.eduwise.eduwise.entity.LessonEntities.BlogEntity;
import com.eduwise.eduwise.model.adminDto.requests.BlogRequest;
import com.eduwise.eduwise.model.adminDto.responses.BlogResponse;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BlogMapper {
    BlogEntity requestToEntity(BlogRequest blogRequest);

    BlogResponse entityToBlogResponse(BlogEntity blogEntity);

    List<BlogResponse> entityToBlogResponseList(List<BlogEntity> blogEntities);

}
