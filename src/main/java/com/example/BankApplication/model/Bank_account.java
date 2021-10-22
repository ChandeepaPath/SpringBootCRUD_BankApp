package com.example.BankApplication.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "bank_account")
public class Bank_account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long banckAccID;

    @Column(nullable = true)
    private Double balance;

    @Column(nullable = false)
    private Long customer_id;

    @Column(name ="timestamp")
    @CreationTimestamp
    private Date Created_at;

    public Bank_account(Long banckAccID, Double balance, Long customer_id, Date created_at) {
        this.banckAccID = banckAccID;
        this.balance = balance;
        this.customer_id = customer_id;
        Created_at = created_at;
    }

    public Bank_account() {

    }

    public Long getBanckAccID() {
        return banckAccID;
    }

    public void setBanckAccID(Long banckAccID) {
        this.banckAccID = banckAccID;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }

    public Date getCreated_at() {
        return Created_at;
    }

    public void setCreated_at(Date created_at) {
        Created_at = created_at;
    }
}
