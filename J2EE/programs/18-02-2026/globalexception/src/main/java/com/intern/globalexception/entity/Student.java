package com.intern.globalexception.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String emailId;

    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    private List<Address> address=new ArrayList<>();

}
