package com.eduwise.eduwise.model.adminDto.responses;

import java.util.List;
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
public class SectionResponse {
    private String name;
    private Long duration;
    private Integer articleCount;
    private List<LessonResponse> lessons;
}
