package com.intern.companyworkers.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Worker")
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double salary;

    @OneToOne(mappedBy = "worker",cascade = CascadeType.ALL)
    private Company company;
}
