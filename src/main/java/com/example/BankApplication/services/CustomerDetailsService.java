package com.example.BankApplication.services;

import com.example.BankApplication.model.User;
import com.example.BankApplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class CustomerDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User cus = repo.findByEmail(email);
        if(cus == null){
            throw new UsernameNotFoundException("User Not Found");
        }
        return new CustomerDetails(cus);
    }

    public List<User> listAll(){
        return (List<User>) repo.findAll();
    }
}
