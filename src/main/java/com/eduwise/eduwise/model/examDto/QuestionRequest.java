package com.eduwise.eduwise.model.examDto;

import java.util.List;
import java.util.Optional;
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
public class QuestionRequest {
    private String questionText;
    private List<OptionDTO> options;
    private String explanation;
    private int pointsForCorrect;
    private int pointsForIncorrect;
    private String name;
    private Integer folderId;
}
