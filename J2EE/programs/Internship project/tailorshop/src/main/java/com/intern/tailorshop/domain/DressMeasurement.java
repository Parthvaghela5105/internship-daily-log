package com.intern.tailorshop.domain;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DressMeasurement extends Measurement{
    private Double dressLength;
    private Double shoulder;
    private Double sleeveLength;
    private Double sleeveOpening;
    private Double armhole;
    private Double chest;
    private Double waist;
    private Double hip;
}
