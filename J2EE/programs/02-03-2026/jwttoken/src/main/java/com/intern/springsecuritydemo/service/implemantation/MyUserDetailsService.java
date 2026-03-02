package com.intern.springsecuritydemo.service.implemantation;

import com.intern.springsecuritydemo.domain.Student;
import com.intern.springsecuritydemo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Student> optStd = studentRepository.findByUsername(username);
        if(optStd.isPresent()){

            Student student = optStd.get();
            String role = student.getRole();
            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(role);

            return User.builder()
                    .username(student.getUsername())
                    .password(student.getPassword())
                    .authorities(simpleGrantedAuthority)
                    .build();

        }
        throw new UsernameNotFoundException("There is no user found with username "+username);
    }
}
