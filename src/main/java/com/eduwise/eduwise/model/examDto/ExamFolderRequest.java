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
public class ExamFolderRequest {
    private String folderName;
    private List<ExamRequest> exams;
    private List<ExamFolderRequest> subFolders;
}
