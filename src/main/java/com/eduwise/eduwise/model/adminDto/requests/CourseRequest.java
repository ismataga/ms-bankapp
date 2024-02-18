package com.eduwise.eduwise.model.adminDto.requests;

import java.math.BigInteger;
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
public class CourseRequest {
    private String name;
    private String description;
    private String coverImageUrl;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;
    private String instructorName;
    private String instructorPhoto;
    private BigInteger monthlyPrice;
    private BigInteger quarterlyPrice;
    private BigInteger annuallyPrice;
    private BigInteger semiAnnuallyPrice;
}