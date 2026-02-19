package com.intern.globalexception.controller;

import com.intern.globalexception.proxy.AddressProxy;
import com.intern.globalexception.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @PostMapping
    public ResponseEntity<String> addAdress(@RequestBody AddressProxy addressProxy){
        return new ResponseEntity<>(addressService.saveAddress(addressProxy) , HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AddressProxy>> getAllAddress(){
        return new ResponseEntity<>(addressService.getAllAddress() , HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AddressProxy> getAddressById(@PathVariable Long id){
        return new ResponseEntity<>(addressService.getAddressById(id) , HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteStudentByID(@PathVariable Long id){
        return new ResponseEntity<>(addressService.deleteById(id) , HttpStatus.OK);
    }
}
