package com.intern.bionetomanymapping.entity;

import com.intern.bionetomanymapping.proxy.StudentProxy;
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
    @JoinColumn(name="student_id")
    private Student student;
}
