package com.intern.companyworkers.dto;

import lombok.Data;

@Data
public class WorkerDTO {
    private Long id;
    private String name;
    private String salary;
    private CompanyDTO company;
}
