package com.example.BankApplication.services;

import com.example.BankApplication.model.Bank_account;
import com.example.BankApplication.model.Transactions;
import com.example.BankApplication.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class CustomerDetails implements UserDetails {

    private User customer;
    private Transactions transactions;
    private Bank_account bankAccount;


    public CustomerDetails(Bank_account bankAccount) {
        this.bankAccount = bankAccount;
    }

    public CustomerDetails(Transactions transactions) {
        this.transactions = transactions;
    }

    public CustomerDetails(User customer) {
        this.customer = customer;
    }

    public Bank_account getBankAccount() {
        return bankAccount;
    }
    public User getCustomer() {
        return customer;
    }
    public Transactions getTransactions(){
        return transactions;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return customer.getPassword();
    }

    @Override
    public String getUsername() {
        return customer.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true ;
    }

    public String getFullname(){
        return customer.getFirstName() + " " + customer.getLastName();
    }

    public String getBranch(){
        return customer.getBranch();
    }

    public String getAccNumber(){
        return customer.getAccNumber();
    }

    public String getPhoneNumber(){
        return customer.getPhoneNumber();
    }
    public String getFirstName(){
        return customer.getFirstName();
    }
    public String getLastName(){
        return customer.getLastName();
    }
    public Double getBalance(){return bankAccount.getBalance();}
    public Double getAmount(){return transactions.getAmount();}

    public void setPhoneNumber(String phoneNumer){
      this.customer.setPhoneNumber(phoneNumer);
    }
    public void setFirstName(String firstname){
        this.customer.setFirstName(firstname);
    }
    public void setLastName(String lastName){
        this.customer.setLastName(lastName );
    }

}
