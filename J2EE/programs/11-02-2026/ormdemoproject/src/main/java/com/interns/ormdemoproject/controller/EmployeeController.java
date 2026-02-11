package com.interns.ormdemoproject.controller;

import com.interns.ormdemoproject.entity.EmployeeEntity;
import com.interns.ormdemoproject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/emp")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping()
    public String saveEmployee(@RequestBody EmployeeEntity employee){
        return employeeService.addEmployee(employee);
    }

    @GetMapping()
    public List<EmployeeEntity> getAllEmployee(){
        return employeeService.getAllEmployee();
    }

    @GetMapping("/{id}")
    public EmployeeEntity getEmployeeById(@PathVariable Long id){
        return employeeService.getById(id);
    }

    @DeleteMapping()
    public String deleteAllEmployee(){
        return employeeService.deleteAllEmployee();
    }

    @DeleteMapping(value = "/{id}")
    public String deleteEmployeeById(@PathVariable Long id){
        return employeeService.deleteEmployeeById(id);
    }

    @PostMapping(value = "/{id}")
    public String updateEmployee(@PathVariable Long id , @RequestBody EmployeeEntity employee){
        return employeeService.updateEmployee(id , employee);
    }
}
