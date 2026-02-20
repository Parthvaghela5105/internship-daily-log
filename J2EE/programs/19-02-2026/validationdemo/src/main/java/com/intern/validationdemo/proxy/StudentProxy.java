package com.intern.validationdemo.proxy;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class StudentProxy {
    private Long id;
    @NotBlank(message = "Name should not blank , null and empty")
    private String name;
    @Email(message = "Enter should be valid email")
    @NotBlank
    private String email;

    @Min(value = 1000000000L , message = "Mobile number should not be less than 10 digits")
    @Max(value = 9999999999L , message = "Mobile number should not be greater than 10 digits")
    private Long mobileNo;

    @Past(message = "Data should be past date")
    private LocalDateTime dateTime;

    @Valid
    private List<AddressProxy> address;
}
