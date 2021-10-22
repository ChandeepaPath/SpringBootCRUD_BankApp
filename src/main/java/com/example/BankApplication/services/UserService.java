package com.example.BankApplication.services;

import com.example.BankApplication.model.User;
import com.example.BankApplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;

    public List<User> listAll(){
        return (List<User>) repo.findAll();
    }

//    public User findByUser(String un){
//        return repo.findByEmail(un);
//    }
}
