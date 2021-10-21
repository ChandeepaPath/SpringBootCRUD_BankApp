package com.example.BankApplication.controller;

import com.example.BankApplication.model.User;
import com.example.BankApplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserRepository repo;

    public UserController(UserRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/newAccount")
    public String displayNewAccountForm(Model model){
        model.addAttribute("customer", new User());
        return "newAccount";
    }

    @PostMapping("/register")
    public String CreateUserRegistration(User customer){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String newpassword = encoder.encode(customer.getPassword());
        customer.setPassword(newpassword);
        this.repo.save(customer);
        return "create_sucess";
    }


    @GetMapping("/accHome")
    public String gotoHomePage(Model model){
        List<User> listUsers =  repo.findAll();
        model.addAttribute("customer", listUsers);
        return "accHome";
    }

}
