package com.example.BankApplication.controller;

import com.example.BankApplication.model.Bank_account;
import com.example.BankApplication.model.User;
import com.example.BankApplication.repository.BankAccRepository;
import com.example.BankApplication.repository.TransactionRepository;
import com.example.BankApplication.repository.UserRepository;
import com.example.BankApplication.services.CustomerDetails;
import com.example.BankApplication.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.transaction.Transactional;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserRepository repo;
    @Autowired
    private BankAccRepository bankAccRepository;
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserService service;

    @GetMapping("/newAccount")
    public String displayNewAccountForm(Model model){
        model.addAttribute("customer", new User());
        return "newAccount";
    }

    @PostMapping("/register")
    @Transactional
    public String CreateUserRegistration(User customer){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String newpassword = encoder.encode(customer.getPassword());
        customer.setPassword(newpassword);
        repo.save(customer);

        Bank_account bank_account = new Bank_account();
        bank_account.setCustomer(customer);
        bank_account.setBalance(0.00);

        bankAccRepository.save(bank_account);

        return "create_sucess";
    }


    @GetMapping("/accHome")
    public String gotoHomePage(Model model, @AuthenticationPrincipal CustomerDetails customerDetails){
        User customer = customerDetails.getCustomer();
        Bank_account bankAccount = customer.getBankAccount();

        List<User> listUsers =  repo.findAll();
        model.addAttribute("customer", listUsers);

        String balance = String.valueOf(bankAccount.getBalance());
        model.addAttribute("balance", balance);
        return "accHome";
    }

    @GetMapping("/userDetails")
    public String userProfile(@AuthenticationPrincipal CustomerDetails customerDetails, Model model){
        model.addAttribute("customerDetails",customerDetails );
        return "customerDetails";
    }

    @PostMapping("/userDetails/update")
    public String editUser(User customer, RedirectAttributes redirectAttributes,
                           @AuthenticationPrincipal CustomerDetails loggedCustomer){
        User cus = loggedCustomer.getCustomer();

        cus.setFirstName(customer.getFirstName());
        cus.setLastName(customer.getLastName());
        cus.setPhoneNumber(customer.getPhoneNumber());

        repo.save(cus);
        redirectAttributes.addFlashAttribute("message","Your Account Details have been Updated");

        return "redirect:/userDetails";
    }

    @GetMapping("/accHome/delete")
    @Transactional
    public String deleteUserDetails(
                           @AuthenticationPrincipal CustomerDetails loggedCustomer){
        User delCus = loggedCustomer.getCustomer();
        transactionRepository.deleteAll(delCus.getBankAccount().getTransactions());
        bankAccRepository.delete(delCus.getBankAccount());
        repo.delete(delCus);
        return "redirect:/login";
    }

}
