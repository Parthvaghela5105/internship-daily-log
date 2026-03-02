package com.intern.springsecuritydemo.service.implemantation;

import com.intern.springsecuritydemo.proxy.AuthReq;
import com.intern.springsecuritydemo.proxy.AuthResp;
import com.intern.springsecuritydemo.proxy.StudentProxy;
import com.intern.springsecuritydemo.repository.StudentRepository;
import com.intern.springsecuritydemo.service.StudentService;
import com.intern.springsecuritydemo.util.JwtUtil;
import com.intern.springsecuritydemo.utility.MapperHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private MapperHelper helper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Override
    public String saveStudent(StudentProxy studentProxy) {
        studentProxy.setPassword(passwordEncoder.encode(studentProxy.getPassword()));
        return studentRepository.save(helper.getStudent(studentProxy)).toString();
    }

    @Override
    public AuthResp authenticateStudent(AuthReq authReq) {
        AuthResp authResp = new AuthResp();

        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authReq.getUsername(), authReq.getPassword()));
        if(authenticate.isAuthenticated()){
            UserDetails userDetails = myUserDetailsService.loadUserByUsername(authReq.getUsername());
            String jwtToken = jwtUtil.generateToken(userDetails);
            authResp.setToken(jwtToken);
            authResp.setUsername(authReq.getUsername());
        }

        return authResp;
    }
}
