package com.eduwise.eduwise.service.examService;

import static com.eduwise.eduwise.model.enums.ExceptionConstants.EXAM_NOT_FOUND;
import static com.eduwise.eduwise.model.enums.ExceptionConstants.EXAM_SUBJECT_NOT_FOUND;

import com.eduwise.eduwise.entity.examEntity.ExamSubject;
import com.eduwise.eduwise.exception.AppException;
import com.eduwise.eduwise.mapper.examMapper.ExamSubjectMapper;
import com.eduwise.eduwise.model.examDto.ExamSubjectRequest;
import com.eduwise.eduwise.model.examDto.ExamSubjectResponse;
import com.eduwise.eduwise.repository.examRepository.ExamSubjectRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@Transactional
@RequiredArgsConstructor
public class ExamSubjectService {
    private final ExamSubjectRepository examSubjectRepository;

    private final ExamSubjectMapper examSubjectMapper;

    public ExamSubjectResponse createExamSubject(ExamSubjectRequest examSubjectRequest) {
        log.info("createExamSubject().start");
        ExamSubject examSubject = examSubjectMapper.mapToEntity(examSubjectRequest);
        ExamSubject savedExamSubject = examSubjectRepository.save(examSubject);
        return examSubjectMapper.mapToDto(savedExamSubject);
    }

    public ExamSubjectResponse getExamSubjectById(Integer examSubjectId) {
        log.info("getExamSubjectById().start");
        ExamSubject examSubject = examSubjectRepository.findById(examSubjectId)
                .orElseThrow(() -> new AppException(examSubjectId, EXAM_SUBJECT_NOT_FOUND));
        return examSubjectMapper.mapToDto(examSubject);
    }

    public ExamSubjectResponse updateExamSubject(Integer examSubjectId, ExamSubjectRequest examSubjectRequest) {
        log.info("updateExamSubject().start");
        ExamSubject examSubject = examSubjectRepository.findById(examSubjectId)
                .orElseThrow(() ->  new AppException(examSubjectId, EXAM_SUBJECT_NOT_FOUND));

        ExamSubject updatedExamSubject = examSubjectRepository.save(examSubject);
        return examSubjectMapper.mapToDto(updatedExamSubject);
    }

    public void deleteExamSubject(Integer examSubjectId) {
        log.info("deleteExamSubject().start");
        examSubjectRepository.deleteById(examSubjectId);
        log.info("deleteExamSubject().end");
    }
}
