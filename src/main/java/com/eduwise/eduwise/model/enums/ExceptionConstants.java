package com.eduwise.eduwise.model.enums;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.METHOD_NOT_ALLOWED;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ExceptionConstants {

    // common exceptions
    UNEXPECTED_EXCEPTION("unexpected exception", INTERNAL_SERVER_ERROR),
    METHOD_NOT_ALLOWED_EXCEPTION("method not allowed exception", METHOD_NOT_ALLOWED),
    METHOD_ARGUMENT_NOT_VALID("method argument not valid", BAD_REQUEST),
    NOT_FOUND_EXCEPTION("", NOT_FOUND),

    // auth-service
    DUPLICATE_EMAIL_EXCEPTION("duplicate email exception ", BAD_REQUEST),
    EMAIL_CODE_EXPIRED_EXCEPTION("email confirmation code already expired", BAD_REQUEST),

    //email-service
    EXAM_BANK_NOT_FOUND("examBank not found with id: ", NOT_FOUND),
    EXAM_DETAIL_NOT_FOUND("examDetail not found with id: ", NOT_FOUND),
    EXAM_FOLDER_NOT_FOUND("examFolder not found with id: ", NOT_FOUND),
    EXAM_PUBLISH_NOT_FOUND("examPublish not found with id: ", NOT_FOUND),
    EXAM_NOT_FOUND("exam not found with id: ", NOT_FOUND),
    EXAM_SUBJECT_NOT_FOUND("examSubject not found with id: ", NOT_FOUND),
    QUESTION_BANK_NOT_FOUND("questionBank not found with id: ", NOT_FOUND),
    QUESTION_NOT_FOUND("question not found with id: ", NOT_FOUND),
    FOLDER_NOT_FOUND("folder not found with id: ", NOT_FOUND),


    //lessons-service
    ANNOUNCEMENT_NOT_FOUND("question not found with id: ", NOT_FOUND),
    BLOG_NOT_FOUND("blog not found with id: ", NOT_FOUND),
    ARTICLE_NOT_FOUND("article not found with id: ", NOT_FOUND),
    CERTIFICATE_NOT_FOUND("certificate not found with id: ", NOT_FOUND),
    COURSE_NOT_FOUND("course not found with id: ", NOT_FOUND),
    LESSON_NOT_FOUND("lesson not found with id: ", NOT_FOUND),
    SECTION_NOT_FOUND("section not found with id: ", NOT_FOUND),
    DURATION_CAN_NOT_BE_CONVERTED("duration can not be converted: ", BAD_REQUEST),
    RATING_NOT_FOUND("rating not found with id: ",NOT_FOUND),

    //user-service
    USER_NOT_FOUND("user not found with username: ", NOT_FOUND),


    ;

    private final String userMessage;
    private final HttpStatus httpStatus;
}