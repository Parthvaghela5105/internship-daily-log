package com.intern.bionetomanymapping.entity;

import com.intern.bionetomanymapping.proxy.AddressProxy;
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

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "student")
    private List<Address> address;
}
