package com.eduwise.eduwise.model.adminDto.requests;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public record RatingRequest(Long courseId, @Max(5) @Min(1) Integer rate ,String review) {
}
