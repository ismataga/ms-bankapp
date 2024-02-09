package com.eduwise.eduwise.controller.admin;

import static com.eduwise.eduwise.model.enums.ExceptionConstants.BLOG_NOT_FOUND;

import com.eduwise.eduwise.exception.AppException;
import com.eduwise.eduwise.model.adminDto.requests.BlogRequest;
import com.eduwise.eduwise.model.adminDto.responses.BlogResponse;
import com.eduwise.eduwise.model.enums.ExceptionConstants;
import com.eduwise.eduwise.service.lessonService.BlogService;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/blogs")
@SecurityRequirement(name = "bearerAuth")
public class BlogController {
    private final BlogService blogService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addBlog(@RequestBody BlogRequest blogRequest) {
        log.info("getBlog().start" + blogRequest);
        blogService.addBlog(blogRequest);
        log.info("getBlog().end");
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BlogResponse getBlogById(@PathVariable Integer id) {
        return blogService.getBlogById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BlogResponse> getAllBlogs() {
        return blogService.getAllBlogs();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateBlogById(@PathVariable Integer id, @RequestBody BlogRequest blogRequest) {
        blogService.updateBlogById(id, blogRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteBlogById(@PathVariable Integer id) {
        blogService.deleteBlogById(id);
    }


}
