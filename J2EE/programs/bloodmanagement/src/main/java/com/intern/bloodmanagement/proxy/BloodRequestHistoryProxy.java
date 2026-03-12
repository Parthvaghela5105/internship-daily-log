package com.intern.bloodmanagement.proxy;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class BloodRequestHistoryProxy {
    private Long id;
    private String bloodGroup;
    private Double quantity;
    private LocalDate requestDate;
    private String status;
}
