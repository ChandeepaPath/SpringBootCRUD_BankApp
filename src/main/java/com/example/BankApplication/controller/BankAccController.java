package com.example.BankApplication.controller;

import com.example.BankApplication.model.Bank_account;
import com.example.BankApplication.model.User;
import com.example.BankApplication.repository.BankAccRepository;
import com.example.BankApplication.services.CustomerDetails;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BankAccController {
    private BankAccRepository bankRepo;

    public BankAccController(BankAccRepository bankRepo) {
        this.bankRepo = bankRepo;
    }

    @GetMapping("/deposit")
    public String displayDeposits(Model model){
//        model.addAttribute("bankacc", new Bank_account());
        return "deposit";
    }

}
