package com.intern.onetoonebidirectional.utility;

import com.intern.onetoonebidirectional.domain.Address;
import com.intern.onetoonebidirectional.domain.Student;
import com.intern.onetoonebidirectional.dto.AddressDto;
import com.intern.onetoonebidirectional.dto.StudentDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MapperUtility {
    @Autowired
    private ModelMapper modelMapper;

    public StudentDTO entityToDTO(Student student){
        student.getAddress().setStudent(null);
        return modelMapper.map(student , StudentDTO.class);
    }

    public Student dtoToEntity(StudentDTO studentDTO){
        return modelMapper.map(studentDTO , Student.class);
    }

    public List<Student> listDTOToListEntity(List<StudentDTO> studentDTOS){
        return studentDTOS.stream().map(this::dtoToEntity).toList();
    }

    public List<StudentDTO> listEntityToListDTO(List<Student> students){
        return students.stream().map(this::entityToDTO).toList();
    }

    public AddressDto addEntityToDTO(Address address){
        address.getStudent().setAddress(null);
        return modelMapper.map(address , AddressDto.class);
    }

    public Address addDtoToEntity(AddressDto addressDto){
        return modelMapper.map(addressDto, Address.class);
    }

    public List<Address> addListDTOToListEntity(List<AddressDto> addressDtos){
        return addressDtos.stream().map(this::addDtoToEntity).toList();
    }

    public List<AddressDto> addListEntityToListDTO(List<Address> addresses){
        return addresses.stream().map(this::addEntityToDTO).toList();
    }


}
