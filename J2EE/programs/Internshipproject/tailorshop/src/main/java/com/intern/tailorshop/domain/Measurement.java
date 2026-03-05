package com.intern.tailorshop.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Measurement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long measurementId;

    private LocalDate measurmentDate;

    @Column(length = 1000)
    private String notes;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
