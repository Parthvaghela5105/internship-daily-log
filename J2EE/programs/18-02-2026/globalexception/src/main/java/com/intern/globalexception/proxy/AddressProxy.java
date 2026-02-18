package com.intern.globalexception.proxy;

import lombok.Data;

@Data
public class AddressProxy {
    private Long id;
    private String city;
    private String state;
    private StudentProxy student;
}
