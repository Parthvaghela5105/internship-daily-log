package com.intern.validationdemo.proxy;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

public class StudentProxy {
    private Long id;
    @NotBlank(message = "Name should not blank , null and empty")
    private String name;
    @Email(message = "Enter valid email")
    @NotBlank
    private String email;
    private String mobileNo;
    private List<AddressProxy> address;
}
