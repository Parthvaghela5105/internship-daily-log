package com.intern.tailorshop.domain;

import com.intern.tailorshop.enums.WageType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    private String name;

    private String phone;

    private LocalDate joiningDate;

    private Double salaryOrRate;

    @Enumerated(EnumType.STRING)
    private WageType wageType;

    @ManyToOne
    @JoinColumn(name="shop_id")
    private TailorShop tailorShop;
}
