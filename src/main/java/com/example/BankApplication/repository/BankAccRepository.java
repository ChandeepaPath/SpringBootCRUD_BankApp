package com.example.BankApplication.repository;

import com.example.BankApplication.model.Bank_account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccRepository extends JpaRepository<Bank_account, Long>{
}
