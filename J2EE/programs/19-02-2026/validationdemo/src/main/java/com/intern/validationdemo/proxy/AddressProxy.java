package com.intern.validationdemo.proxy;

import com.intern.validationdemo.custom.validator.ValidPinCode;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Data
public class AddressProxy {
    private Long id;
    @Size(min = 4 , max = 15 , message = "City name Should be between 4 to 15 character")
    private String city;
    private String state;
    @ValidPinCode(message = "Enter valid pincode")
    private Integer pinCode;
    @Valid
    private StudentProxy student;
}
