package com.company;

import java.io.Serializable;

public class Account implements Serializable {
    private String userName;
    private final int accountNum;
    private double balance;

    //this is used to generate new account nums so no duplicates are made
    private static int currentAccountNum = 200;

    public Account(String userName, int accountNum, double balance) {
        this.userName = userName;
        this.accountNum = accountNum;
        this.balance = balance;
    }

    public Account(String userName) {
        this.userName = userName;
        this.accountNum = getNewAccountNum();
        balance = 0;
    }

    public Account() {
        userName = "" + User.newUserNum();
        accountNum = getNewAccountNum();
        balance = 0;
    }

    @Override
    public String toString() {
        return "Account{" +
                "userName='" + userName + '\'' +
                ", accountNum=" + accountNum +
                ", balance=" + balance +
                '}';
    }

    public String accountDetails(){
        return userName + "'s account\naccountNumber: " + accountNum
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
        return new Transaction("deposit", accountNum, amount);
    }

    //A person withdraws from their own account.
    public Transaction withdrawTransaction(double amount){
        if(balance >= amount){
            balance -= amount;
            //Bank.writeAccountToFile(this);
            return new Transaction("withdraw", accountNum, amount);
        }else return new Transaction("declined", accountNum, amount);
    }

    //an account transfers money to another account
    //use this when you want to send a transaction to Bank
    public Transaction transfer(int receiverNumber, double amount){
        if(withdraw(amount)){
            return new Transaction("transfer", accountNum, receiverNumber, amount);
        }else return new Transaction("declined", accountNum, receiverNumber, amount);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
