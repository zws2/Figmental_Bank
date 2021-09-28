package com.company;

public class Account {
    String name;
    int accountNumber;
    double balance;

    public Account(String name, int accountNumber, double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public Account(String name, int accountNumber) {
        this.name = name;
        this.accountNumber = accountNumber;
        balance = 0;
    }

    public Account() {
        name = "n/a";
        accountNumber = 0;
        balance = 0;
    }

    public String toString(){
        return name + ", " + accountNumber + ", " + balance + "\n";
    }

    public String accountDetails(){
        return name + "'s account\naccountNumber: " + accountNumber
                + "\nbalance: " + balance;
    }

    public void deposit(double amount){
        balance += amount;
        new Transaction("deposit", accountNumber, amount);
    }

    public boolean withdraw(double amount){
        if(balance >= amount){
            balance -= amount;
            new Transaction("withdraw", accountNumber, amount);
            return true;
        }else return false;
    }

    public boolean transfer(int receiverNumber, double amount){
        if(withdraw(amount)){
            new Transaction("transfer", accountNumber, receiverNumber, amount);
            return true;
        }else return false;
    }

    public String getName() {
        return name;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

}
