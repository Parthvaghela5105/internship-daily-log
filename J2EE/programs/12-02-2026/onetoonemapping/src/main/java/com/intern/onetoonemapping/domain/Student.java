package com.intern.onetoonemapping.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "general_student_details")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "email")
    private String emailId;
    @Column(name = "mobNo")
    private String mobileNo;
    @OneToOne(cascade = CascadeType.ALL)
    private PersonalInformation personalInformation;
}
