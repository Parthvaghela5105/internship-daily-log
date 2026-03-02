package com.intern.tailorshop.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EmployeeWork {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long workId;

    private LocalDate workDate;

    private Integer quantity;

    private double rateAPerUnit;

    private Double totalWage;

    @ManyToOne
    @JoinColumn(name="employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name="order_id")
    private Order order;
}
