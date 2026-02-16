package com.intern.bionetomanymapping.service.implemantation;

import com.intern.bionetomanymapping.entity.Student;
import com.intern.bionetomanymapping.proxy.StudentProxy;
import com.intern.bionetomanymapping.repository.StudentRepository;
import com.intern.bionetomanymapping.service.StudentService;
import com.intern.bionetomanymapping.utility.MapperHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository repository;

    @Autowired
    private MapperHelper helper;

    @Override
    public String saveStudent(StudentProxy studentProxy) {
        Student student = helper.proxyToEntity(studentProxy);
        student.getAddress().forEach(a -> a.setStudent(student));
        repository.save(student);
        return "Student saved successfully";
    }

    @Override
    public List<StudentProxy> getAllStudents() {
        return helper.listEntityToListProxy(repository.findAll());
    }

    @Override
    public StudentProxy getStudentById(Long id) {
        return helper.entityToProxy(repository.findById(id).orElse(null));
    }

    @Override
    public String deleteAllStudent() {
        repository.deleteAll();
        return "All Student is deleted successfully";
    }

    @Override
    public String deleteStudentById(Long id) {
        Optional<Student> optStd = repository.findById(id);
        if(optStd.isPresent()){
            repository.deleteById(id);
            return "Student with id "+id+" is Deleted Successfully";
        }

        return "There is no record found with id "+id;
    }

    @Override
    public String updateStudent(Long id, StudentProxy studentProxy) {
        Optional<Student> optStd = repository.findById(id);
        if(optStd.isPresent())
        {
            repository.save(helper.proxyToEntity(studentProxy));
            return "Record with id "+id+" is updated successfully";
        }
        return "There is no record found with id "+id;
    }
}
