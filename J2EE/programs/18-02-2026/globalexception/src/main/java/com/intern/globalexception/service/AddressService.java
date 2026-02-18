package com.intern.globalexception.service;

import com.intern.globalexception.proxy.AddressProxy;

import java.util.List;

public interface AddressService {
    String saveAddress(AddressProxy addressProxy);
    List<AddressProxy> getAllAddress();
    AddressProxy getAddressById(Long id);
}
