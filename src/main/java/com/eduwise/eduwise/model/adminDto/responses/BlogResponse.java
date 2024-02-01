package com.eduwise.eduwise.model.adminDto.responses;

import java.time.Instant;
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
public class BlogResponse {
    private String title;
    private String description;
    private Instant duration;
    private byte[] image;
}
