package com.eduwise.eduwise.controller.admin;

import com.eduwise.eduwise.model.adminDto.requests.ArticleRequest;
import com.eduwise.eduwise.model.adminDto.responses.ArticleResponse;
import com.eduwise.eduwise.service.lessonService.ArticleService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/articles")
@SecurityRequirement(name = "bearerAuth")
public class ArticleController {
    private final ArticleService articleService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ArticleResponse addArticle(@RequestHeader("section_id") Integer sectionId, @RequestBody ArticleRequest articleRequest) {
        log.info("addArticle().start" + articleRequest);
        return articleService.addArticle(articleRequest, sectionId);
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ArticleResponse getArticleById(@PathVariable Integer id) {
        return articleService.getArticleById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ArticleResponse> getAllArticle() {
        return articleService.getAllArticle();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateArticleById(@PathVariable Integer id, @RequestBody ArticleRequest articleRequest) {
        articleService.updateArticleById(id, articleRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteArticleById(@PathVariable Integer id) {
        articleService.deleteArticleById(id);
    }

}
