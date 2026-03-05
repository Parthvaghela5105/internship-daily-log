package com.intern.tailorshop.repository;

import com.intern.tailorshop.domain.Payment;
import org.springframework.data.repository.Repository;

public interface PaymentRepo extends Repository<Payment, Long> {
}