package com.intern.fullprojectimplemantation.service.implementation;

import com.intern.fullprojectimplemantation.domain.Employee;
import com.intern.fullprojectimplemantation.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class MyUserDeatailService implements UserDetailsService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Employee> optEmployee = employeeRepository.findByUsername(username);

        if(optEmployee.isPresent())
        {
            Employee employee = optEmployee.get();
            String role = employee.getRole();
            String[] split = role.split(",");
            List<SimpleGrantedAuthority> authorities = Arrays.stream(split).map(SimpleGrantedAuthority::new).toList();
            return User.builder()
                    .username(employee.getUsername())
                    .password(employee.getPassword())
                    .authorities(authorities)
                    .build();
        }

        throw new UsernameNotFoundException("There is no User found with username: "+username);
    }
}
