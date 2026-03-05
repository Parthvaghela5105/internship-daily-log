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
public class ChaniyaMeasurement extends Measurement{
    private Double length;
    private Double waist;
    private Double hip;
}
