package com.example.BankApplication.controller;

import com.example.BankApplication.model.Bank_account;
import com.example.BankApplication.model.Transactions;
import com.example.BankApplication.model.User;
import com.example.BankApplication.repository.BankAccRepository;
import com.example.BankApplication.repository.TransactionRepository;
import com.example.BankApplication.services.CustomerDetails;
import org.apache.catalina.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.transaction.Transactional;

@Controller
public class TransactionController {
    @Autowired
    private BankAccRepository bankAccRepository;
    @Autowired
    private TransactionRepository transactionRepository;

    @PostMapping("/deposit/confirm")
    @Transactional
    public String CreateUserRegistration(Transactions tran,RedirectAttributes redirectAttributes
                                         ){
        transactionRepository.save(tran);
        redirectAttributes.addFlashAttribute("message","Your Cash Deposit - Completed Successfully");
        return "redirect:/deposit";
    }

}
