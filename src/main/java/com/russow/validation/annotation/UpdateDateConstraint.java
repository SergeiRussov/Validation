package com.russow.validation.annotation;

import com.russow.validation.constraint.validator.UpdateDateConstraintValidatorImpl;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * UpdateDateConstraint.
 *
 * @author Sergei_Russov
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UpdateDateConstraintValidatorImpl.class)
public @interface UpdateDateConstraint {
    String message() default "Update date must be greater than current";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
