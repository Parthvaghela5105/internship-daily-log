package com.intern.companyworkers.utility;

import com.intern.companyworkers.domain.Company;
import com.intern.companyworkers.domain.Worker;
import com.intern.companyworkers.dto.CompanyDTO;
import com.intern.companyworkers.dto.WorkerDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

import java.util.List;

@Component
public class MapperHelper {

    @Autowired
    private ModelMapper mapper;

    public Company dtoToEntity(CompanyDTO companyDTO){
        return mapper.map(companyDTO , Company.class);
    }

    public CompanyDTO entityToDTO(Company company){
        company.getWorker().setCompany(null);
        return mapper.map(company , CompanyDTO.class);
    }

    public List<Company> listDtoToListEntity(List<CompanyDTO> dtoList){
        return dtoList.stream().map(this::dtoToEntity).toList();
    }

    public List<CompanyDTO> listEntityToListDto(List<Company> companies){
        return companies.stream().map(this::entityToDTO).toList();
    }

    public Worker workerdtoToEntity(WorkerDTO workerDTO){
        return mapper.map(workerDTO, Worker.class);
    }

    public WorkerDTO workerentityToDTO(Worker worker){
        worker.getCompany().setWorker(null);
        return mapper.map(worker , WorkerDTO.class);
    }

    public List<Worker> workerlistDtoToListEntity(List<WorkerDTO> dtoList){
        return dtoList.stream().map(this::workerdtoToEntity).toList();
    }

    public List<WorkerDTO> workerlistEntityToListDto(List<Worker> companies){
        return companies.stream().map(this::workerentityToDTO).toList();
    }
}
