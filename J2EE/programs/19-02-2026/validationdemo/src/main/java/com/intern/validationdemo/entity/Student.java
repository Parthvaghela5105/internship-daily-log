package com.intern.validationdemo.entity;

import com.intern.validationdemo.proxy.AddressProxy;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String mobileNo;

    @OneToMany(mappedBy = "student")
    private List<Address> address;
}
