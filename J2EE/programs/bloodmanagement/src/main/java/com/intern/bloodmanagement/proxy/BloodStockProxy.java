package com.intern.bloodmanagement.proxy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BloodStockProxy {
    private Long id;
    private String bloodGroup;
    private Double unitsAvailable;
    private LocalDateTime lastUpdated;
}
