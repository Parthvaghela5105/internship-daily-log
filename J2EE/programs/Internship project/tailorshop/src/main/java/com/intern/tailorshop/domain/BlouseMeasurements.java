package com.intern.tailorshop.domain;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BlouseMeasurements extends Measurement{
    private Double blouseLength;
    private Double shoulder;
    private Double sleeveLength;
    private Double sleeveOpening;
    private Double armhole;
    private Double chest;
    private Double waist;
    private Double bust;
    private Double frontNeckLength;
    private Double backNeckLength;
}
