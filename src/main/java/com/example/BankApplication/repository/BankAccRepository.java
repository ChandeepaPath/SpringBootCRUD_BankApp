package com.example.BankApplication.repository;

import com.example.BankApplication.model.Bank_account;
import com.example.BankApplication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BankAccRepository extends JpaRepository<Bank_account, Long>{
    Optional<Bank_account> findByCustomerId(Long customer_id);
}
