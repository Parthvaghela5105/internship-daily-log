package com.intern.tailorshop.repository;

import com.intern.tailorshop.domain.TailorShop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TailorShopRepo extends JpaRepository<TailorShop , Long> {
}
