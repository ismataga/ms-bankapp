package com.eduwise.eduwise.mapper.admin;

import com.eduwise.eduwise.entity.LessonEntities.CertificateEntity;
import com.eduwise.eduwise.model.adminDto.requests.CertificateRequest;
import com.eduwise.eduwise.model.adminDto.responses.CertificateResponse;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CertificateMapper {
    CertificateEntity requestToEntity(CertificateRequest certificateRequest);

    CertificateResponse entityToBlogResponse(CertificateEntity certificateEntity);

    List<CertificateResponse> entityToBlogResponseList(List<CertificateEntity> certificateEntity);
}
