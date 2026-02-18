package com.intern.globalexception.service.implemantation;

import com.intern.globalexception.entity.Address;
import com.intern.globalexception.proxy.AddressProxy;
import com.intern.globalexception.repository.AddressRepository;
import com.intern.globalexception.service.AddressService;
import com.intern.globalexception.service.StudentService;
import com.intern.globalexception.utility.MapperHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private MapperHelper helper;

    @Override
    public String saveAddress(AddressProxy addressProxy) {
        addressRepository.save(helper.addProxyToEntity(addressProxy));
        return "Saved Successfully";
    }

    @Override
    public List<AddressProxy> getAllAddress() {
        return addressRepository.findAll().stream().map(a -> helper.addressProxy(a)).toList();
    }

    @Override
    public AddressProxy getAddressById(Long id) {
        Optional<Address> add = addressRepository.findById(id);
        if(add.isPresent()){
//             add.get();

        }
        return null;
    }
}
