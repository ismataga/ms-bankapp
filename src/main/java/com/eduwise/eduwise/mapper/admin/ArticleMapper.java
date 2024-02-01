package com.eduwise.eduwise.mapper.admin;

import com.eduwise.eduwise.entity.LessonEntities.ArticleEntity;
import com.eduwise.eduwise.model.adminDto.requests.ArticleRequest;
import com.eduwise.eduwise.model.adminDto.responses.ArticleResponse;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ArticleMapper {

    ArticleEntity requestToEntity(ArticleRequest articleRequest);

    ArticleResponse entityToResponse(ArticleEntity articleEntity);

    List<ArticleResponse> entityToResponseList(List<ArticleEntity> articleEntities);
}
