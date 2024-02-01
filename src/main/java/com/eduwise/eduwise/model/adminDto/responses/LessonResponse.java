package com.eduwise.eduwise.model.adminDto.responses;

import com.eduwise.eduwise.configration.DurationDeserializer;
import com.eduwise.eduwise.configration.DurationSerializer;
import com.eduwise.eduwise.model.enums.LessonType;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
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
    private Integer id;
    private String title;
    private String videoUrl;
    private String lastPlaceStay;
    private String description;
//    @JsonSerialize(using = DurationSerializer.class)
//    @JsonDeserialize(using = DurationDeserializer.class)
    private Duration duration;
    private Boolean isCompleted;
    private LessonType lessonType;
//    private Integer sectionId;
}
