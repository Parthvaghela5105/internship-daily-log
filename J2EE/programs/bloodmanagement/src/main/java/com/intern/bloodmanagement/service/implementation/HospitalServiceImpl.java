package com.intern.bloodmanagement.service.implementation;

import com.intern.bloodmanagement.domain.BloodRequest;
import com.intern.bloodmanagement.domain.BloodStock;
import com.intern.bloodmanagement.domain.Hospital;
import com.intern.bloodmanagement.domain.Users;
import com.intern.bloodmanagement.proxy.BloodRequestHistoryProxy;
import com.intern.bloodmanagement.proxy.BloodRequestProxy;
import com.intern.bloodmanagement.proxy.HospitalProxy;
import com.intern.bloodmanagement.repository.BloodRequestRepo;
import com.intern.bloodmanagement.repository.BloodStockRepo;
import com.intern.bloodmanagement.repository.HospitalRepo;
import com.intern.bloodmanagement.service.HospitalService;
import com.intern.bloodmanagement.utility.MapperHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authorization.method.AuthorizeReturnObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Autowired
    private BloodStockRepo bloodStockRepo;

    @Override
    public String createHospital(HospitalProxy hospitalProxy) {
        Hospital map = mapperHelper.map(hospitalProxy, Hospital.class);
        Users users = mapperHelper.map(hospitalProxy.getUsers(), Users.class);
        if(users.getRole().equalsIgnoreCase("HOSPITAL"))
            map.setUsers(users);
        else
            throw new RuntimeException("You not select the required role user");
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
        String bloodGroup = bloodRequest.getBloodGroup();

        BloodStock bloodStock = bloodStockRepo.findByBloodGroup(bloodGroup).orElseThrow(() -> new RuntimeException("Blood group not available"));
        Double unitsAvailable = bloodStock.getUnitsAvailable();

        if(unitsAvailable > bloodRequest.getQuantity()){
            bloodRequest.setHospital(hospital);
            return bloodRequestRepo.save(bloodRequest).toString();
        }

        throw new RuntimeException("There not sufficient blood available");
    }

    @Override
    public List<BloodRequestHistoryProxy> requestHistory(Long id) {
        Hospital hospital = hospitalRepo.findById(id).orElseThrow(() -> new RuntimeException("Hospital Not Found"));
        List<BloodRequest> requests = bloodRequestRepo.findByHospital(hospital);
        List<BloodRequestHistoryProxy> list = new ArrayList<>();

        for(BloodRequest request : requests){
            BloodRequestHistoryProxy bloodRequestHistoryProxy = BloodRequestHistoryProxy.builder()
                    .id(request.getId())
                    .requestDate(request.getRequestDate())
                    .bloodGroup(request.getBloodGroup())
                    .status(request.getStatus())
                    .quantity(request.getQuantity())
                    .build();

            list.add(bloodRequestHistoryProxy);
        }

        return list;
    }
}
