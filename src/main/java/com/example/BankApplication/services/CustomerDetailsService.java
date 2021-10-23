package com.example.BankApplication.services;

import com.example.BankApplication.model.User;
import com.example.BankApplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Optional;

public class CustomerDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> cus = repo.findByEmail(email);
        if(cus.isEmpty()){
            throw new UsernameNotFoundException("User Not Found");
        }
        return new CustomerDetails(cus.get());
    }

    public List<User> listAll(){
        return (List<User>) repo.findAll();
    }
}
