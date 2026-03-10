package com.intern.bloodmanagement.service;

import com.intern.bloodmanagement.domain.Hospital;
import com.intern.bloodmanagement.proxy.BloodRequestProxy;
import com.intern.bloodmanagement.proxy.HospitalProxy;

import java.util.List;

public interface HospitalService {

    String createHospital(HospitalProxy hospitalProxy);

    HospitalProxy getProfile(Long id);

    String hospitalBloodRequest(BloodRequestProxy bloodRequestProxy);

    List<BloodRequestProxy> requestHistory(Long id);
}
