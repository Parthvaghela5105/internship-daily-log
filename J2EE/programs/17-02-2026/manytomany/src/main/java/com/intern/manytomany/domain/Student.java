package com.intern.manytomany.domain;

import com.intern.manytomany.proxy.AddressProxy;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Student {
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String emailId;

    @ManyToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    private List<Address> addressList=new ArrayList<>();
}
