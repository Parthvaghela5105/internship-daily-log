package com.intern.globalexception.entity;

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

    @ManyToOne(cascade = CascadeType.ALL)
    private Student student;
}
