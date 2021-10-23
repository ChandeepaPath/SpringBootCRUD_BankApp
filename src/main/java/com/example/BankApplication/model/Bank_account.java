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
@Table(name = "bank_account")
public class Bank_account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long banckAccID;

    @Column(nullable = true)
    private Double balance;

    @OneToOne
    @JoinColumn
    private User customer;

    @Column(name ="timestamp")
    @CreationTimestamp
    private Date createdAt;


}
