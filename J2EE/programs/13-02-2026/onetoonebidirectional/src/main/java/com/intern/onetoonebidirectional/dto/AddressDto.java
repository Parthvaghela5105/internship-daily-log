package com.intern.onetoonebidirectional.dto;

import com.intern.onetoonebidirectional.domain.Student;
import lombok.Data;


@Data
public class AddressDto {
    private Long id;
    private String city;
    private String state;
    private String pincode;
    private StudentDTO student;
}
