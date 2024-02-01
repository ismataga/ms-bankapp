package com.eduwise.eduwise.service.examService;

import static com.eduwise.eduwise.model.enums.ExceptionConstants.EXAM_BANK_NOT_FOUND;
import static com.eduwise.eduwise.model.enums.ExceptionConstants.EXAM_PUBLISH_NOT_FOUND;

import com.eduwise.eduwise.entity.examEntity.ExamPublish;
import com.eduwise.eduwise.exception.AppException;
import com.eduwise.eduwise.mapper.examMapper.ExamPublishMapper;
import com.eduwise.eduwise.model.examDto.ExamPublishRequest;
import com.eduwise.eduwise.model.examDto.ExamPublishResponse;
import com.eduwise.eduwise.repository.examRepository.ExamPublishRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@Transactional
@RequiredArgsConstructor
public class ExamPublishService {
    private final ExamPublishRepository examPublishRepository;
    private final ExamPublishMapper examPublishMapper;

    public ExamPublishResponse createExamPublish(ExamPublishRequest examPublishRequest) {
        log.info("createExamPublish().start");
        ExamPublish examPublish = examPublishMapper.mapToEntity(examPublishRequest);
        ExamPublish savedExamPublish = examPublishRepository.save(examPublish);
        return examPublishMapper.mapToDto(savedExamPublish);
    }

    public ExamPublishResponse getExamPublishById(Integer examPublishId) {
        log.info("getExamPublishById().start");
        ExamPublish examPublish = examPublishRepository.findById(examPublishId)
                .orElseThrow(() ->  new AppException(examPublishId, EXAM_PUBLISH_NOT_FOUND));
        return examPublishMapper.mapToDto(examPublish);
    }

    public ExamPublishResponse updateExamPublish(Integer examPublishId, ExamPublishRequest examPublishRequest) {
        log.info("updateExamPublish().start");
        ExamPublish examPublish = examPublishRepository.findById(examPublishId)
                .orElseThrow(() ->  new AppException(examPublishId, EXAM_PUBLISH_NOT_FOUND));
        examPublish.setPublicationDetails(examPublishRequest.getPublicationDetails());
        ExamPublish updatedExamPublish = examPublishRepository.save(examPublish);
        return examPublishMapper.mapToDto(updatedExamPublish);
    }

    public void deleteExamPublish(Integer examPublishId) {
        log.info("deleteExamPublish().start");
        examPublishRepository.deleteById(examPublishId);
        log.info("deleteExamPublish().end");
    }
}
