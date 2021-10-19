package com.example.BankApplication;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Maincontroller {

    private UserRepository repo;

    @GetMapping("")
    public String displayHomePage(){
        return "index";
    }

    @GetMapping("/newAccount")
    public String displayNewAccountForm(Model model){
        model.addAttribute("customer", new User());
        return "newAccount";
    }

    @GetMapping("/login")
    public String displayloginForm(Model model){

        return "login";
    }

    @PostMapping("/register")
    public String CreateUserRegistration(User customer){
        repo.save(customer);
        return "create_sucess";
    }
}
