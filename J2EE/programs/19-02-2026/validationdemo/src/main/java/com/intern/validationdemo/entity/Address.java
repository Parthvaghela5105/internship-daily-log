package com.intern.validationdemo.entity;

import com.intern.validationdemo.proxy.StudentProxy;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;
    private String state;
    private Integer pinCode;

    @ManyToOne(cascade = CascadeType.ALL)
    private Student student;
}
