package com.example.BankApplication.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
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

    public Long getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(Long transaction_id) {
        this.transaction_id = transaction_id;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getBankAcc_id() {
        return bankAcc_id;
    }

    public void setBankAcc_id(Long bankAcc_id) {
        this.bankAcc_id = bankAcc_id;
    }

    public Date getCreated_at() {
        return Created_at;
    }

    public void setCreated_at(Date created_at) {
        Created_at = created_at;
    }
}
