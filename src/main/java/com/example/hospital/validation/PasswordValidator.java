package com.example.hospital.validation;

import com.example.hospital.validation.annotation.Password;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class PasswordValidator implements ConstraintValidator<Password, String> {
    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {
        return isInRange(password)
                && hasLowerCaseSymbols(password)
                && hasUpperCaseSymbols(password);
    }

    private boolean isInRange(String password) {
        return password.length() >= 4 && password.length() <= 20;
    }

    private boolean hasLowerCaseSymbols(String password) {
        return Pattern.compile("[a-z]").matcher(password).find();
    }

    private boolean hasUpperCaseSymbols(String password) {
        return Pattern.compile("[A-Z]").matcher(password).find();
    }
}
