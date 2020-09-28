package com.russow;

import com.russow.entity.UserInfo;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * AppTest.
 *
 * @author Sergei_Russov
 */

public class AppTest {

    private static Validator validator;

    private static final String INCORRECT_NAME_MESSAGE = "должно соответствовать шаблону \"[a-zA-Z].{5,}\"";
    private static final String INCORRECT_PASSWORD_MESSAGE = "должно соответствовать шаблону \"[a-zA-Z]+\"";
    private static final String INCORRECT_EMAIL_MESSAGE = "The email and confirmedEmail fields must match";
    private static final String INCORRECT_DATE_MESSAGE = "Update date must be greater than current";

    @BeforeClass
    public static void init() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.usingContext().getValidator();
    }

    @Test
    public void testCorrectValues() {
        final UserInfo userInfo = new UserInfo("Sergey", "password", "email@email.com", "email@email.com", OffsetDateTime.parse("2020-11-20T00:00:00+03:00"));

        Set<ConstraintViolation<UserInfo>> validates = validator.validate(userInfo);
        assertEquals(validates.size(), 0);
    }

    @Test
    public void testIncorrectNameValue() {
        final UserInfo userInfo = new UserInfo("Carl", "password", "email@email.com", "email@email.com", OffsetDateTime.parse("2020-11-20T00:00:00+03:00"));

        Set<ConstraintViolation<UserInfo>> validates = validator.validate(userInfo);
        assertEquals(1, validates.size());
        assertEquals(INCORRECT_NAME_MESSAGE, validates.iterator().next().getMessage());
    }

    @Test
    public void testIncorrectPasswordValue() {
        final UserInfo userInfo = new UserInfo("Sergey", "123pas", "email@email.com", "email@email.com", OffsetDateTime.parse("2020-11-20T00:00:00+03:00"));

        Set<ConstraintViolation<UserInfo>> validates = validator.validate(userInfo);
        assertEquals(1, validates.size());
        assertEquals(INCORRECT_PASSWORD_MESSAGE, validates.iterator().next().getMessage());
    }

    @Test
    public void testIncorrectEmailValue() {
        final UserInfo userInfo = new UserInfo("Sergey", "password", "email@email.com", "email2@email.com", OffsetDateTime.parse("2020-11-20T00:00:00+03:00"));

        Set<ConstraintViolation<UserInfo>> validates = validator.validate(userInfo);
        assertEquals(1, validates.size());
        assertEquals(INCORRECT_EMAIL_MESSAGE, validates.iterator().next().getMessage());
    }

    @Test
    public void testIncorrectDateValue() {
        final UserInfo userInfo = new UserInfo("Sergey", "password", "email@email.com", "email@email.com", OffsetDateTime.parse("2019-11-20T00:00:00+03:00"));

        Set<ConstraintViolation<UserInfo>> validates = validator.validate(userInfo);
        assertEquals(1, validates.size());
        assertEquals(INCORRECT_DATE_MESSAGE, validates.iterator().next().getMessage());
    }

    @Test
    public void testIncorrectNameAndPasswordValues() {
        final UserInfo userInfo = new UserInfo("Carl", "pas123", "email@email.com", "email@email.com", OffsetDateTime.parse("2020-11-20T00:00:00+03:00"));

        Set<ConstraintViolation<UserInfo>> validates = validator.validate(userInfo);
        List<ConstraintViolation<UserInfo>> validatesList = new ArrayList<>(validates);

        assertEquals(2, validates.size());
    }

    @Test
    public void testIncorrectNameAndEmailValues() {
        final UserInfo userInfo = new UserInfo("Carl", "password", "email1@email.com", "email2@email.com", OffsetDateTime.parse("2020-11-20T00:00:00+03:00"));

        Set<ConstraintViolation<UserInfo>> validates = validator.validate(userInfo);
        List<ConstraintViolation<UserInfo>> validatesList = new ArrayList<>(validates);

        assertEquals(2, validates.size());
    }

    @Test
    public void testIncorrectNameAndUpdateDateValues() {
        final UserInfo userInfo = new UserInfo("Carl", "password", "email@email.com", "email@email.com", OffsetDateTime.parse("2019-11-20T00:00:00+03:00"));

        Set<ConstraintViolation<UserInfo>> validates = validator.validate(userInfo);
        List<ConstraintViolation<UserInfo>> validatesList = new ArrayList<>(validates);

        assertEquals(2, validates.size());
    }

    @Test
    public void testIncorrectPasswordAndEmailValues() {
        final UserInfo userInfo = new UserInfo("Sergey", "password1", "email1@email.com", "email@email.com", OffsetDateTime.parse("2020-11-20T00:00:00+03:00"));

        Set<ConstraintViolation<UserInfo>> validates = validator.validate(userInfo);
        List<ConstraintViolation<UserInfo>> validatesList = new ArrayList<>(validates);

        assertEquals(2, validates.size());
    }

    @Test
    public void testIncorrectPasswordAndUpdateDateValues() {
        final UserInfo userInfo = new UserInfo("Sergey", "password1", "email@email.com", "email@email.com", OffsetDateTime.parse("2019-11-20T00:00:00+03:00"));

        Set<ConstraintViolation<UserInfo>> validates = validator.validate(userInfo);
        List<ConstraintViolation<UserInfo>> validatesList = new ArrayList<>(validates);

        assertEquals(2, validates.size());
    }

    @Test
    public void testIncorrectEmailAndUpdateDateValues() {
        final UserInfo userInfo = new UserInfo("Sergey", "password", "email1@email.com", "email@email.com", OffsetDateTime.parse("2019-11-20T00:00:00+03:00"));

        Set<ConstraintViolation<UserInfo>> validates = validator.validate(userInfo);
        List<ConstraintViolation<UserInfo>> validatesList = new ArrayList<>(validates);

        assertEquals(2, validates.size());
    }

    @Test
    public void testIncorrectNameAndPasswordAndEmailValues() {
        final UserInfo userInfo = new UserInfo("Carl", "pas123", "email1@email.com", "email@email.com", OffsetDateTime.parse("2020-11-20T00:00:00+03:00"));

        Set<ConstraintViolation<UserInfo>> validates = validator.validate(userInfo);
        List<ConstraintViolation<UserInfo>> validatesList = new ArrayList<>(validates);

        assertEquals(3, validates.size());
    }

    @Test
    public void testIncorrectNameAndPasswordAndEmailAndUpdateDateValues() {
        final UserInfo userInfo = new UserInfo("Carl", "pas123", "email1@email.com", "email@email.com", OffsetDateTime.parse("2019-11-19T00:00:00+03:00"));

        Set<ConstraintViolation<UserInfo>> validates = validator.validate(userInfo);
        List<ConstraintViolation<UserInfo>> validatesList = new ArrayList<>(validates);

        assertEquals(4, validates.size());
    }
}