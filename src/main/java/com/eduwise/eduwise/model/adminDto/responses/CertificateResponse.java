package com.eduwise.eduwise.model.adminDto.responses;

import com.eduwise.eduwise.model.adminDto.requests.CourseRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CertificateResponse {
    private Integer certificateId;
    private Integer courseId;
}
