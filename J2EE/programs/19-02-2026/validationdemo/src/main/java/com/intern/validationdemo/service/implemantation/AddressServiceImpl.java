package com.intern.validationdemo.service.implemantation;

import com.intern.validationdemo.customized.exception.NoStudentFoundException;
import com.intern.validationdemo.entity.Address;
import com.intern.validationdemo.proxy.AddressProxy;
import com.intern.validationdemo.proxy.StudentProxy;
import com.intern.validationdemo.repository.AddressRepository;
import com.intern.validationdemo.service.AddressService;
import com.intern.validationdemo.utility.MapperHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private MapperHelper helper;

    @Override
    public String addAddress(AddressProxy addressProxy) {
        addressRepository.save(helper.address(addressProxy));
        return "Address Saved successfully";
    }

    @Override
    public List<AddressProxy> getAllAddress() {
        return addressRepository.findAll().stream().map(a -> helper.addressProxy(a)).toList();
    }

    @Override
    public AddressProxy getAddressById(Long id) {
        Optional<Address> optAdd = addressRepository.findById(id);
        if(optAdd.isPresent()){
            return helper.addressProxy(optAdd.get());
        }else {
            throw new NoStudentFoundException("There is no Address with id " + id, HttpStatus.NOT_FOUND.value());
        }
    }

    @Override
    public String deleteAllAddress() {
        addressRepository.deleteAll();
        return "All Address deleted successfully";
    }

    @Override
    public String deleteAddressById(Long id) {
        Optional<Address> optAdd = addressRepository.findById(id);
        if(optAdd.isPresent()){
            optAdd.get().setStudent(null);
            addressRepository.deleteById(id);
            return "Student with id "+id+" has been deleted successfully";
        }else {
            throw new NoStudentFoundException("There is no Address with id " + id, HttpStatus.NOT_FOUND.value());
        }
    }

    @Override
    public String updateAddress(AddressProxy addressProxy, Long id) {
        Optional<Address> optAdd = addressRepository.findById(id);
        if(optAdd.isPresent()){
            addressRepository.save(helper.address(addressProxy));
            return "Student with id "+id+" has been updated successfully";
        }else {
            throw new NoStudentFoundException("There is no Address with id " + id, HttpStatus.NOT_FOUND.value());
        }
    }
}
