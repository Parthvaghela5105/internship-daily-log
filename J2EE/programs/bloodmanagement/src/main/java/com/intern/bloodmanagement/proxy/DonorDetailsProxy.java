package com.intern.bloodmanagement.proxy;

import com.intern.bloodmanagement.domain.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DonorDetailsProxy {
    private Long id;
    private String bloodGroup;
    private Integer age;
    private String gender;
    private String city;
    private LocalDate lastDonationDate;
    private Boolean available;
    private Users users;
}
