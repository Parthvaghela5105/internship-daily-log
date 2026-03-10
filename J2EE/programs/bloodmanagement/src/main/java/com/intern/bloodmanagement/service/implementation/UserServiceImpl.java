package com.intern.bloodmanagement.service.implementation;

import com.intern.bloodmanagement.domain.DonorDetails;
import com.intern.bloodmanagement.proxy.HospitalProxy;
import com.intern.bloodmanagement.proxy.UserProxy;
import com.intern.bloodmanagement.repository.DonorDetailsRepo;
import com.intern.bloodmanagement.repository.UserRepo;
import com.intern.bloodmanagement.service.UserService;
import com.intern.bloodmanagement.utility.MapperHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private DonorDetailsRepo donorDetailsRepo;

    @Autowired
    private MapperHelper mapperHelper;

    @Override
    public List<UserProxy> getByBloodGroup(String bloodGroup) {
        Optional<List<DonorDetails>> optList = donorDetailsRepo.findByBloodGroup(bloodGroup);
        List<UserProxy> list = new ArrayList<>();
        if(optList.isPresent()){
            List<DonorDetails> donorDetails = optList.get();
            for (DonorDetails details: donorDetails){
                UserProxy userProxy = UserProxy.builder()
                        .id(details.getUsers().getId())
                        .name(details.getUsers().getName())
                        .email(details.getUsers().getEmail())
                        .phone(details.getUsers().getPhone())
                        .status(details.getUsers().getStatus())
                        .build();
                list.add(userProxy);
            }
        }

        return list;
    }

    @Override
    public List<UserProxy> getDonor() {
        List<DonorDetails> all = donorDetailsRepo.findAll();

        List<UserProxy> list = new ArrayList<>();

        for(DonorDetails details : all){
            UserProxy userProxy = UserProxy.builder()
                    .id(details.getUsers().getId())
                    .name(details.getUsers().getName())
                    .email(details.getUsers().getEmail())
                    .phone(details.getUsers().getPhone())
                    .status(details.getUsers().getStatus())
                    .build();
            list.add(userProxy);
        }
        return list;
    }

    @Override
    public List<HospitalProxy> getHospitals() {
        return List.of();
    }
}
