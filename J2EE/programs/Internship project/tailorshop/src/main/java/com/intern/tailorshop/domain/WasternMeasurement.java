package com.intern.tailorshop.domain;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class WasternMeasurement extends Measurement{
    private Double length;
    private Double shoulder;
    private Double sleeveLength;
    private Double sleeveOpening;
    private Double armhole;
    private Double chest;
    private Double waist;
    private Double hip;
    private Double slitLength;
}
