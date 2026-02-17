package com.intern.bionetomanymapping.service.implemantation;

import com.intern.bionetomanymapping.entity.Address;
import com.intern.bionetomanymapping.proxy.AddressProxy;
import com.intern.bionetomanymapping.repository.AddressRepository;
import com.intern.bionetomanymapping.service.AddressService;
import com.intern.bionetomanymapping.utility.MapperHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private MapperHelper helper;

    @Autowired
    private AddressRepository repository;


    @Override
    public String addAddress(AddressProxy proxy) {
        repository.save(helper.addProxyToEntity(proxy));
        return "Saved Successfully";
    }

    @Override
    public List<AddressProxy> getAllAddress() {
        return repository.findAll().stream().map(a -> helper.addEntityToProxy(a)).toList();
    }

    @Override
    public List<AddressProxy> getAddressByCity(String city) {
//        return helper.addEntityToProxy(repository.findByCity(city));
        return repository.findByCity(city).stream().map(helper::addEntityToProxy).toList();
    }

    @Override
    public String deleteAddressById(Long id) {
        Optional<Address> byId = repository.findById(id);
        if(byId.isPresent()){
            repository.deleteById(id);
            return "Employee With "+id+" has been deleted Successfully";
        }
        return "There is no record available with id "+id;
    }

    @Override
    public String deleteAllAddress() {
        repository.deleteAll();
        return "Deleted All Address Successfully";
    }

    @Override
    public String updateStudent(AddressProxy proxy, Long id) {
        Optional<Address> optAdd = repository.findById(id);
        if(optAdd.isPresent()){
            repository.save(helper.addProxyToEntity(proxy));
            return "Saved Successfully";
        }
        return "There is No Record available with id "+id;
    }
}
