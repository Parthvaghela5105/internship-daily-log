package com.intern.bloodmanagement.proxy;


import com.intern.bloodmanagement.domain.DonorDetails;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DonationProxy {
    private Long id;
    private LocalDate donationDate;
    private Double quantity;
    private String remarks;

    private DonorDetails donorDetails;
}
