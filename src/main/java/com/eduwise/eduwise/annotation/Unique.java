package com.eduwise.eduwise.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Target({FIELD,PARAMETER})
@Retention(RUNTIME)
@Constraint(validatedBy= UniqueValidator.class)
@Documented
public @interface Unique {
    Class<?> repositoryClass();

    String methodName();

    String message() default "{com.eduwise.eduwise.annotation.Unique.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
