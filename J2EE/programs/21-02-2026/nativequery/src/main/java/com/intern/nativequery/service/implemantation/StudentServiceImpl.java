package com.intern.nativequery.service.implemantation;

import com.github.javafaker.Faker;
import com.intern.nativequery.domain.Student;
import com.intern.nativequery.projection.StudentNameEmailProjection;
import com.intern.nativequery.proxy.StudentProxy;
import com.intern.nativequery.repository.StudentRepository;
import com.intern.nativequery.service.StudentService;
import com.intern.nativequery.utility.MapperHelper;
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
    public List<StudentProxy> getAllStudent() {
        return studentRepository.getAllStudent().stream().map(s -> helper.getStudentProxy(s)).toList();
    }

    @Override
    public Object[] getStudentById(Long id) {
        return studentRepository.getStudentById(id);
    }

    @Override
    public String deleteStudentById(Long id) {
        studentRepository.deleteStudentById(id);
        return "Student with id "+id+" has been deleted successfully";
    }

    @Override
    public List<StudentNameEmailProjection> getStudentNameEmailId() {
        return studentRepository.getNameEmailId();
    }

    @Override
    public String updateStudent(Long id ,String address) {
        studentRepository.updateStudent(id , address);
        return "Student Has been updated successfully";
    }
}
