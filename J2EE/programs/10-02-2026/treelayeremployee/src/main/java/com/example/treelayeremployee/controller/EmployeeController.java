package com.example.treelayeremployee.controller;

import com.example.treelayeremployee.proxy.Employee;
import com.example.treelayeremployee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/emp")
public class EmployeeController {
    @Autowired
    private EmployeeService emplService;

    @PostMapping(value = "save-employee")
    public String saveEmpl(@RequestBody Employee employee) {
        return emplService.saveEmployee(employee);
    }

    @GetMapping(value = "get-all-employee")
    public List<Employee> getAllEmpl() {
        return emplService.getAllEmployee();
    }

    @GetMapping(value = "get-employee-by-id/{id}")
    public Employee getEmployeeById(@PathVariable Long id){
        return emplService.getEmployeeById(id);
    }

    @GetMapping(value = "remove-all-employee")
    public String removeAllEmployee() {
        return emplService.removeAllEmployee();
    }

        @GetMapping(value = "remove-by-id/{id}")
    public String removeById(@PathVariable Long id) {
        return emplService.removeEmployeeById(id);
    }

    @PostMapping(value = "update-employee/{id}")
    public String updatedEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        return emplService.updateEmployee(id, employee);
    }
}
