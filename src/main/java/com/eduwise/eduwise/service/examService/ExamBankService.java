package com.eduwise.eduwise.service.examService;

import static com.eduwise.eduwise.model.enums.ExceptionConstants.EXAM_BANK_NOT_FOUND;

import com.eduwise.eduwise.entity.examEntity.ExamBank;
import com.eduwise.eduwise.exception.AppException;
import com.eduwise.eduwise.mapper.examMapper.ExamBankMapper;
import com.eduwise.eduwise.model.examDto.ExamBankRequest;
import com.eduwise.eduwise.model.examDto.ExamBankResponse;
import com.eduwise.eduwise.repository.examRepository.ExamBankRepository;
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
public class ExamBankService {
    private final ExamBankRepository examBankRepository;
    private final ExamBankMapper examBankMapper;

    public List<ExamBankResponse> getExamBankList() {
        log.info("getAllFolders().start");
        return examBankRepository.findAll().stream()
                .map(examBankMapper::mapToResponse)
                .collect(Collectors.toList());
    }

    public ExamBankResponse getExamBankById(Integer id) {
        log.info("getExamBankById().start " + id);
        return examBankRepository.findById(id)
                .map(examBankMapper::mapToResponse)
                .orElseThrow(() -> new AppException(id, EXAM_BANK_NOT_FOUND));
    }

    public ExamBankResponse createExamBank(ExamBankRequest request) {
        log.info("createExamBank().start " + request);
        ExamBank examBank = examBankRepository.save(examBankMapper.mapToEntity(request));
        return examBankMapper.mapToResponse(examBank);
    }

    public void updateBankExam(Integer id, ExamBankRequest request) {
        log.info("updateBankExam().start " + request + " id " + id);

        ExamBank examBank = examBankRepository.findById(id)
                .orElseThrow(() -> new AppException(id, EXAM_BANK_NOT_FOUND));

        examBank.setName(request.getName());

        examBankRepository.save(examBank);
        log.info("updateBankExam ().end " + examBank);

    }

    public void deleteBankExam(Integer id) {
        log.info("deleteBankExam().start id " + id);
        examBankRepository.deleteById(id);
        log.info("deleteBankExam ().end");
    }
}
