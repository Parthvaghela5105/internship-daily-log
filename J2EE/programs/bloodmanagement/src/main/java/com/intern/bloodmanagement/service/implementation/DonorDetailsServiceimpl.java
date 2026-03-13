package com.intern.bloodmanagement.service.implementation;

import com.intern.bloodmanagement.domain.Donation;
import com.intern.bloodmanagement.domain.DonorDetails;
import com.intern.bloodmanagement.domain.Users;
import com.intern.bloodmanagement.proxy.DonationHistoryProxy;
import com.intern.bloodmanagement.proxy.DonationProxy;
import com.intern.bloodmanagement.proxy.DonorDetailsProxy;
import com.intern.bloodmanagement.repository.DonationRepo;
import com.intern.bloodmanagement.repository.DonorDetailsRepo;
import com.intern.bloodmanagement.repository.UserRepo;
import com.intern.bloodmanagement.service.DonorDetailsService;
import com.intern.bloodmanagement.utility.MapperHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DonorDetailsServiceimpl implements DonorDetailsService {

    @Autowired
    private DonorDetailsRepo donorDetailsRepo;

    @Autowired
    private DonationRepo donationRepo;

    @Autowired
    private MapperHelper mapperHelper;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public DonorDetailsProxy getDonorDetails(Long id) {
        Optional<DonorDetails> donor = donorDetailsRepo.findById(id);
        return mapperHelper.map(donor, DonorDetailsProxy.class);
    }

    @Override
    public String updateDonorDetails(DonorDetailsProxy donorDetailsProxy) {
        Users users = userRepo.findById(donorDetailsProxy.getUsers().getId()).orElseThrow(() -> new RuntimeException("No user found"));
        if(!users.getRole().equalsIgnoreCase("DONOR")){
            throw new RuntimeException("User not found with DONOR role");
        }

        Optional<DonorDetails> optionalDonorDetails = donorDetailsRepo.findByUsers(mapperHelper.map(donorDetailsProxy.getUsers(), Users.class));
        DonorDetails donor = mapperHelper.map(donorDetailsProxy, DonorDetails.class);
        DonorDetails save = new DonorDetails();

        if(optionalDonorDetails.isPresent()){
            DonorDetails donorDetails = optionalDonorDetails.get();
            donor.setId(donorDetails.getId());
            Users map = mapperHelper.map(donorDetailsProxy.getUsers(), Users.class);
            map.setPassword(passwordEncoder.encode(map.getPassword()));
//            userRepo.save(map);
            donor.setUsers(map);
            save = donorDetailsRepo.save(donor);
        }else{
            save = donorDetailsRepo.save(mapperHelper.map(donorDetailsProxy , DonorDetails.class));
        }
        return "updated successfully";
    }

    @Override
    public String donateBlood(DonationProxy donationProxy) {
        Long id = donationProxy.getDonorDetails().getId();
        DonorDetails donorDetails = donorDetailsRepo.findById(id).orElseThrow(() -> new RuntimeException("Donor is not found"));
        Donation donation = mapperHelper.map(donationProxy, Donation.class);
        donation.setDonationDate(LocalDate.now());
        donation.setRemarks("PENDING");
        donation.setDonorDetails(donorDetails);
        return donationRepo.save(donation).toString();
    }

    @Override
    public List<DonationHistoryProxy>  donerHistory(Long id) {
        DonorDetails donorDetails = donorDetailsRepo.findById(id).orElseThrow(() -> new RuntimeException("Donor not found"));
        List<Donation> donations = donationRepo.findByDonorDetails(donorDetails).orElseThrow(() -> new RuntimeException("No DonerDetails found with id " + id));

        List<DonationHistoryProxy> list = new ArrayList<>();
        for(Donation donation:donations){
            DonationHistoryProxy donationHistoryProxy = DonationHistoryProxy.builder()
                    .id(donation.getId())
                    .donationDate(donation.getDonationDate())
                    .quantity(donation.getQuantity())
                    .remarks(donation.getRemarks())
                    .build();
            list.add(donationHistoryProxy);
        }
        return list;
    }
}
