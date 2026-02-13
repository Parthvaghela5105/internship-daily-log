package com.intern.onetomanymapping.service.implemantation;

import com.intern.onetomanymapping.domain.Student;
import com.intern.onetomanymapping.reository.StudentRepository;
import com.intern.onetomanymapping.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public String saveStudent(Student student) {
        return studentRepository.save(student).toString();
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentByEmailId(String email) {
        return studentRepository.findByEmailId(email).orElse(null);
    }

    @Override
    public String deleteStudentById(Long id) {
        studentRepository.deleteById(id);
        return "Deleted Successfully";
    }

    @Override
    public String deleteAllStudent() {
        studentRepository.deleteAll();
        return "Deleted All Student";
    }

    @Override
    public String updateStudent(Long id , Student student) {
        Optional<Student> existedStudent = studentRepository.findById(id);
        if(existedStudent.isPresent()){
            Student student1 = existedStudent.get();
            student1.getAddress().clear();
            student.setId(student1.getId());
            student.getAddress().stream().forEach(x ->{
                x.setId(student1.getAddress().get(0).getId());
                student1.getAddress().remove(0);
            });
            return "Updated Successfully";
        }
        return "Not Updated";
    }
}
