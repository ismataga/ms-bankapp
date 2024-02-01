package com.eduwise.eduwise.mapper.admin;

import com.eduwise.eduwise.entity.LessonEntities.AnnouncementsEntity;
import com.eduwise.eduwise.model.adminDto.requests.AnnouncementRequest;
import com.eduwise.eduwise.model.adminDto.responses.AnnouncementResponse;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AnnouncementMapper {

    AnnouncementsEntity requestToEntity(AnnouncementRequest announcementRequest);

    AnnouncementResponse entityToAnnouncementResponse(AnnouncementsEntity announcementsEntity);

    List<AnnouncementResponse> entityToAnnouncementResponseList(List<AnnouncementsEntity> announcementsEntities);
}
