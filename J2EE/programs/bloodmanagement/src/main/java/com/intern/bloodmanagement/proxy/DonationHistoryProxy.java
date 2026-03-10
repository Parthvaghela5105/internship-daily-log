package com.intern.bloodmanagement.proxy;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class DonationHistoryProxy {
    private Long id;
    private LocalDate donationDate;
    private Double quantity;
    private String remarks;
}
