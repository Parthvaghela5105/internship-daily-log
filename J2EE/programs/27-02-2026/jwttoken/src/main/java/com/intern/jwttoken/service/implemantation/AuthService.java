package com.intern.jwttoken.service.implemantation;

import com.intern.jwttoken.domain.Student;
import com.intern.jwttoken.proxy.LoginRequestProxy;
import com.intern.jwttoken.proxy.LoginResponseProxy;
import com.intern.jwttoken.proxy.SignUpResponseProxy;
import com.intern.jwttoken.proxy.StudentProxy;
import com.intern.jwttoken.repository.StudentRepository;
import com.intern.jwttoken.utility.AuthUtil;
import com.intern.jwttoken.utility.MapperHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

//    @Autowired
//    private AuthenticationManager authenticationManager;

    @Autowired
    private AuthUtil authUtil;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private MapperHelper helper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationConfiguration authenticationConfiguration;

    public LoginResponseProxy login(LoginRequestProxy loginRequestProxy){
        LoginResponseProxy loginResponseProxy = new LoginResponseProxy();

        Authentication authentication = authenticationConfiguration.getAuthenticationManager()
                .authenticate(
                        new UsernamePasswordAuthenticationToken(
                                loginRequestProxy.getUsername(),
                                loginRequestProxy.getPassword()
                        )
                );

        Student student = studentRepository.findByUsername(loginRequestProxy.getUsername()).orElseThrow();

        if(authentication.isAuthenticated())
        {
            String token = authUtil.generateAccessToken(student);
            loginResponseProxy.setUserId(student.getId());
            loginResponseProxy.setJwt(token);
        }

        return loginResponseProxy;

    }

    public SignUpResponseProxy signup(StudentProxy studentProxy){
        Student student = studentRepository.findByUsername(studentProxy.getUsername()).orElse(null);

        if(student != null) throw new IllegalArgumentException("User Already exists");
        Student student1 = helper.getStudent(studentProxy);
        student1.setPassword(passwordEncoder.encode(student1.getPassword()));
        student = studentRepository.save(student1);

        return new SignUpResponseProxy(student.getId() , student.getUsername());

    }
}
