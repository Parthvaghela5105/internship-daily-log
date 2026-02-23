package com.intern.customquerymethod.service.implemantation;

import com.github.javafaker.Faker;
import com.intern.customquerymethod.domain.Student;
import com.intern.customquerymethod.proxy.StudentProxy;
import com.intern.customquerymethod.repository.StudentRepository;
import com.intern.customquerymethod.service.StudentService;
import com.intern.customquerymethod.utility.MapperHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public List<StudentProxy> getAllData() {
        return studentRepository.findAll().stream().map(s -> helper.getStudentProxy(s)).toList();
    }

    @Override
    public StudentProxy getStudentByEmailAndNumber(String emailId, String number) {
        Optional<Student> optStd = studentRepository.findByEmailIdAndNumber(emailId, number);
        if(optStd.isPresent()){
            Student student = optStd.get();
            return helper.getStudentProxy(student);
        }
        return null;
    }

    @Override
    public List<StudentProxy> getStudentByEmailOrNumber(String emailId, String number) {
        return studentRepository.findByEmailIdOrNumber(emailId , number).stream().map(s -> helper.getStudentProxy(s)).toList();
    }

    @Override
    public List<StudentProxy> getStudentByName(String name) {
        return studentRepository.findByName(name).stream().map(s -> helper.getStudentProxy(s)).toList();
    }

    @Override
    public List<StudentProxy> getStudentByNameIs(String name) {
        return studentRepository.findByNameIs(name).stream().map(s -> helper.getStudentProxy(s)).toList();
    }

    @Override
    public List<StudentProxy> getStudentByNameEquals(String name) {
        return studentRepository.findByNameEquals(name).stream().map(s -> helper.getStudentProxy(s)).toList();
    }

    @Override
    public List<StudentProxy> getStudentByAgeLessThan(Integer age) {
        return studentRepository.findByAgeLessThan(age).stream().map(s -> helper.getStudentProxy(s)).toList();
    }

    @Override
    public List<StudentProxy> getStudentByAgeLessThanEqual(Integer age) {
        return studentRepository.findByAgeLessThanEqual(age).stream().map(s -> helper.getStudentProxy(s)).toList();
    }

    @Override
    public List<StudentProxy> getStudentByAgeGreaterThan(Integer age) {
        return studentRepository.findByAgeGreaterThan(age).stream().map(s -> helper.getStudentProxy(s)).toList();
    }

    @Override
    public List<StudentProxy> getStudentByAgeGreaterThanEqual(Integer age) {
        return studentRepository.findByAgeGreaterThanEqual(age).stream().map(s -> helper.getStudentProxy(s)).toList();
    }

    @Override
    public List<StudentProxy> getStudentByNameLike(String name) {
        return studentRepository.findByNameLike(name).stream().map(s -> helper.getStudentProxy(s)).toList();
    }

    @Override
    public List<StudentProxy> getStudentByNameContaining(String name) {
        return studentRepository.findByNameContaining(name).stream().map(s -> helper.getStudentProxy(s)).toList();
    }

    @Override
    public List<StudentProxy> getStudentByAgeIn(List<Integer> age) {
        return studentRepository.findByAgeIn(age).stream().map(s -> helper.getStudentProxy(s)).toList();
    }

    @Override
    public List<StudentProxy> getStudentNameIgnoreCase(String name) {
        return studentRepository.findByNameIgnoreCase(name).stream().map(s -> helper.getStudentProxy(s)).toList();
    }

}
