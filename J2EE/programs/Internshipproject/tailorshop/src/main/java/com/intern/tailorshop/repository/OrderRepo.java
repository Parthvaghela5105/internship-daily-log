package com.intern.tailorshop.repository;

import com.intern.tailorshop.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface OrderRepo extends JpaRepository<Order, Long> {
}