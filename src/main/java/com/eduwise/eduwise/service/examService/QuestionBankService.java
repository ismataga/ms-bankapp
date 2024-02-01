package com.eduwise.eduwise.service.examService;

import static com.eduwise.eduwise.model.enums.ExceptionConstants.QUESTION_BANK_NOT_FOUND;

import com.eduwise.eduwise.entity.examEntity.QuestionBank;
import com.eduwise.eduwise.exception.AppException;
import com.eduwise.eduwise.mapper.examMapper.QuestionBankMapper;
import com.eduwise.eduwise.model.examDto.QuestionBankRequest;
import com.eduwise.eduwise.model.examDto.QuestionBankResponse;
import com.eduwise.eduwise.repository.examRepository.QuestionBankRepository;
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
public class QuestionBankService {
    private final QuestionBankRepository questionBankRepository;
    private final QuestionBankMapper questionBankMapper;

    @Transactional
    public List<QuestionBankResponse> getAllQuestionsBank() {
        log.info("getAllQuestionsBank().start");
        return questionBankRepository.findAll().stream()
                .map(questionBankMapper::mapToResponse)
                .collect(Collectors.toList());
    }

    @Transactional
    public QuestionBankResponse getQuestionBankById(Integer id) {
        log.info("getQuestionBankById().start " + id);
        return questionBankRepository.findById(id)
                .map(questionBankMapper::mapToResponse)
                .orElseThrow(() -> new AppException(id, QUESTION_BANK_NOT_FOUND));
    }

    @Transactional
    public Integer createQuestionBank(QuestionBankRequest request) {
        log.info("createQuestionBank().start " + request);
        QuestionBank question = questionBankRepository.save(questionBankMapper.mapToEntity(request));
        return question.getId();


    }

    @Transactional
    public void updateQuestionBank(Integer id, QuestionBankRequest request) {
        log.info("updateQuestionBank().start " + request + " id " + id);

        QuestionBank existingQuestionBank = questionBankRepository.findById(id)
                .orElseThrow(() -> new AppException(id, QUESTION_BANK_NOT_FOUND));

        existingQuestionBank.setId(request.getId());
        questionBankRepository.save(existingQuestionBank);
        log.info("updateQuestionBank ().end " + existingQuestionBank);
    }

    @Transactional
    public void deleteQuestionBank(Integer id) {
        log.info("deleteQuestionBank().start id " + id);
        questionBankRepository.deleteById(id);
        log.info("deleteQuestionBank ().end");
    }
}
