package com.russow.validation.constraint.validator;

import com.russow.entity.UserInfo;
import com.russow.validation.annotation.EmailConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * EmailConstrintValidator.
 *
 * @author Sergei_Russov
 */
public class EmailConstraintValidatorImpl implements ConstraintValidator<EmailConstraint, UserInfo> {

    @Override
    public boolean isValid(UserInfo userInfo, ConstraintValidatorContext constraintValidatorContext) {
        return userInfo.getEmail().equals(userInfo.getConfirmedEmail());
    }
}
