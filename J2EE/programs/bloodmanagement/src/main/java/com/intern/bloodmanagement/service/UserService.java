package com.intern.bloodmanagement.service;

import com.intern.bloodmanagement.proxy.HospitalProxy;
import com.intern.bloodmanagement.proxy.UserProxy;

import java.util.List;

public interface UserService {

    List<UserProxy> getByBloodGroup(String bloodGroup);
    List<UserProxy> getDonor();
    List<HospitalProxy> getHospitals();
}
