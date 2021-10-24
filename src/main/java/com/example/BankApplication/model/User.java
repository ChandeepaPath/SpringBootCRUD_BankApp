package com.example.BankApplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customer")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 45)
    private String email;

    @Column(nullable = false, length = 64)
    private  String password;

    @Column(nullable = false, length = 20)
    private String firstName;

    @Column(nullable = false, length = 20)
    private String lastName;

    @Column(nullable = false, length = 45)
    private String Branch;

    @Column(nullable = false, length = 10)
    private String accNumber;

    @Column(nullable = false, length = 20)
    private String Username;

    @Column(nullable = false, length = 10)
    private String phoneNumber;

    @Column(name ="timestamp")
    @CreationTimestamp
    private Date Created_at;

    @OneToOne(mappedBy = "customer")
    private Bank_account bankAccount;

}
