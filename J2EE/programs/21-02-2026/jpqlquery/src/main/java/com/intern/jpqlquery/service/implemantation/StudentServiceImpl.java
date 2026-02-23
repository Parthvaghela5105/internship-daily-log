package com.intern.jpqlquery.service.implemantation;

import com.github.javafaker.Faker;
import com.intern.jpqlquery.domain.Student;
import com.intern.jpqlquery.dto.StdDTO;
import com.intern.jpqlquery.proxy.StudentProxy;
import com.intern.jpqlquery.repository.StudentRepository;
import com.intern.jpqlquery.service.StudentService;
import com.intern.jpqlquery.utility.MapperHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private Faker faker;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private MapperHelper helper;

    @Override
    public String generate_random_data() {
        for(int i = 1;i <= 100; i++)
        {
            Student s = new Student();
            s.setName(faker.name().name());
            s.setAddress(faker.address().fullAddress());
            s.setAge(faker.number().numberBetween(10 , 20));
            s.setNumber(faker.phoneNumber().phoneNumber());
            s.setEmailId(faker.internet().emailAddress());
            studentRepository.save(s);
        }
        return "Saved All data successfully";
    }

    @Override
    public List<StudentProxy> getALlData() {
        return studentRepository.getAllStudent().stream().map(s -> helper.getStudentProxy(s)).toList();
    }

    @Override
    public List<StdDTO> getStudents() {
        return studentRepository.getStudents();
    }

    @Override
    public String deleteStudentById(Long id) {
        studentRepository.deleteStudentByID(id);
        return "Student has been deleted Successully";
    }

    @Override
    public String updateStudent(Long id, String address) {
        studentRepository.updateStudent(id , address);
        return "Student has been updated Successfully";
    }
}
