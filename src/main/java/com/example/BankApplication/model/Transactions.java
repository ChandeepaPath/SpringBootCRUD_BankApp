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
@Table(name = "transactions")
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transaction_id;

    @Column(nullable = false, length = 10)
    private Long amount;

    @Column(nullable = false)
    private Long bankAcc_id;

    @Column(name ="timestamp")
    @CreationTimestamp
    private Date Created_at;

    @ManyToOne
    @JoinColumn
    private Bank_account bankAccount;

}
