package com.example.treelayeremployee.service.implemantation;

import com.example.treelayeremployee.proxy.Employee;
import com.example.treelayeremployee.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImplemantation implements EmployeeService {

    List<Employee> employeeList = new ArrayList<>();

    @Override
    public String saveEmployee(Employee employee) {
        Optional<Employee> optionalEmployee = employeeList.stream().filter(e -> e.getId() == employee.getId()).findFirst();
        if(optionalEmployee.isPresent())
            return "Employee already available with id "+employee.getId();
        employeeList.add(employee);
        return "Employee saved successfully";
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeList;
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeList.stream().filter(x -> x.getId() == id).findFirst().orElse(new Employee(null , null , null));
    }

    @Override
    public String removeEmployeeById(Long id) {
        boolean isDeleted = employeeList.removeIf(x -> x.getId() == id);
        if(isDeleted){
            return "Employee with id "+id+" has been removed successfully";
        }
        return "There is record data available with id "+id;
    }

    @Override
    public String updateEmployee(Long id, Employee employee) {
        Optional<Employee> optionalEmployee = employeeList.stream().filter(x -> x.getId() == id).findFirst();
        if(optionalEmployee.isPresent()){
            Employee updatedEmployee = optionalEmployee.get();
            updatedEmployee.setName(employee.getName());
            updatedEmployee.setAddress(employee.getAddress());
            return "Employee with id "+id+" has been updated successfully";
        }
        return "There is no record available with id "+id;
    }

    @Override
    public String removeAllEmployee() {
        employeeList.clear();
        return "All employee data has been deleted successfully";
    }
}
