package com.intern.onetomanymapping.domain;

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
    private String emailId;
    private String mobileNo;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Address> address;
}
