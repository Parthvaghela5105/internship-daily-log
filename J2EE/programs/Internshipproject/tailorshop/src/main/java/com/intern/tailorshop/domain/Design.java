package com.intern.tailorshop.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Design {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long designId;

    private String designName;

    private Double basePrice;

    @Column(length = 1000)
    private  String description;

    private Boolean active;

    @ManyToOne
    @JoinColumn(name = "shop_id")
    private TailorShop tailorShop;
}
