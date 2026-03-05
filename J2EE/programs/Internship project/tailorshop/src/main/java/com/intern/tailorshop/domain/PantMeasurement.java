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
public class PantMeasurement extends Measurement{
    private Double length;
    private Double bottomOpening;
    private Double knee;
    private Double thigh;
    private Double waist;
    private Double hip;
}
