package com.intern.xcellupload.proxy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeProxy {
    private Long id;
    private String name;
    private String emailId;
    private String mobileNo;
    private String address;
    private Boolean isActive;
}
