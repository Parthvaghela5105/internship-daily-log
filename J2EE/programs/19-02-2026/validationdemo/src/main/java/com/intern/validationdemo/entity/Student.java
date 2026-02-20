package com.intern.validationdemo.entity;

import com.intern.validationdemo.proxy.AddressProxy;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private Long mobileNo;
    private LocalDateTime dateTime;

    @OneToMany(mappedBy = "student" , cascade = CascadeType.ALL)
    private List<Address> address;
}
