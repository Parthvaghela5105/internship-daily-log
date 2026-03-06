package com.intern.tailorshop.service.implementation;

import com.intern.tailorshop.domain.Employee;
import com.intern.tailorshop.domain.TailorShop;
import com.intern.tailorshop.exception.customized.ShopNotFoundException;
import com.intern.tailorshop.proxy.EmployeeProxy;
import com.intern.tailorshop.repository.EmployeeRepo;
import com.intern.tailorshop.repository.TailorShopRepo;
import com.intern.tailorshop.service.EmployeeService;
import com.intern.tailorshop.util.MapperHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private TailorShopRepo tailorShopRepo;

    @Autowired
    private MapperHelper mapperHelper;

    @Override
    public String addEmployee(EmployeeProxy proxy) {
        TailorShop tailorShop = tailorShopRepo.findById(proxy.getShopId()).orElseThrow(() -> new ShopNotFoundException("There is no Shop found with id " + proxy.getShopId()));

        Employee employee = mapperHelper.map(proxy, Employee.class);
        employee.setTailorShop(tailorShop);
        return employeeRepo.save(employee).toString();
    }

    @Override
    public List<EmployeeProxy> getAllEmployee(Long shopId) {
        return List.of();
    }

    @Override
    public String updateEmployee(Long id, EmployeeProxy proxy) {
        return "";
    }

    @Override
    public void deactivateEmployee(Long id) {

    }
}
