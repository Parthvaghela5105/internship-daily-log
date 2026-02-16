package com.intern.companyworkers.service.implemantation;

import com.intern.companyworkers.domain.Worker;
import com.intern.companyworkers.dto.WorkerDTO;
import com.intern.companyworkers.repository.WorkerRepository;
import com.intern.companyworkers.service.WorkerService;
import com.intern.companyworkers.utility.MapperHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkerServiceImpl implements WorkerService {

    @Autowired
    private MapperHelper mapperHelper;

    @Autowired
    private WorkerRepository workerRepository;

    @Override
    public String saveWorker(WorkerDTO workerDTO) {
        workerDTO.getCompany().setWorker(workerDTO);
        workerRepository.save(mapperHelper.workerdtoToEntity(workerDTO));
        return "Saved worker Successfully";
    }

    @Override
    public List<WorkerDTO> getAllWorker() {
        return mapperHelper.workerlistEntityToListDto(workerRepository.findAll());
    }

    @Override
    public WorkerDTO getWorkerById(Long id) {
        return mapperHelper.workerentityToDTO(workerRepository.findById(id).orElse(null));
    }

    @Override
    public String deleteAllWorker() {
        workerRepository.deleteAll();
        return "Delete All Data Successfully";
    }

    @Override
    public String deleteWorkerById(Long id) {
        Optional<Worker> byId = workerRepository.findById(id);
        if(byId.isPresent()){
            Worker worker = byId.get();
            workerRepository.delete(worker);
            return "Worker has been deleted Successfully";
        }
        return "There is no records with id "+id;
    }

    @Override
    public String updateWorker(WorkerDTO workerDTO, Long id) {
        Optional<Worker> optWorker = workerRepository.findById(id);
        if(optWorker.isPresent()){
            Worker worker = optWorker.get();
            workerDTO.getCompany().setWorker(workerDTO);
            workerDTO.setId(worker.getId());
            workerDTO.getCompany().setId(worker.getCompany().getId());
            workerRepository.save(mapperHelper.workerdtoToEntity(workerDTO));
            return "Data has been updated successfully";
        }
        return "there is no record with id "+id;
    }
}
