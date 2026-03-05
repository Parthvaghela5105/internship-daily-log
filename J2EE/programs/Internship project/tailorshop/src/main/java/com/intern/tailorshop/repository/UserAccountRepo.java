package com.intern.tailorshop.repository;

import com.intern.tailorshop.domain.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface UserAccountRepo extends JpaRepository<UserAccount, Long> {
    Optional<UserAccount> findByUsername(String username);
}