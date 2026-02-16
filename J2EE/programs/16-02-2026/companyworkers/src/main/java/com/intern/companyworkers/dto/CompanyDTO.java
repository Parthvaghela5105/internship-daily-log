package com.intern.companyworkers.dto;

import lombok.Data;

@Data
public class CompanyDTO {
    private Long id;
    private String name;
    private String domain;
    private WorkerDTO worker;
}
