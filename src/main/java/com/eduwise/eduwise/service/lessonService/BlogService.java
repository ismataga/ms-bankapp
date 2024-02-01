package com.eduwise.eduwise.service.lessonService;

import static com.eduwise.eduwise.model.enums.ExceptionConstants.ANNOUNCEMENT_NOT_FOUND;
import static com.eduwise.eduwise.model.enums.ExceptionConstants.BLOG_NOT_FOUND;

import com.eduwise.eduwise.entity.LessonEntities.BlogEntity;
import com.eduwise.eduwise.exception.AppException;
import com.eduwise.eduwise.mapper.admin.BlogMapper;
import com.eduwise.eduwise.model.adminDto.requests.BlogRequest;
import com.eduwise.eduwise.model.adminDto.responses.BlogResponse;
import com.eduwise.eduwise.repository.lessonRepository.BlogRepository;
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
public class BlogService {
    private final BlogMapper blogMapper;
    private final BlogRepository blogRepository;

    public void addBlog(BlogRequest blogRequest) {
        log.info("addBLog().start"+blogRequest);
        BlogEntity blogEntity = blogMapper.requestToEntity(blogRequest);
        blogRepository.save(blogEntity);
        log.info("addBLog ().start");
    }
    public void addBlogs(Integer a) {
        log.info("addBLog().start"+a);
        BlogEntity blogEntity = new BlogEntity();
        blogEntity.setPlus(a);
        blogRepository.save(blogEntity);
        log.info("addBLog ().start");
    }


    public BlogResponse getBlogById(Integer id) {
        log.info("getBlogById().start " + id);
        BlogEntity blogEntity = blogRepository.findById(id)
                .orElseThrow(() ->new AppException(id, BLOG_NOT_FOUND));
        BlogResponse blogResponse = blogMapper.entityToBlogResponse(blogEntity);
        log.info("getBlogById().end " + blogEntity);
        return blogResponse;
    }

    public List<BlogResponse> getAllBlogs() {
        log.info("getAllBlogs().start");
        List<BlogEntity> blogEntities = blogRepository.findAll();
        List<BlogResponse> blogResponses = blogMapper.entityToBlogResponseList(blogEntities);
        log.info("getAllBlogs().end");
        return blogResponses;
    }

    public void updateBlogById(Integer id, BlogRequest blogRequest) {
        log.info("updateBlogById().start " + id);
        BlogEntity blogEntity = blogRepository.findById(id)
                .orElseThrow(() -> new AppException(id, BLOG_NOT_FOUND));
        if (Objects.nonNull(blogRequest.getTitle())) {
            blogEntity.setTitle(blogRequest.getTitle());
        }

        if (Objects.nonNull(blogRequest.getDescription())) {
            blogEntity.setDescription(blogRequest.getDescription());
        }

        if (Objects.nonNull(blogRequest.getImage())) {
            blogEntity.setImage(blogRequest.getImage());
        }

        log.info("updateBlogById().end " + id);
    }

    public void deleteBlogById(Integer id) {
        log.info("deleteBlogById().start " + id);
        blogRepository.findById(id).orElseThrow(() -> new RuntimeException("Lesson not found " + id));
        blogRepository.deleteById(id);
        log.info("deleteBlogById().end " + id);
    }
}
