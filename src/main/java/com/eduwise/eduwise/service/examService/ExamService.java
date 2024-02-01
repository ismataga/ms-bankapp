package com.eduwise.eduwise.service.examService;

import static com.eduwise.eduwise.model.enums.ExceptionConstants.EXAM_NOT_FOUND;
import static com.eduwise.eduwise.model.enums.ExceptionConstants.EXAM_PUBLISH_NOT_FOUND;

import com.eduwise.eduwise.entity.examEntity.Exam;
import com.eduwise.eduwise.entity.examEntity.ExamDetails;
import com.eduwise.eduwise.entity.examEntity.ExamQuestion;
import com.eduwise.eduwise.entity.examEntity.ExamSubject;
import com.eduwise.eduwise.exception.AppException;
import com.eduwise.eduwise.mapper.examMapper.ExamMapper;
import com.eduwise.eduwise.model.examDto.ExamDetailsRequest;
import com.eduwise.eduwise.model.examDto.ExamQuestionRequest;
import com.eduwise.eduwise.model.examDto.ExamRequest;
import com.eduwise.eduwise.model.examDto.ExamResponse;
import com.eduwise.eduwise.model.examDto.ExamSubjectRequest;
import com.eduwise.eduwise.repository.examRepository.ExamRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@Transactional
@RequiredArgsConstructor
public class ExamService {
    private final ExamRepository examRepository;
    private final ExamMapper examMapper;

    public ExamResponse createExam(ExamRequest examRequest) {
        log.info("createExam().start");

        Exam exam = examMapper.mapToEntity(examRequest);
        Exam savedExam = examRepository.save(exam);
        return examMapper.mapToDto(savedExam);
    }

    public ExamResponse getExamById(Integer examId) {
        log.info("getExamById().start");
        Optional<Exam> optionalExam = examRepository.findById(examId);
        if (optionalExam.isPresent()) {
            return examMapper.mapToDto(optionalExam.get());
        } else {
            throw new AppException(examId, EXAM_NOT_FOUND);
        }
    }

    public ExamResponse updateExam(Integer examId, ExamRequest examRequest) {
        log.info("updateExam().start");
       Exam optionalExam = examRepository.findById(examId)
               .orElseThrow(() -> new AppException(examId, EXAM_NOT_FOUND));
       optionalExam.setName(examRequest.getName());
       examRepository.save(optionalExam);
        return examMapper.mapToDto(optionalExam);

    }

    public void deleteExam(Integer examId) {
        log.info("deleteExam().start");
        examRepository.deleteById(examId);
        log.info("deleteExam ().end ");

    }
}
