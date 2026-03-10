package com.intern.bloodmanagement.service;


import com.intern.bloodmanagement.domain.BloodStock;
import com.intern.bloodmanagement.proxy.BloodStockProxy;
import com.intern.bloodmanagement.proxy.UserProxy;

import java.util.List;

public interface AdminService {
    List<UserProxy> getAllUser();
    String approve(Long id);
    String addBloodStock(BloodStockProxy bloodStockProxy);
}
