package com.intern.onetoonebidirectional.controller;

import com.intern.onetoonebidirectional.dto.AddressDto;
import com.intern.onetoonebidirectional.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/address")
public class AddressController {

    @Autowired
    private AddressService addService;

    @PostMapping()
    public String saveAddress(@RequestBody AddressDto addressDto){
        return addService.addAddress(addressDto);
    }

    @GetMapping()
    public List<AddressDto> getAllAddress(){
        return addService.getAllAddress();
    }

    @GetMapping(value = "/{city}")
    public AddressDto getAddressByCity(@PathVariable String city){
        return addService.getAddressByCity(city);
    }
}
