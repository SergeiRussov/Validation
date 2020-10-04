package com.russow.validation.constraint.validator;

import com.russow.entity.UserInfo;
import com.russow.validation.annotation.FieldMatch;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FieldMatchValidator implements ConstraintValidator<FieldMatch, UserInfo> {

    @Override
    public boolean isValid(final UserInfo value, final ConstraintValidatorContext context) {
        try {
            final String firstObj = value.getEmail();
            final String secondObj = value.getConfirmedEmail();

            return firstObj == null && secondObj == null || firstObj != null && firstObj.equals(secondObj);
        } catch (final Exception exception) {

        }
        return true;
    }
}
