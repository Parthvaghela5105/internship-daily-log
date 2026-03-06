package com.intern.fullprojectimplemantation.controller;

import com.intern.fullprojectimplemantation.proxy.EmployeeProxy;
import com.intern.fullprojectimplemantation.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping
    public ResponseEntity<List<EmployeeProxy>> getAllEmployee(){
        return new ResponseEntity<>(adminService.getAllEmployee() , HttpStatus.OK);
    }

    @PostMapping(value = "/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable Long id , @RequestBody EmployeeProxy employeeProxy){
        return new ResponseEntity<>(adminService.updateEmployee(id , employeeProxy) , HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id)
    {
        return new ResponseEntity<>(adminService.deleteEmployee(id) , HttpStatus.OK);
    }

}
