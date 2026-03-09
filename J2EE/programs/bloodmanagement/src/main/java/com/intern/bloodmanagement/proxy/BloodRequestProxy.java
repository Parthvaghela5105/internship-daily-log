package com.intern.bloodmanagement.proxy;


import com.intern.bloodmanagement.domain.Hospital;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BloodRequestProxy {
    private Long id;
    private String bloodGroup;
    private Double quantity;
    private LocalDate requestDate;
    private String status;
    private Hospital hospital;
}
