package com.eduwise.eduwise.model.adminDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RatingStatistic {
    private Long courseId;
    private Double averageRate;
    private Long totalRateCount;
    private Long oneStarRateCount;
    private Long twoStarRateCount;
    private Long threeStarRateCount;
    private Long fourStarRateCount;
    private Long fiveStarRateCount;
}
