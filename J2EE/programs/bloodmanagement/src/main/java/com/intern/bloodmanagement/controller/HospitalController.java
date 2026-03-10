package com.intern.bloodmanagement.controller;

import com.intern.bloodmanagement.proxy.BloodRequestProxy;
import com.intern.bloodmanagement.proxy.HospitalProxy;
import com.intern.bloodmanagement.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/hospital")
public class HospitalController {
    @Autowired
    private HospitalService hospitalService;

    @PostMapping(value = "/create")
    public ResponseEntity<String> createHospital(@RequestBody HospitalProxy hospitalProxy){
        return new ResponseEntity<>(hospitalService.createHospital(hospitalProxy) , HttpStatus.CREATED);
    }

    @GetMapping(value = "/profile/{id}")
    public ResponseEntity<HospitalProxy> getProfile(@PathVariable Long id){
        return new ResponseEntity<>(hospitalService.getProfile(id) , HttpStatus.OK);
    }

    @PostMapping(value = "/request")
    public ResponseEntity<String> requestBlood(@RequestBody BloodRequestProxy bloodRequestProxy){
        return new ResponseEntity<>(hospitalService.hospitalBloodRequest(bloodRequestProxy) , HttpStatus.CREATED);
    }

    @GetMapping(value = "/request/history/{id}")
    public ResponseEntity<List<BloodRequestProxy>> history(@PathVariable Long id){
        return new ResponseEntity<>(hospitalService.requestHistory(id) , HttpStatus.OK);
    }
}
