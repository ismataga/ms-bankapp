package com.eduwise.eduwise.model.examDto;

import com.eduwise.eduwise.entity.examEntity.ExamDetails;
import com.eduwise.eduwise.entity.examEntity.ExamPublish;
import com.eduwise.eduwise.entity.examEntity.ExamQuestion;
import com.eduwise.eduwise.entity.examEntity.ExamSubject;
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
public class ExamRequest {
    private String name;
    private ExamDetails examDetails;
    private List<ExamSubject> examSubjects;
    private List<ExamQuestion> examQuestions;
    private ExamPublish publish;
}
