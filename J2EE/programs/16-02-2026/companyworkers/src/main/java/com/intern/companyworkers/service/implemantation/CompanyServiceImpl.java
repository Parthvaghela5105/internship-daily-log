package com.intern.companyworkers.service.implemantation;

import com.intern.companyworkers.domain.Company;
import com.intern.companyworkers.dto.CompanyDTO;
import com.intern.companyworkers.repository.CompanyRepository;
import com.intern.companyworkers.service.CompanyService;
import com.intern.companyworkers.utility.MapperHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private MapperHelper mapperHelper;

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public String addCompany(CompanyDTO companyDTO) {
        companyRepository.save(mapperHelper.dtoToEntity(companyDTO)).toString();
        return "Saved Successfully";
    }

    @Override
    public List<CompanyDTO> getAllCompany() {
        return mapperHelper.listEntityToListDto(companyRepository.findAll());
    }

    @Override
    public CompanyDTO getComapnyById(Long id) {
        Optional<Company> byId = companyRepository.findById(id);
        if (byId.isPresent()){
            return mapperHelper.entityToDTO(byId.get());
        }
        return null;
    }

    @Override
    public String deleteCompanyById(Long id) {
        Optional<Company> company = companyRepository.findById(id);
        if (company.isPresent()){
            companyRepository.delete(company.get());
            return "Company has been deleted Successfully";
        }

        return "Company has not been deleted successfully";
    }

    @Override
    public String deleteAllCompany() {
        companyRepository.deleteAll();
        return "deleted All Data has been Successfully";
    }

    @Override
    public String updateCompany(CompanyDTO companyDTO, Long id) {
        Optional<Company> optCom = companyRepository.findById(id);
        if(optCom.isPresent()){
            Company c = optCom.get();
            companyDTO.setId(c.getId());
            companyDTO.getWorker().setId(c.getWorker().getId());
            companyRepository.save(mapperHelper.dtoToEntity(companyDTO));
            return "Update Company Data has been Successfully";
        }
        return "No record found for with id "+id;
    }
}
