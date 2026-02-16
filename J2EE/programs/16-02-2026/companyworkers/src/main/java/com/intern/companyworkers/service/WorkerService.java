package com.intern.companyworkers.service;

import com.intern.companyworkers.domain.Worker;
import com.intern.companyworkers.dto.WorkerDTO;

import java.util.List;

public interface WorkerService {
    String saveWorker(WorkerDTO workerDTO);

    List<WorkerDTO> getAllWorker();

    WorkerDTO getWorkerById(Long id);

    String deleteAllWorker();

    String deleteWorkerById(Long id);

    String updateWorker(WorkerDTO workerDTO , Long id);
}
