package com.intern.manytomany.domain;

import com.intern.manytomany.proxy.StudentProxy;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;
    private String state;

    @ManyToMany(mappedBy = "addressList")
    private List<Student> studentList=new ArrayList<>();
}
