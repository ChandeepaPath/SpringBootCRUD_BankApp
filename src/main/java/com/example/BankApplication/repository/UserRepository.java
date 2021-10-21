package com.example.BankApplication.repository;

import com.example.BankApplication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Query("SELECT c FROM User c WHERE c.email = ?1")
    User findByEmail(String email);
}
