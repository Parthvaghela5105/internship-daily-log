package com.intern.companyworkers.controller;

import com.intern.companyworkers.dto.CompanyDTO;
import com.intern.companyworkers.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping()
    public String saveComapny(@RequestBody CompanyDTO companyDTO){
        return companyService.addCompany(companyDTO);
    }

    @GetMapping()
    public List<CompanyDTO> getAllCompany(){
        return companyService.getAllCompany();
    }

    @GetMapping(value = "/{id}")
    public CompanyDTO getCompanyById(@PathVariable Long id){
        return companyService.getComapnyById(id);
    }

    @DeleteMapping()
    public String deleteAllCompany(){
        return companyService.deleteAllCompany();
    }

    @DeleteMapping(value = "/{id}")
    public String deleteCompanyById(@PathVariable Long id){
        return companyService.deleteCompanyById(id);
    }

    @PutMapping(value = "{id}")
    public String updateCompany(@RequestBody CompanyDTO companyDTO , @PathVariable Long id){
        return companyService.updateCompany(companyDTO,id);
    }

}
