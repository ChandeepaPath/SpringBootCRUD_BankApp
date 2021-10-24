package com.example.BankApplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
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
    private double amount;

    @Column(name ="timestamp")
    @CreationTimestamp
    private Date Created_at;

    @ManyToOne
    @JoinColumn(name = "bank_accid", nullable = false)
    private Bank_account bankAccount;

}
