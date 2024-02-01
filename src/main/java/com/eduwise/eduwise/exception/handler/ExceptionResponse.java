package com.eduwise.eduwise.exception.handler;

import com.eduwise.eduwise.model.enums.ExceptionConstants;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class ExceptionResponse {
    private String userMessage;
    private String errorMessage;
    private List<ValidationErrorResponse> validationErrors;
    @Builder.Default
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime date = LocalDateTime.now();

    public ExceptionResponse(ExceptionConstants exceptionConstants, String errorMessage) {
        this.errorMessage = errorMessage;
        this.userMessage = exceptionConstants.getUserMessage();
    }
}
