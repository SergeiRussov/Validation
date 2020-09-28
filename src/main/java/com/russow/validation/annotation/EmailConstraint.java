package com.russow.validation.annotation;

import com.russow.validation.constraint.validator.EmailConstraintValidatorImpl;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * EmailConstraint.
 *
 * @author Sergei_Russov
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmailConstraintValidatorImpl.class)
public @interface EmailConstraint {
    String message() default "The email and confirmedEmail fields must match";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
