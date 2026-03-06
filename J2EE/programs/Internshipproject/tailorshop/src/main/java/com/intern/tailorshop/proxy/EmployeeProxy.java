package com.intern.tailorshop.proxy;

import lombok.Data;

@Data
public class EmployeeProxy {
    private String name;
    private String phone;
    private String address;
    private String wageType;
    private Double salary;
    private Long shopId;
}
