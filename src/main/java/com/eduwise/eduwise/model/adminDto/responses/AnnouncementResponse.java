package com.eduwise.eduwise.model.adminDto.responses;

import java.time.LocalDateTime;
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
public class AnnouncementResponse {
    private String title;
    private String description;
    private byte[] image;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
