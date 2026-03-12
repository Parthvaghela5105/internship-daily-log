package com.intern.bloodmanagement.controller;

import com.intern.bloodmanagement.domain.Donation;
import com.intern.bloodmanagement.proxy.DonationHistoryProxy;
import com.intern.bloodmanagement.proxy.DonationProxy;
import com.intern.bloodmanagement.proxy.DonorDetailsProxy;
import com.intern.bloodmanagement.service.DonorDetailsService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/donor")
public class DonorDetailsController {

    @Autowired
    private DonorDetailsService donorDetailsService;

    @GetMapping(value = "/profile/{id}")
    public ResponseEntity<DonorDetailsProxy> showProfile(@PathVariable Long id){
        return new ResponseEntity<>(donorDetailsService.getDonorDetails(id), HttpStatus.OK);
    }

    @PutMapping(value = "/profile")
    public ResponseEntity<String> updateDonorDetails(@Valid @RequestBody DonorDetailsProxy donorDetailsProxy){
        return new ResponseEntity<>(donorDetailsService.updateDonorDetails(donorDetailsProxy) , HttpStatus.OK);
    }


    @PostMapping(value ="/donate")
    public ResponseEntity<String> donateBlood(@Valid @RequestBody DonationProxy donation){
        return new ResponseEntity<>(donorDetailsService.donateBlood(donation) , HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<List<DonationHistoryProxy>> donerHistory(@PathVariable Long id){
        return new ResponseEntity<>(donorDetailsService.donerHistory(id) , HttpStatus.OK);
    }


}
