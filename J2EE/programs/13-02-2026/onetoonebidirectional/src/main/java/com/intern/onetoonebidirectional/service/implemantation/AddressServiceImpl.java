package com.intern.onetoonebidirectional.service.implemantation;

import com.intern.onetoonebidirectional.dto.AddressDto;
import com.intern.onetoonebidirectional.repository.AddressRepository;
import com.intern.onetoonebidirectional.service.AddressService;
import com.intern.onetoonebidirectional.utility.MapperUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addRepository;

    @Autowired
    private MapperUtility mapperUtility;

    @Override
    public String addAddress(AddressDto addressDto) {
        addressDto.getStudent().setAddress(addressDto);
        addRepository.save(mapperUtility.addDtoToEntity(addressDto));
        return "Student saved successfully";
    }

    @Override
    public List<AddressDto> getAllAddress() {
        return mapperUtility.addListEntityToListDTO(addRepository.findAll());
    }

    @Override
    public AddressDto getAddressByCity(String city) {
        return mapperUtility.addEntityToDTO(addRepository.findByCity(city).get());
    }
}
