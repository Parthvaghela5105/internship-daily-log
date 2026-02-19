package com.intern.globalexception.service.implemantation;

import com.intern.globalexception.customized.exception.NoStudentFoundException;
import com.intern.globalexception.entity.Address;
import com.intern.globalexception.proxy.AddressProxy;
import com.intern.globalexception.repository.AddressRepository;
import com.intern.globalexception.service.AddressService;
import com.intern.globalexception.service.StudentService;
import com.intern.globalexception.utility.MapperHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
            return helper.addressProxy(add.get());
        }
        else
            throw new NoStudentFoundException("There is No Address Fount with id "+id , HttpStatus.NOT_FOUND.value());
    }

    @Override
    public String deleteById(Long id) {
        Optional<Address> add = addressRepository.findById(id);
        if(add.isPresent()){
            add.get().setStudent(null);
            addressRepository.deleteById(id);
            return "Student with id "+id+" has been deleted Successfully";
        }else{
            throw new NoStudentFoundException("There is no record found with id "+id , HttpStatus.NOT_FOUND.value());
        }
    }

    @Override
    public String updateAddress(AddressProxy addressProxy, Long id) {
        Optional<Address> add = addressRepository.findById(id);
        if(add.isPresent()){
            addressRepository.save(helper.addProxyToEntity(addressProxy));
            return "Student with id "+id+" has been deleted Successfully";
        }else{
            throw new NoStudentFoundException("There is no record found with id "+id , HttpStatus.NOT_FOUND.value());
        }
    }
}
