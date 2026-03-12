package com.intern.bloodmanagement.proxy;


import com.intern.bloodmanagement.custom.validator.ValidPhoneNumber;
import jakarta.validation.constraints.NotBlank;
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
    @NotBlank(message = "Hospital name cant be blank")
    private String hospitalName;
    @NotBlank
    private String address;
    @ValidPhoneNumber
    private String contactNumber;
    private String licenseNumber;
    private UserProxy users;
}
