package com.intern.jwttoken.service.implemantation;

import com.intern.jwttoken.domain.Student;
import com.intern.jwttoken.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Student> optStd = studentRepository.findByUsername(username);
        if(optStd.isPresent()){
            Student student = optStd.get();
            return User.builder().username(student.getUsername()).password(student.getPassword()).build();
        }

        throw new UsernameNotFoundException("There is no user found with username "+username);
    }

}
