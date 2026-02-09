package com.example.postmapping.controller;

import com.example.postmapping.model.Employee;
import com.example.postmapping.service.implemantation.EmployeeImplemantation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "emp")
public class EmployeeController {

    @Autowired
    private EmployeeImplemantation employeeImplemantation;

    @PostMapping(value = "/save-employee")
    public String saveEmployee(@RequestBody Employee employee){
        return employeeImplemantation.saveEmployee(employee);
    }

    @GetMapping(value="/get-all-employee")
    public List<Employee> getAllEmployee(){
        return employeeImplemantation.getAllEmployee();
    }

    @GetMapping(value = "/get/{id}")
    public Employee getEmployeeById(@PathVariable Long id){
        return employeeImplemantation.getEmployeeById(id);
    }

    @GetMapping(value="/remove/{id}")
    public String removeEmployeeById(@PathVariable Long id){
        return employeeImplemantation.removeEmployeeById(id);
    }

    @GetMapping(value = "remove-all-employee")
    public String removeAllEmployee(){
        return employeeImplemantation.removeAllEmployee();
    }

    @PostMapping(value = "update")
    public String updateEmployee(@RequestBody Employee emp){
        return employeeImplemantation.updateEmployee(emp);
    }

}
