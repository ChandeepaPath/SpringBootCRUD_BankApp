package com.example.BankApplication.controller;

import com.example.BankApplication.model.User;
import com.example.BankApplication.repository.UserRepository;
import com.example.BankApplication.services.CustomerDetails;
import com.example.BankApplication.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
    @Autowired
    private UserService service;

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
        String accNumber =  "12346545645" ;
        String balance = "34567";
        model.addAttribute("accNumber", accNumber);
        model.addAttribute("balance", balance);
        return "accHome";
    }


    //    @GetMapping("/accHome/userDetails")
//    public String displayProfile(Model model, Principal principal){
//        String un = principal.getName();
//        model.addAttribute("cusDetails", service.listAll(un));
//        return "customerDetails";
//    }
    @GetMapping("/userDetails")
    public String userProfile(@AuthenticationPrincipal CustomerDetails customerDetails, Model model){
//        List<User> listUsers = service.listAll();
//        model.addAttribute("listUsers", listUsers);
        model.addAttribute("customerDetails",customerDetails );
        return "customerDetails";
    }
    //    @GetMapping("/accHome")
//    public String accHomePage(Model model){
//        List<User> listUsers =  repo.findAll();
//        model.addAttribute("users", listUsers);
//        return "accHome";
//    }

}
