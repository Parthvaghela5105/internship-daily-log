package com.interns.ormdemoproject.service.implemantation;

import com.interns.ormdemoproject.entity.EmployeeEntity;
import com.interns.ormdemoproject.repository.EmployeeRepository;
import com.interns.ormdemoproject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository empRep;

    @Override
    public String addEmployee(EmployeeEntity employee) {
        EmployeeEntity emp = empRep.save(employee);
        return emp.toString();
    }

    @Override
    public List<EmployeeEntity> getAllEmployee() {
        return empRep.findAll();
    }

    @Override
    public EmployeeEntity getById(Long id) {
        Optional<EmployeeEntity> optionalEmployee = empRep.findById(id);
        if(optionalEmployee.isPresent())
            return optionalEmployee.get();

        return new EmployeeEntity(null , null , null);
    }

    @Override
    public String updateEmployee(Long id ,EmployeeEntity employee) {
//        Optional<EmployeeEntity> optionalEmployee = empRep.findById(id);
//        if(optionalEmployee.isPresent()){
//            EmployeeEntity employee1 = optionalEmployee.get();
//            employee1.setName(employee.getName());
//            employee1.setName(employee.getAddress());
//            empRep.save(employee1);
//        }
//        return "There is no data is available with id "+id;

        return empRep.save(employee).toString();
    }

    @Override
    public String deleteEmployeeById(Long id) {
//        Optional<EmployeeEntity> optionalEmployee = empRep.findById(id);
//
//        if(optionalEmployee.isPresent()){
//            empRep.delete(optionalEmployee.get());
//            return "Employee has been deleted successfully";
//        }
//        return "There is no record available with id "+id;

        empRep.deleteById(id);
        return "deleted Successfully";
    }

    @Override
    public String deleteAllEmployee() {
        empRep.deleteAll();
        return "Delete all employee successfully";
    }
}
