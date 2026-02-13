package com.intern.onetoonebidirectional.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;
    private String state;
    private String pincode;

    @OneToOne(mappedBy = "address",cascade = CascadeType.ALL)
    private Student student;
}
