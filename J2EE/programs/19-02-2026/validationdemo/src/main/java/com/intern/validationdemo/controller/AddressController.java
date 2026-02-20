package com.intern.validationdemo.controller;

import com.intern.validationdemo.proxy.AddressProxy;
import com.intern.validationdemo.service.AddressService;
import jakarta.validation.Valid;
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
    public ResponseEntity<String> addAddress(@Valid @RequestBody AddressProxy addressProxy){
        return new ResponseEntity<>(addressService.addAddress(addressProxy), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AddressProxy>> getAllAddress(){
        return new ResponseEntity<>(addressService.getAllAddress() , HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressProxy> getAddressById(@PathVariable Long id){
        return new ResponseEntity<>(addressService.getAddressById(id) , HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteAllAddress(){
        return new ResponseEntity<>(addressService.deleteAllAddress() , HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteAddressById(@PathVariable Long id){
        return new ResponseEntity<>(addressService.deleteAddressById(id) , HttpStatus.OK);
    }

    @PostMapping(value = "/{id}")
    public ResponseEntity<String> updateAddress(@RequestBody AddressProxy addressProxy , @PathVariable Long id){
        return new ResponseEntity<>(addressService.updateAddress(addressProxy , id) , HttpStatus.OK);
    }

}
