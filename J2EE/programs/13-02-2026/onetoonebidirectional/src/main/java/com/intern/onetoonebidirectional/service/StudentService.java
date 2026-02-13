package com.intern.onetoonebidirectional.service;

import com.intern.onetoonebidirectional.dto.StudentDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    String saveStudent(StudentDTO studentDTO);

    List<StudentDTO> getAllStudent();

    StudentDTO getStudentByEmailId(String email);
}
