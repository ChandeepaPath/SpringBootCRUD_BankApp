package com.example.BankApplication.repository;

import com.example.BankApplication.model.Bank_account;
import com.example.BankApplication.model.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transactions, Long> {
//    Optional<Transactions> findByBankAcc_id(String transaction_id) ;
}
