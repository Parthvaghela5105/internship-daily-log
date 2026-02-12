package com.intern.onetoonemapping.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "personal_student_details")
public class PersonalInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    private String accNo;
}
