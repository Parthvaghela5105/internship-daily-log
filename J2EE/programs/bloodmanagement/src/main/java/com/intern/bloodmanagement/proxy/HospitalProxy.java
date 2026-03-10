package com.intern.bloodmanagement.proxy;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HospitalProxy {
    private Long id;
    private String hospitalName;
    private String address;
    private String contactNumber;
    private String licenseNumber;
    private UserProxy users;
}
