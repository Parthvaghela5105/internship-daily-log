package com.intern.companyworkers.service;

import com.intern.companyworkers.dto.CompanyDTO;

import java.util.List;

public interface CompanyService {
    String addCompany(CompanyDTO companyDTO);

    List<CompanyDTO> getAllCompany();

    CompanyDTO getComapnyById(Long id);

    String deleteCompanyById(Long id);

    String deleteAllCompany();

    String updateCompany(CompanyDTO companyDTO , Long id);
}
