package com.intern.bloodmanagement.service.implementation;

import com.intern.bloodmanagement.domain.BloodRequest;
import com.intern.bloodmanagement.domain.Hospital;
import com.intern.bloodmanagement.domain.Users;
import com.intern.bloodmanagement.proxy.BloodRequestProxy;
import com.intern.bloodmanagement.proxy.HospitalProxy;
import com.intern.bloodmanagement.repository.BloodRequestRepo;
import com.intern.bloodmanagement.repository.HospitalRepo;
import com.intern.bloodmanagement.service.HospitalService;
import com.intern.bloodmanagement.utility.MapperHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authorization.method.AuthorizeReturnObject;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class HospitalServiceImpl implements HospitalService {

    @Autowired
    private HospitalRepo hospitalRepo;

    @Autowired
    private MapperHelper mapperHelper;

    @Autowired
    private BloodRequestRepo bloodRequestRepo;

    @Override
    public String createHospital(HospitalProxy hospitalProxy) {
        Hospital map = mapperHelper.map(hospitalProxy, Hospital.class);
        Users users = mapperHelper.map(hospitalProxy.getUsers(), Users.class);
        map.setUsers(users);
        return hospitalRepo.save(map).toString();
    }

    @Override
    public HospitalProxy getProfile(Long id) {
        Hospital hospital= hospitalRepo.findById(id).orElseThrow(() -> new RuntimeException("Hospital not found exception"));
        return mapperHelper.map(hospital , HospitalProxy.class);
    }

    @Override
    public String hospitalBloodRequest(BloodRequestProxy bloodRequestProxy) {
        BloodRequest bloodRequest = mapperHelper.map(bloodRequestProxy, BloodRequest.class);
        Hospital hospital = hospitalRepo.findById(bloodRequest.getHospital().getId()).orElseThrow(() -> new RuntimeException("Hospital Not Found"));
        bloodRequest.setHospital(hospital);
        return bloodRequestRepo.save(bloodRequest).toString();
    }

    @Override
    public List<BloodRequestProxy> requestHistory(Long id) {
        Hospital hospital = hospitalRepo.findById(id).orElseThrow(() -> new RuntimeException("Hospital Not Found"));
        List<BloodRequest> byHospital = bloodRequestRepo.findByHospital(hospital);
        return byHospital.stream().map(request -> mapperHelper.map(request, BloodRequestProxy.class)).toList();
    }
}
