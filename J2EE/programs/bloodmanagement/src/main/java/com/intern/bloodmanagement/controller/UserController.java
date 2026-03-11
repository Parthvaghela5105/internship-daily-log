package com.intern.bloodmanagement.controller;

import com.intern.bloodmanagement.domain.Users;
import com.intern.bloodmanagement.proxy.HospitalProxy;
import com.intern.bloodmanagement.proxy.UserProxy;
import com.intern.bloodmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/search/blood/{bloodGroup}")
    public ResponseEntity<List<UserProxy>> searchByBloodGroup(@PathVariable String bloodGroup){
        return new ResponseEntity<>(userService.getByBloodGroup(bloodGroup) , HttpStatus.OK);
    }

    @GetMapping(value = "/search/donors")
    public ResponseEntity<List<UserProxy>> searchDonors(){
        return new ResponseEntity<>(userService.getDonor() , HttpStatus.OK);
    }

    @GetMapping(value = "/hospitals")
    public ResponseEntity<List<HospitalProxy>> getHospitals(){
        return new ResponseEntity<>(userService.getHospitals() , HttpStatus.OK);
    }
}
