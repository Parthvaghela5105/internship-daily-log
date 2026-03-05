package com.intern.tailorshop.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TailorShop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shopId;

    private String shopName;

    private String ownerName;

    private String contactNumber;

    private String address;

    private String workingHours;

    private String status;
}
