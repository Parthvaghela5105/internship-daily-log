package com.intern.fullprojectimplemantation.service.implementation;

import com.intern.fullprojectimplemantation.domain.Employee;
import com.intern.fullprojectimplemantation.proxy.AuthRequestProxy;
import com.intern.fullprojectimplemantation.proxy.AuthResponseProxy;
import com.intern.fullprojectimplemantation.proxy.EmployeeProxy;
import com.intern.fullprojectimplemantation.repository.EmployeeRepository;
import com.intern.fullprojectimplemantation.service.EmployeeService;
import com.intern.fullprojectimplemantation.util.JwtUtil;
import com.intern.fullprojectimplemantation.util.MapperHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private MapperHelper mapperHelper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MyUserDeatailService myUserDeatailService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public String saveEmployee(EmployeeProxy employeeProxy) {
        employeeProxy.setPassword(passwordEncoder.encode(employeeProxy.getPassword()));
        return employeeRepository.save(mapperHelper.employee(employeeProxy)).toString();
    }

    @Override
    public AuthResponseProxy generateToken(AuthRequestProxy authRequestProxy) {
        AuthResponseProxy responseProxy = new AuthResponseProxy();
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequestProxy.getUsername() , authRequestProxy.getPassword()));

        if(authenticate.isAuthenticated()){
            UserDetails userDetails = myUserDeatailService.loadUserByUsername(authRequestProxy.getUsername());
            String token = jwtUtil.generateToken(userDetails);
            responseProxy.setToken(token);
            responseProxy.setUsername(authRequestProxy.getUsername());
        }

        return responseProxy;
    }

    @Override
    public EmployeeProxy getByName(String name) {
        Employee employee = employeeRepository.findByName(name).orElseThrow(() -> new RuntimeException("No Employee Found with name" + name));
        return mapperHelper.employeeProxy(employee);
    }
}
