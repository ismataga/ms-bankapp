package com.eduwise.eduwise.controller.admin;

import com.eduwise.eduwise.model.adminDto.requests.AnnouncementRequest;
import com.eduwise.eduwise.model.adminDto.responses.AnnouncementResponse;
import com.eduwise.eduwise.service.lessonService.AnnouncementService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/announcements")
@SecurityRequirement(name = "bearerAuth")
public class AnnouncementController {
    private final AnnouncementService announcementService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addAnnouncement(@RequestBody AnnouncementRequest announcementRequest) {
        log.info("addAnnouncement().start"+announcementRequest);
        announcementService.addAnnouncement(announcementRequest);
        log.info("addAnnouncement().end" );
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AnnouncementResponse getAnnouncementById(@PathVariable Integer id) {
        return announcementService.getAnnouncementById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AnnouncementResponse> getAnnouncementList() {
        return announcementService.getAnnouncementList();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateAnnouncementById(@PathVariable Integer id, @RequestBody AnnouncementRequest announcementRequest) {
        announcementService.updateAnnouncementById(id, announcementRequest);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAnnouncementById(@PathVariable Integer id) {
        announcementService.deleteAnnouncementById(id);
    }

}
