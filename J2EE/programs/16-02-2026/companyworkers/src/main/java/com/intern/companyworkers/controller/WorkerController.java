package com.intern.companyworkers.controller;

import com.intern.companyworkers.dto.WorkerDTO;
import com.intern.companyworkers.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/worker")
public class WorkerController {

    @Autowired
    private WorkerService workerService;

    @PostMapping()
    public String saveWorker(@RequestBody WorkerDTO workerDTO){
        return workerService.saveWorker(workerDTO);
    }

    @GetMapping()
    public List<WorkerDTO> getAllWorker(){
        return workerService.getAllWorker();
    }

    @GetMapping(value = "/{id}")
    public WorkerDTO getWorkerById(@PathVariable Long id){
        return workerService.getWorkerById(id);
    }

    @DeleteMapping()
    public String deleteAllWorker(){
        return workerService.deleteAllWorker();
    }

    @DeleteMapping("/{id}")
    public String deleteWorkerById(@PathVariable Long id){
        return workerService.deleteWorkerById(id);
    }

    @PutMapping("/{id}")
    public String updateWorker(@RequestBody WorkerDTO workerDTO , @PathVariable Long id) {
        return workerService.updateWorker(workerDTO, id);
    }
}
