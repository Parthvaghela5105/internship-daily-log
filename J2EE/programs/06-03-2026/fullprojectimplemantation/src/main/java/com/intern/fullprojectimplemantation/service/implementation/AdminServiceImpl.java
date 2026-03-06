package com.intern.fullprojectimplemantation.service.implementation;

import com.intern.fullprojectimplemantation.domain.Employee;
import com.intern.fullprojectimplemantation.exception.customized.NoEmployeeFoundException;
import com.intern.fullprojectimplemantation.proxy.EmployeeProxy;
import com.intern.fullprojectimplemantation.repository.EmployeeRepository;
import com.intern.fullprojectimplemantation.service.AdminService;
import com.intern.fullprojectimplemantation.util.MapperHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private MapperHelper mapperHelper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<EmployeeProxy> getAllEmployee() {
        return employeeRepository.findAll().stream().map(mapperHelper::employeeProxy).toList();
    }

    @Override
    public String updateEmployee(Long id, EmployeeProxy employeeProxy) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);

        if(optionalEmployee.isPresent()){
            Employee employee = optionalEmployee.get();
            employeeProxy.setPassword(passwordEncoder.encode(employee.getPassword()));
            employeeProxy.setId(id);
            employeeRepository.save(mapperHelper.employee(employeeProxy));
        }else{
            throw new NoEmployeeFoundException("there is no employee found with id "+id);
        }

        return "Employee updated successfully";
    }

    @Override
    public String deleteEmployee(Long id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);

        if(optionalEmployee.isPresent()){
            employeeRepository.deleteById(id);
        }else{
            throw new NoEmployeeFoundException("there is no employee found with id "+id);
        }

        return "Employee deleted successfully";
    }
}
