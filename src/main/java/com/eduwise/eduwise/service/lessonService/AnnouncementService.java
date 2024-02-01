package com.eduwise.eduwise.service.lessonService;

import static com.eduwise.eduwise.model.enums.ExceptionConstants.ANNOUNCEMENT_NOT_FOUND;
import static com.eduwise.eduwise.model.enums.ExceptionConstants.QUESTION_NOT_FOUND;

import com.eduwise.eduwise.entity.LessonEntities.AnnouncementsEntity;
import com.eduwise.eduwise.exception.AppException;
import com.eduwise.eduwise.mapper.admin.AnnouncementMapper;
import com.eduwise.eduwise.model.adminDto.requests.AnnouncementRequest;
import com.eduwise.eduwise.model.adminDto.responses.AnnouncementResponse;
import com.eduwise.eduwise.repository.lessonRepository.AnnouncementRepository;
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
public class AnnouncementService {
    private final AnnouncementMapper announcementMapper;
    private final AnnouncementRepository announcementRepository;

    public void addAnnouncement(AnnouncementRequest announcementRequest) {
        log.info("addAnnouncement().start" + announcementRequest);
        AnnouncementsEntity announcementsEntity = announcementMapper.requestToEntity(announcementRequest);
        announcementRepository.save(announcementsEntity);
        log.info("addAnnouncement ().end");
    }

    public AnnouncementResponse getAnnouncementById(Integer id) {
        log.info("getAnnouncementById().start " + id);
        AnnouncementsEntity announcementsEntity = announcementRepository.findById(id)
                .orElseThrow(() -> new AppException(id, ANNOUNCEMENT_NOT_FOUND));
        AnnouncementResponse announcementResponse = announcementMapper.entityToAnnouncementResponse(announcementsEntity);
        log.info("getAnnouncementById().end " + announcementsEntity);
        return announcementResponse;
    }

    public List<AnnouncementResponse> getAnnouncementList() {
        log.info("getAnnouncementList().start");
        List<AnnouncementsEntity> announcementsEntities = announcementRepository.findAll();
        List<AnnouncementResponse> announcementResponses = announcementMapper.entityToAnnouncementResponseList(announcementsEntities);
        log.info("getAnnouncementList().end");
        return announcementResponses;
    }

    public void updateAnnouncementById(Integer id, AnnouncementRequest announcementRequest) {
        log.info("updateAnnouncementById().start " + id);
        AnnouncementsEntity announcementsEntity = announcementRepository.findById(id)
                .orElseThrow(() -> new AppException(id, ANNOUNCEMENT_NOT_FOUND));
        if (Objects.nonNull(announcementRequest.getTitle())) {
            announcementsEntity.setTitle(announcementRequest.getTitle());
        }

        if (Objects.nonNull(announcementRequest.getDescription())) {
            announcementsEntity.setDescription(announcementRequest.getDescription());
        }

        if (Objects.nonNull(announcementRequest.getImage())) {
            announcementsEntity.setImage(announcementRequest.getImage());
        }
        if (Objects.nonNull(announcementRequest.getEndTime())) {
            announcementsEntity.setEndTime(announcementRequest.getEndTime());
        }
        if (Objects.nonNull(announcementRequest.getStartTime())) {
            announcementsEntity.setStartTime(announcementRequest.getStartTime());
        }

        log.info("updateAnnouncementById().end " + id);
    }

    public void deleteAnnouncementById(Integer id) {
        log.info("deleteAnnouncementById().start " + id);
        announcementRepository.findById(id).orElseThrow(() -> new RuntimeException("Lesson not found " + id));
        announcementRepository.deleteById(id);
        log.info("deleteAnnouncementById().end " + id);
    }
}
