package com.eduwise.eduwise.annotation;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Target(TYPE)
@Retention(RUNTIME)
@Constraint(validatedBy= PasswordMatchValidator.class)
@Documented
public @interface PasswordMatch {
    String message() default "${com.eduwise.eduwise.annotation.PasswordMatch.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
