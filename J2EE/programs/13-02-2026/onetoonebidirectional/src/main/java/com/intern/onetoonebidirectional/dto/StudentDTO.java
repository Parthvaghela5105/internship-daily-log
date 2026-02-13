package com.intern.onetoonebidirectional.dto;

import com.intern.onetoonebidirectional.domain.Address;
import lombok.Data;

@Data
public class StudentDTO {
    private Long id;
    private String name;
    private String emailId;
    private AddressDto address;
}
