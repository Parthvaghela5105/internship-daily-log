package com.intern.globalexception.proxy;

import lombok.Data;

import java.util.List;

@Data
public class StudentProxy {
    private Long id;
    private String name;
    private String emailId;
    private List<AddressProxy> address;
}
