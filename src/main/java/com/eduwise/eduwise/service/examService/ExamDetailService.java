package com.eduwise.eduwise.service.examService;

import static com.eduwise.eduwise.model.enums.ExceptionConstants.EXAM_BANK_NOT_FOUND;
import static com.eduwise.eduwise.model.enums.ExceptionConstants.EXAM_DETAIL_NOT_FOUND;

import com.eduwise.eduwise.entity.examEntity.ExamDetails;
import com.eduwise.eduwise.exception.AppException;
import com.eduwise.eduwise.mapper.examMapper.ExamDetailsMapper;
import com.eduwise.eduwise.model.examDto.ExamDetailsRequest;
import com.eduwise.eduwise.model.examDto.ExamDetailsResponse;
import com.eduwise.eduwise.repository.examRepository.ExamDetailsRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@Transactional
@RequiredArgsConstructor
public class ExamDetailService {
    private final ExamDetailsRepository examDetailsRepository;

    private final ExamDetailsMapper examDetailsMapper;

    public ExamDetailsResponse createExamDetails(ExamDetailsRequest examDetailsRequestDTO) {
        log.info("createExamDetails().start");
        ExamDetails examDetails = examDetailsMapper.mapToEntity(examDetailsRequestDTO);

        ExamDetails savedExamDetails = examDetailsRepository.save(examDetails);
        return examDetailsMapper.mapToDto(savedExamDetails);
    }

    public ExamDetailsResponse getExamDetailsById(Integer examDetailsId) {
        log.info("getExamDetailsById().start");
        ExamDetails examDetails = examDetailsRepository.findById(examDetailsId)
                .orElseThrow(() ->  new AppException(examDetailsId, EXAM_DETAIL_NOT_FOUND));
        return examDetailsMapper.mapToDto(examDetails);
    }

    public List<ExamDetailsResponse> getExamDetailsList() {
        log.info("getExamDetailsList().start");
        List<ExamDetails> examDetailsList = examDetailsRepository.findAll();
        return examDetailsMapper.mapToDtoList(examDetailsList);
    }

    public ExamDetailsResponse updateExamDetails(Integer examDetailsId, ExamDetailsRequest examDetailsRequest) {
        log.info("updateExamDetails().start");

        ExamDetails examDetails = examDetailsRepository.findById(examDetailsId)
                .orElseThrow(() -> new AppException(examDetailsId, EXAM_DETAIL_NOT_FOUND));
        examDetails.setName(examDetailsRequest.getName());
        examDetails.setInfo(examDetailsRequest.getInfo());
        examDetails.setDuration(examDetailsRequest.getDuration());
        examDetails.setLive(examDetailsRequest.isLive());
        examDetails.setMaxPurchases(examDetailsRequest.getMaxPurchases());
        examDetails.setStartTime(examDetailsRequest.getStartTime());
        examDetails.setLastEnterTime(examDetailsRequest.getLastEnterTime());
        examDetails.setExplainAnswersAfterward(examDetailsRequest.isExplainAnswersAfterward());
        examDetails.setAcceptChecksLater(examDetailsRequest.isAcceptChecksLater());
        ExamDetails updatedExamDetails = examDetailsRepository.save(examDetails);
        log.info("updateExamDetails ().end ");
        return examDetailsMapper.mapToDto(updatedExamDetails);

    }

    public void deleteExamDetails(Integer examDetailsId) {
        log.info("deleteExamDetails().start");
        examDetailsRepository.deleteById(examDetailsId);
        log.info("updateExamDetails ().end ");
    }
}
