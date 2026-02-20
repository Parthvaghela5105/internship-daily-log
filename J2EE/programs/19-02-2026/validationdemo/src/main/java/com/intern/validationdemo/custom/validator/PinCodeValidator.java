package com.intern.validationdemo.custom.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PinCodeValidator implements ConstraintValidator<ValidPinCode , Integer> {
    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if(value == null) return false;
        return value >= 100000 && value <= 999999;
    }
}
