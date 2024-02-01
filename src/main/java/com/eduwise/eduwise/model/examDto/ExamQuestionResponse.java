package com.eduwise.eduwise.model.examDto;

import com.eduwise.eduwise.entity.examEntity.Question;
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
public class ExamQuestionResponse {
    private Long id;
    private String name;
    private List<Question> questions;
}
