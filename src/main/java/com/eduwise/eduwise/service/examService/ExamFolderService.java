package com.eduwise.eduwise.service.examService;

import static com.eduwise.eduwise.model.enums.ExceptionConstants.EXAM_DETAIL_NOT_FOUND;
import static com.eduwise.eduwise.model.enums.ExceptionConstants.EXAM_FOLDER_NOT_FOUND;

import com.eduwise.eduwise.entity.examEntity.ExamFolder;
import com.eduwise.eduwise.exception.AppException;
import com.eduwise.eduwise.mapper.examMapper.ExamFolderMapper;
import com.eduwise.eduwise.model.examDto.ExamFolderRequest;
import com.eduwise.eduwise.model.examDto.ExamFolderResponse;
import com.eduwise.eduwise.repository.examRepository.ExamFolderRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@Transactional
@RequiredArgsConstructor
public class ExamFolderService {

    private final ExamFolderRepository examFolderRepository;
    private final ExamFolderMapper examFolderMapper;

    public ExamFolderResponse createExamFolder(ExamFolderRequest examFolderRequest) {
        log.info("createExamFolder().start");
        ExamFolder examFolder = examFolderMapper.mapToEntity(examFolderRequest);
        ExamFolder savedExamFolder = examFolderRepository.save(examFolder);
        return examFolderMapper.mapToDto(savedExamFolder);
    }

    public ExamFolderResponse getExamFolderById(Integer examFolderId) {
        log.info("getExamFolderById().start");
        ExamFolder examFolder = examFolderRepository.findById(examFolderId)
                .orElseThrow(() -> new AppException(examFolderId, EXAM_FOLDER_NOT_FOUND));
        return examFolderMapper.mapToDto(examFolder);
    }

    public List<ExamFolderResponse> getExamFolderList() {
        log.info("getExamFolderList().start");
        List<ExamFolder> examFolderList = examFolderRepository.findAll();
        return examFolderMapper.mapToDtoList(examFolderList);
    }

    public ExamFolderResponse updateExamFolder(Integer examFolderId, ExamFolderRequest examFolderRequest) {
        log.info("updateExamFolder().start");
        ExamFolder examFolder = examFolderRepository.findById(examFolderId)
                .orElseThrow(() -> new AppException(examFolderId, EXAM_FOLDER_NOT_FOUND));
        examFolder.setFolderName(examFolderRequest.getFolderName());
        ExamFolder updatedExamFolder = examFolderRepository.save(examFolder);
        return examFolderMapper.mapToDto(updatedExamFolder);
    }

    public void deleteExamFolder(Integer examFolderId) {
        log.info("deleteExamFolder().start");
        examFolderRepository.deleteById(examFolderId);
        log.info("deleteExamFolder().end");
    }
}
