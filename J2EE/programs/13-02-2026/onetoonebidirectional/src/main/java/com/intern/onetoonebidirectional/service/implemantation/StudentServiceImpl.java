package com.intern.onetoonebidirectional.service.implemantation;

import com.intern.onetoonebidirectional.dto.StudentDTO;
import com.intern.onetoonebidirectional.repository.StudentRepository;
import com.intern.onetoonebidirectional.service.StudentService;
import com.intern.onetoonebidirectional.utility.MapperUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository stdRepo;

    @Autowired
    private MapperUtility mapperUtility;

    @Override
    public String saveStudent(StudentDTO studentDTO) {
        return stdRepo.save(mapperUtility.dtoToEntity(studentDTO)).toString();
    }

    @Override
    public List<StudentDTO> getAllStudent() {
        return mapperUtility.listEntityToListDTO(stdRepo.findAll());
    }

    @Override
    public StudentDTO getStudentByEmailId(String email) {
        return mapperUtility.entityToDTO(stdRepo.findByEmailId(email).get());
    }
}
