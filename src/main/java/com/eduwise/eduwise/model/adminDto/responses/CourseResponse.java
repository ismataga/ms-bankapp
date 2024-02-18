package com.eduwise.eduwise.model.adminDto.responses;

import com.eduwise.eduwise.entity.User;
import com.eduwise.eduwise.model.adminDto.RatingStatistic;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigInteger;
import java.time.LocalDateTime;
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
public class CourseResponse {
    private Integer id;
    private String name;
    private String description;
    private String coverImageUrl;
    private Long duration;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateAt;
    private Integer studentCount;
    private List<User> instructors;
    private Integer quizCount;
    private Integer articleCount;
    private BigInteger monthlyPrice;
    private BigInteger quarterlyPrice;
    private BigInteger annuallyPrice;
    private BigInteger semiAnnuallyPrice;
    private boolean bestSeller;
    private List<SectionResponse> sections;
    private RatingStatistic ratings;
    private List<RatingResponse> ratingEntities;
}
