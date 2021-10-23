package com.example.BankApplication;
import com.example.BankApplication.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Maincontroller {

    private UserRepository repo;

    @GetMapping("")
    public String displayHomePage(){
        return "index";
    }

    @GetMapping("/login")
    public String displayloginForm(Model model){
        return "login";
    }

}
