package com.intern.manytomany.proxy;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.List;

@Data
public class AddressProxy {
    private Long id;
    private String city;
    private String state;
    private List<StudentProxy> student;
}
