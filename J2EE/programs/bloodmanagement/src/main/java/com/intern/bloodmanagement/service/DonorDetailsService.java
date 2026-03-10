package com.intern.bloodmanagement.service;

import com.intern.bloodmanagement.proxy.DonationHistoryProxy;
import com.intern.bloodmanagement.proxy.DonationProxy;
import com.intern.bloodmanagement.proxy.DonorDetailsProxy;
import jakarta.transaction.Transactional;

import java.util.List;

public interface DonorDetailsService {


    DonorDetailsProxy getDonorDetails(Long id);

    String updateDonorDetails(DonorDetailsProxy donorDetailsProxy);

    @Transactional
    String donateBlood(DonationProxy donationProxy);

    List<DonationHistoryProxy> donerHistory(Long id);
}
