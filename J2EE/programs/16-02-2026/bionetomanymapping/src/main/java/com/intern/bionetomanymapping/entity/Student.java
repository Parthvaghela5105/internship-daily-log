package com.intern.bionetomanymapping.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String emailId;

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "student")
    private List<Address> address;
}