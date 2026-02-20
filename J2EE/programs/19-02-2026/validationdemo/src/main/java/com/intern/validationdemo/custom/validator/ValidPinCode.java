package com.intern.validationdemo.custom.validator;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = PinCodeValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPinCode {
    String message() default "Invalid pincode";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
