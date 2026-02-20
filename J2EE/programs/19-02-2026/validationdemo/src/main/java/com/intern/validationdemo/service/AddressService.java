package com.intern.validationdemo.service;


import com.intern.validationdemo.proxy.AddressProxy;

import java.util.List;

public interface AddressService {
    String addAddress(AddressProxy addressProxy);
    List<AddressProxy> getAllAddress();
    AddressProxy getAddressById(Long id);
    String deleteAllAddress();
    String deleteAddressById(Long id);
    String updateAddress(AddressProxy addressProxy , Long id);
}
