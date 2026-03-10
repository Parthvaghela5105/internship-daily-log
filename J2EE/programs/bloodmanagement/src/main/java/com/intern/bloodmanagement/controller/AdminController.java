package com.intern.bloodmanagement.controller;

import com.intern.bloodmanagement.domain.BloodStock;
import com.intern.bloodmanagement.proxy.BloodStockProxy;
import com.intern.bloodmanagement.proxy.UserProxy;
import com.intern.bloodmanagement.service.AdminService;
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

    @GetMapping(value = "/users")
    public ResponseEntity<List<UserProxy>> getAllUsers(){
        return new ResponseEntity<>(adminService.getAllUser() , HttpStatus.OK);
    }

    @PutMapping(value = "/donor/{id}/approve")
    public ResponseEntity<String> approveRequest(@PathVariable Long id){
        return new ResponseEntity<>(adminService.approve(id) , HttpStatus.OK);
    }

    @PostMapping(value = "/blood-stock/add")
    public ResponseEntity<String> addBloodStock(@RequestBody BloodStockProxy bloodStockProxy){
        return new ResponseEntity<>(adminService.addBloodStock(bloodStockProxy), HttpStatus.CREATED);
    }

}
