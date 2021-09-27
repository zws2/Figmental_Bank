package com.company;

public class Account {
    String name;
    int accountNumber;
    float balance;

    public Account(String name, int accountNumber, float balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public Account() {
        name = "n/a";
        accountNumber = 0;
        balance = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = bootybalance;
    }
}
