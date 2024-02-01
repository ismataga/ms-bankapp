package com.eduwise.eduwise.service.lessonService;

import static com.eduwise.eduwise.model.enums.ExceptionConstants.ARTICLE_NOT_FOUND;
import static com.eduwise.eduwise.model.enums.ExceptionConstants.BLOG_NOT_FOUND;

import com.eduwise.eduwise.entity.LessonEntities.ArticleEntity;
import com.eduwise.eduwise.entity.LessonEntities.BlogEntity;
import com.eduwise.eduwise.exception.AppException;
import com.eduwise.eduwise.mapper.admin.ArticleMapper;
import com.eduwise.eduwise.model.adminDto.requests.ArticleRequest;
import com.eduwise.eduwise.model.adminDto.responses.ArticleResponse;
import com.eduwise.eduwise.model.adminDto.responses.BlogResponse;
import com.eduwise.eduwise.repository.lessonRepository.ArticleRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@Transactional
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;
    private final ArticleMapper articleMapper;

    public void addArticle(ArticleRequest articleRequest) {
        log.info("addArticle().start" + articleRequest);
        ArticleEntity articleEntity = articleMapper.requestToEntity(articleRequest);
        articleRepository.save(articleEntity);
        log.info("addArticle ().end");
    }

    public ArticleResponse getArticleById(Integer id) {
        log.info("getArticleById().start " + id);
        ArticleEntity articleEntity = articleRepository.findById(id)
                .orElseThrow(() -> new AppException(id, ARTICLE_NOT_FOUND));
        ArticleResponse articleResponse = articleMapper.entityToResponse(articleEntity);
        log.info("getArticleById().end " + articleEntity);
        return articleResponse;
    }

    public List<ArticleResponse> getAllArticle() {
        log.info("getAllArticle().start");
        List<ArticleEntity> articleEntities = articleRepository.findAll();
        List<ArticleResponse> articleResponses = articleMapper.entityToResponseList(articleEntities);
        log.info("getAllArticle().end");
        return articleResponses;
    }

    public void updateArticleById(Integer id, ArticleRequest articleRequest) {
        log.info("updateArticleById().start " + id);
        ArticleEntity articleEntity = articleRepository.findById(id)
                .orElseThrow(() -> new AppException(id, ARTICLE_NOT_FOUND));

        if (Objects.nonNull(articleRequest.name())) {
            articleEntity.setName(articleRequest.name());
        }

        if (Objects.nonNull(articleRequest.description())) {
            articleEntity.setDescription(articleRequest.description());
        }

        if (Objects.nonNull(articleRequest.section())) {
            articleEntity.setSection(articleRequest.section());
        }

        log.info("updateArticleById().end " + id);
    }

    public void deleteArticleById(Integer id) {
        log.info("deleteArticleById().start " + id);
        articleRepository.findById(id)
                .orElseThrow(() -> new AppException(id, ARTICLE_NOT_FOUND));
        articleRepository.deleteById(id);
        log.info("deleteArticleById().end " + id);
    }
}
