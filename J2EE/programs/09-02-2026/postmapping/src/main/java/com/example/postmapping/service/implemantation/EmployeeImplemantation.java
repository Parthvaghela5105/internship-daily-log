package com.example.postmapping.service.implemantation;

import com.example.postmapping.model.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class EmployeeImplemantation {

    List<Employee> employeeList = new ArrayList<>();

    public String saveEmployee(Employee emp){
        if(employeeList.add(emp))
            return "Employee Saved Successfully";
        else
            return "Employee not Saved";

    }

    public List<Employee> getAllEmployee(){
        return employeeList;
    }

    public Employee getEmployeeById(Long empId){
        return employeeList.stream().filter(x -> x.getId() == empId).findFirst().orElse(new Employee(null , null , null , null));
    }

    public String removeEmployeeById(Long empId){
        boolean isDeleted = employeeList.removeIf(e -> e.getId() == empId);
        if(isDeleted)
            return "deleted successfully";
        else
            return "not deleted";
    }

    public String removeAllEmployee(){
        employeeList.clear();
        return "Deleted all employees";
    }

    public String updateEmployee(Employee employee){
        Long empId = employee.getId();
        Optional<Employee> optionalEmployee = employeeList.stream().filter(e -> e.getId() == empId).findFirst();
        if(optionalEmployee.isPresent())
        {
            Employee oldEmployee = optionalEmployee.get();
            oldEmployee.setAddress(employee.getAddress());
            oldEmployee.setName(employee.getName());
            oldEmployee.setBirthDate(employee.getBirthDate());
            return "Employee has been updated successfully";
        }
        return "Employee has not been updated";
    }
}
