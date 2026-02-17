package com.intern.bionetomanymapping.controller;

import com.intern.bionetomanymapping.proxy.AddressProxy;
import com.intern.bionetomanymapping.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @PostMapping()
    public String saveAddress(@RequestBody AddressProxy addressProxy){
        return addressService.addAddress(addressProxy);
    }

    @GetMapping()
    public List<AddressProxy> getAllAddress(){
        return addressService.getAllAddress();
    }

    @GetMapping("/{city}")
    public List<AddressProxy> getAddByCity(@PathVariable String city){
        return addressService.getAddressByCity(city);
    }

    @DeleteMapping(value = "/{id}")
    public String deleteAddressById(@PathVariable Long id){
        return addressService.deleteAddressById(id);
    }

    @DeleteMapping()
    public String deleteAllAddress(){
        return addressService.deleteAllAddress();
    }

}
