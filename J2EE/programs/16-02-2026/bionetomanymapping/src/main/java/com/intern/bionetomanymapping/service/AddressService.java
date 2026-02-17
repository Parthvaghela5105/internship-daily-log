package com.intern.bionetomanymapping.service;

import com.intern.bionetomanymapping.proxy.AddressProxy;

import java.util.List;

public interface AddressService {
    String addAddress(AddressProxy proxy);
    List<AddressProxy> getAllAddress();
    List<AddressProxy> getAddressByCity(String city);
    String deleteAddressById(Long id);
    String deleteAllAddress();
    String updateStudent(AddressProxy proxy , Long id);
}
