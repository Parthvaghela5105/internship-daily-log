package com.intern.onetoonebidirectional.service;


import com.intern.onetoonebidirectional.dto.AddressDto;

import java.util.List;

public interface AddressService {

    String addAddress(AddressDto addressDto);

    List<AddressDto> getAllAddress();

    AddressDto getAddressByCity(String city);
}
