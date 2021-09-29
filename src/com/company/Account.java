package com.company;

import java.io.Serializable;

public class Account implements Serializable {
    private int bankNum;
    private int userNum;
    private final int accountNum;
    private double balance;

    //this is used to generate new account nums so no duplicates are made
    private static int currentAccountNum = 10000;

    public Account(int bankNum, int userNum, int accountNum, double balance) {
        this.bankNum = bankNum;
        this.userNum = userNum;
        this.accountNum = accountNum;
        this.balance = balance;
    }

    public Account(int bankNum, int userNum) {
        this.bankNum = bankNum;
        this.userNum = userNum;
        this.accountNum = getNewAccountNum();
        balance = 0;
    }

    public Account(int bankNum) {
        this.bankNum = bankNum;
        accountNum = getNewAccountNum();
        balance = 0;

    }

    public Account() {
        bankNum = 101;
        userNum = 10001;
        accountNum = getNewAccountNum();
        balance = 0;
    }

    public String toString(){
        return bankNum + ", " + userNum + ", " + accountNum + ", " + balance;
    }

    public String accountDetails(){
        return userNum + "'s account\naccountNumber: " + accountNum
                + "\nbalance: " + balance;
    }

    //use this to update an account object undergoing a transaction.
    public void deposit(double amount){
        balance += amount;
    }

    //use this to update an account object undergoing a transaction.
    public boolean withdraw(double amount){
        if(balance >= amount){
            balance -= amount;
            return true;
        }else return false;
    }

    //A person deposits money into their own account.
    public Transaction depositTransaction(double amount){
        balance += amount;
        //Bank.writeAccountToFile(this);
        return new Transaction(bankNum,"deposit", accountNum, amount);
    }

    //A person withdraws from their own account.
    public Transaction withdrawTransaction(double amount){
        if(balance >= amount){
            balance -= amount;
            //Bank.writeAccountToFile(this);
            return new Transaction(bankNum, "withdraw", accountNum, amount);
        }else return new Transaction(bankNum,"declined", accountNum, amount);
    }

    //an account transfers money to another account
    //use this when you want to send a transaction to Bank
    public Transaction transfer(int receiverNumber, double amount){
        if(withdraw(amount)){
            return new Transaction(bankNum,"transfer", accountNum, receiverNumber, amount);
        }else return new Transaction(bankNum,"declined", accountNum, receiverNumber, amount);
    }

    public int getBankNum() {
        return bankNum;
    }

    public void setBankNum(int bankNum) {
        this.bankNum = bankNum;
    }

    public int getUserNum() {
        return userNum;
    }

    public void setUserNum(int userNum) {
        this.userNum = userNum;
    }

    public int getAccountNum() {
        return accountNum;
    }

    public double getBalance() {
        return balance;
    }

    private static int getNewAccountNum() {
        currentAccountNum++;
        return currentAccountNum;
    }
}
