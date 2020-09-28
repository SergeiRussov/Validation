package com.russow.validation.constraint.validator;

import com.russow.validation.annotation.UpdateDateConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.OffsetDateTime;

/**
 * UpdateDateConstraintValidatorImpl.
 *
 * @author Sergei_Russov
 */
public class UpdateDateConstraintValidatorImpl implements ConstraintValidator<UpdateDateConstraint, OffsetDateTime> {

    @Override
    public boolean isValid(OffsetDateTime offsetDateTime, ConstraintValidatorContext constraintValidatorContext) {
        return offsetDateTime.isAfter(OffsetDateTime.now());
    }
}
