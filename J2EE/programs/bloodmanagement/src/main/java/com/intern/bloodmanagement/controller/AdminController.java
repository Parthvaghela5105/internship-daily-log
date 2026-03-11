package com.intern.bloodmanagement.controller;

import com.intern.bloodmanagement.domain.BloodStock;
import com.intern.bloodmanagement.proxy.BloodStockProxy;
import com.intern.bloodmanagement.proxy.UserProxy;
import com.intern.bloodmanagement.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

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

    @PostMapping(value = "hospital/{id}/approve")
    public ResponseEntity<String> approveBloodRequest(@PathVariable Long id){
        return new ResponseEntity<>(adminService.approveBloodRequest(id) , HttpStatus.OK);
    }

    @GetMapping(value = "/reports/blood-stock")
    public ResponseEntity<String> downloadExcelFile(){
        byte[] bytes = adminService.getExcell();

        String folderPath = "downloads";
        File folder = new File(folderPath);
        if(!folder.exists()){
            folder.mkdirs();
        }
        String filename = "bloodStock.xlsx";

        Path path = Paths.get(folderPath , filename);

        try{
            Files.write(path , bytes);
        }
        catch (IOException e){
            e.printStackTrace();
        }

        return  new ResponseEntity<>("File saved at: " + path.toAbsolutePath(),
                HttpStatus.OK);

    }

    @GetMapping(value = "/reports/users")
    public ResponseEntity<String> downloaduserReport(){
        byte[] bytes = adminService.getUserReport();

        String folderPath = "downloads";
        File folder = new File(folderPath);
        if(!folder.exists()){
            folder.mkdirs();
        }
        String filename = "usersreport.xlsx";

        Path path = Paths.get(folderPath , filename);

        try{
            Files.write(path , bytes);
        }
        catch (IOException e){
            e.printStackTrace();
        }

        return  new ResponseEntity<>("File saved at: " + path.toAbsolutePath(),
                HttpStatus.OK);

    }

}
