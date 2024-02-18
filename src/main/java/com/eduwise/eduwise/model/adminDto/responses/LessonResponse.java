package com.eduwise.eduwise.model.adminDto.responses;

import com.eduwise.eduwise.model.enums.LessonType;
import java.time.Duration;
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
public class LessonResponse {
    private String title;
    private String lastPlaceStay;
    private String description;
    private Long duration;
    private Boolean isCompleted;
    private LessonType lessonType;
}
