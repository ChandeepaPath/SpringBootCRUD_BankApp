package com.example.BankApplication.controller;

import com.example.BankApplication.model.Bank_account;
import com.example.BankApplication.model.Transactions;
import com.example.BankApplication.model.User;
import com.example.BankApplication.repository.BankAccRepository;
import com.example.BankApplication.services.CustomerDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BankAccController {
    @Autowired
    private BankAccRepository bankRepo;

    public BankAccController(BankAccRepository bankRepo) {
        this.bankRepo = bankRepo;
    }

    @GetMapping("/deposit")
    public String displayDeposits(Model model){
        model.addAttribute("transaction", new Transactions());
        return "deposit";
    }

    @GetMapping("/transactionHistory")
    public String displayHistory(Model model,
                                 @AuthenticationPrincipal CustomerDetails loggedCustomer){
        List<Transactions> transactions = loggedCustomer.getCustomer().getBankAccount().getTransactions();
        model.addAttribute("tranHistory", transactions);
        return "transactionHistory";
    }

}
