package com.eduwise.eduwise.service.examService;

import static com.eduwise.eduwise.model.enums.ExceptionConstants.QUESTION_BANK_NOT_FOUND;
import static com.eduwise.eduwise.model.enums.ExceptionConstants.QUESTION_NOT_FOUND;

import com.eduwise.eduwise.entity.examEntity.Question;
import com.eduwise.eduwise.exception.AppException;
import com.eduwise.eduwise.mapper.examMapper.QuestionMapper;
import com.eduwise.eduwise.model.examDto.QuestionRequest;
import com.eduwise.eduwise.model.examDto.QuestionResponse;
import com.eduwise.eduwise.repository.examRepository.QuestionRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@Transactional
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;
    private final QuestionMapper questionMapper;

    @Transactional
    public List<QuestionResponse> getAllQuestions() {
        log.info("getAllQuestions().start");
        return questionRepository.findAll().stream()
                .map(questionMapper::mapToResponse)
                .collect(Collectors.toList());
    }

    @Transactional
    public QuestionResponse getQuestionById(Integer id) {
        log.info("getQuestionById().start "+id);
        return questionRepository.findById(id)
                .map(questionMapper::mapToResponse)
                .orElseThrow(() -> new AppException(id, QUESTION_NOT_FOUND));
    }

    @Transactional
    public Integer createQuestion(QuestionRequest request) {
        log.info("createQuestion().start "+request);
        Question question = questionRepository.save(questionMapper.mapToEntity(request));
        return question.getId();


    }

    @Transactional
    public void updateQuestion(Integer id, QuestionRequest request) {
        log.info("updateQuestion().start "+request+" id "+id);

        Question existingQuestion = questionRepository.findById(id)
                .orElseThrow(() -> new AppException(id, QUESTION_NOT_FOUND));

        existingQuestion.setQuestionText(request.getQuestionText());
        existingQuestion.setPointsForCorrect(request.getPointsForCorrect());
        existingQuestion.setExplanation(request.getExplanation());
        existingQuestion.setPointsForIncorrect(request.getPointsForIncorrect());
        existingQuestion.setName(request.getName());

        questionRepository.save(existingQuestion);
        log.info("updateQuestion ().end " +existingQuestion);

    }

    @Transactional
    public void deleteQuestion(Integer id) {
        log.info("updateQuestion().start id "+id);
        questionRepository.deleteById(id);
        log.info("updateQuestion ().end");
    }
}
