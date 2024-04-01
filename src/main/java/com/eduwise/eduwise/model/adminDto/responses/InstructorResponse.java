package com.eduwise.eduwise.model.adminDto.responses;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class InstructorResponse {
    private String fullname;
    private String instructorPhoto;

}
