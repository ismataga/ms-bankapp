package com.eduwise.eduwise.model.adminDto.requests;

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
public class LessonRequest {
    private String title;
    private String url;
    private String description;
//    @JsonSerialize(using = DurationSerializer.class)
//    @JsonDeserialize(using = DurationDeserializer.class)
    private Long duration;
    private LessonType lessonType;
}

