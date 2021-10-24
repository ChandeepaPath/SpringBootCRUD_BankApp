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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Controller
public class TransactionController {
    @Autowired
    private BankAccRepository bankAccRepository;
    @Autowired
    private TransactionRepository transactionRepository;

    @PostMapping("/deposit/confirm")
    @Transactional
    public String depositCash(Transactions tran, RedirectAttributes redirectAttributes, Model model,
                               @AuthenticationPrincipal CustomerDetails loggedCustomer){
        Bank_account bank_account = loggedCustomer.getCustomer().getBankAccount();

        tran.setCreated_at(new Date());
        tran.setBankAccount(bank_account);
        bank_account.setBalance(bank_account.getBalance()+ tran.getAmount());
        bankAccRepository.save(bank_account);
        transactionRepository.save(tran);
        redirectAttributes.addFlashAttribute("message","Your Cash Deposit - Completed Successfully");
        model.addAttribute("transactions", tran);
        return "redirect:/deposit";
    }

}
