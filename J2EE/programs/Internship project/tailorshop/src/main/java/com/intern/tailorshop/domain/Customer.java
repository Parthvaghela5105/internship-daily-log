package com.intern.tailorshop.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    private String name;

    private String mobileNumber;

    private String address;

    private LocalDate registeredDate;

    @ManyToOne
    @JoinColumn(name = "shop_id")
    private TailorShop tailorShop;
}
