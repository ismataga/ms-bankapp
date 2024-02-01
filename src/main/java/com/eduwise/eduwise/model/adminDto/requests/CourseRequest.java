package com.eduwise.eduwise.model.adminDto.requests;

import java.math.BigInteger;
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
    private byte[] coverImage;
    //    @JsonSerialize(using = DurationSerializer.class)
//    @JsonDeserialize(using = DurationDeserializer.class)
//    private Duration duration;
    private String instructor;
    private String url;
    private BigInteger monthlyPrice;
    private BigInteger quarterlyPrice;
    private BigInteger annuallyPrice;
    private BigInteger semiAnnuallyPrice;
}