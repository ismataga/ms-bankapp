package com.eduwise.eduwise.service.examService;


import static com.eduwise.eduwise.model.enums.ExceptionConstants.FOLDER_NOT_FOUND;

import com.eduwise.eduwise.entity.examEntity.Folder;
import com.eduwise.eduwise.exception.AppException;
import com.eduwise.eduwise.mapper.examMapper.FolderMapper;
import com.eduwise.eduwise.model.examDto.FolderRequest;
import com.eduwise.eduwise.model.examDto.FolderResponse;
import com.eduwise.eduwise.repository.examRepository.FolderRepository;
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
public class FolderService {
    private final FolderRepository folderRepository;
    private final FolderMapper folderMapper;

    @Transactional
    public List<FolderResponse> getAllFolders() {
        log.info("getAllFolders().start");
        return folderRepository.findAll().stream()
                .map(folderMapper::mapToResponse)
                .collect(Collectors.toList());
    }

    @Transactional
    public FolderResponse getFolderById(Integer id) {
        log.info("getFolderById().start " + id);
        return folderRepository.findById(id)
                .map(folderMapper::mapToResponse)
                .orElseThrow(() -> new AppException(id, FOLDER_NOT_FOUND));
    }

    @Transactional
    public Integer createFolder(FolderRequest request) {
        log.info("createFolder().start " + request);
        Folder folder = folderRepository.save(folderMapper.mapToEntity(request));
        return folder.getId();
    }

    @Transactional
    public void updateFolder(Integer id, FolderRequest request) {
        log.info("updateFolder().start " + request + " id " + id);

        Folder existingFolder = folderRepository.findById(id)
                .orElseThrow(() -> new AppException(id, FOLDER_NOT_FOUND));

        existingFolder.setName(request.getName());

        folderRepository.save(existingFolder);
        log.info("updateQuestion ().end " + existingFolder);

    }

    @Transactional
    public void deleteFolder(Integer id) {
        log.info("deleteFolder().start id " + id);
        folderRepository.deleteById(id);
        log.info("deleteFolder ().end");
    }
}
