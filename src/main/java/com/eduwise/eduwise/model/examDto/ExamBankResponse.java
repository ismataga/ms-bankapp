package com.eduwise.eduwise.model.examDto;

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
public class ExamBankResponse {
    private Integer id;
    private String name;
    private List<ExamResponse> exams;
}
