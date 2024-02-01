package com.eduwise.eduwise.model.examDto;

import java.time.Duration;
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
public class ExamDetailsResponse {
    private String name;
    private Duration duration;
    private String info;
    private LocalDateTime startTime;
    private LocalDateTime lastEnterTime;
    private boolean explainAnswersAfterward;
    private boolean acceptChecksLater;
    private int maxPurchases;
    private boolean isLive;
}
