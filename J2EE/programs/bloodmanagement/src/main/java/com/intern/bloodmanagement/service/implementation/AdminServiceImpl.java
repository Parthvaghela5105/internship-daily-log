package com.intern.bloodmanagement.service.implementation;

import com.intern.bloodmanagement.domain.BloodRequest;
import com.intern.bloodmanagement.domain.BloodStock;
import com.intern.bloodmanagement.domain.Donation;
import com.intern.bloodmanagement.domain.Users;
import com.intern.bloodmanagement.proxy.BloodStockProxy;
import com.intern.bloodmanagement.proxy.UserProxy;
import com.intern.bloodmanagement.repository.BloodRequestRepo;
import com.intern.bloodmanagement.repository.BloodStockRepo;
import com.intern.bloodmanagement.repository.DonationRepo;
import com.intern.bloodmanagement.repository.UserRepo;
import com.intern.bloodmanagement.service.AdminService;
import com.intern.bloodmanagement.utility.MapperHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private MapperHelper mapperHelper;

    @Autowired
    private BloodStockRepo bloodStockRepo;

    @Autowired
    private BloodRequestRepo bloodRequestRepo;

    @Autowired
    private DonationRepo donationRepo;

    @Override
    public List<UserProxy> getAllUser() {
        List<Users> all = userRepo.findAll();
        return all.stream().map(users -> mapperHelper.map(users , UserProxy.class)).toList();
    }

    @Override
    public String approve(Long id) {
        Optional<Donation> optionalDonation = donationRepo.findById(id);
        if(optionalDonation.isPresent()){
            Donation donation = optionalDonation.get();
            String bloodGroup = donation.getDonorDetails().getBloodGroup();

            BloodStock bloodStock = bloodStockRepo.findByBloodGroup(bloodGroup).orElseThrow(() -> new RuntimeException("No Blood Stock found"));
            donation.setRemarks("APPROVE");
            bloodStock.setUnitsAvailable(bloodStock.getUnitsAvailable() + donation.getQuantity());

            bloodStockRepo.save(bloodStock);
            donationRepo.save(donation);
        }
        return "Approved Successfully";
    }

    @Override
    public String addBloodStock(BloodStockProxy bloodStockProxy) {
        BloodStock bloodStock = mapperHelper.map(bloodStockProxy, BloodStock.class);
        bloodStock.setLastUpdated(LocalDateTime.now());
        bloodStock.setUnitsAvailable(0.0);
        return bloodStockRepo.save(bloodStock).toString();
    }
}
