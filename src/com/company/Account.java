package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class Account implements Serializable {
    private String userName;
    private final int accountNum;
    private double balance;

    //this is used to generate new account nums so no duplicates are made
    private static int currentAccountNum = 100;

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
        return new Transaction("deposit", accountNum, amount);
    }

    //A person withdraws from their own account.
    public Transaction withdrawTransaction(double amount){
        if(balance >= amount){
            return new Transaction("withdraw", accountNum, amount);
        }else return new Transaction("declined", accountNum, amount);
    }

    //an account transfers money to another account
    //use this when you want to send a transaction to Bank
    public Transaction transferTransaction(int receiverNumber, double amount){
        if(balance >= amount && Bank.getAccounts().get(receiverNumber) != null){
            return new Transaction("transfer", accountNum, receiverNumber, amount);
        }else return new Transaction("declined", accountNum, receiverNumber, amount);
    }

    public ArrayList<Transaction> getAssociatedTransactions(){
        ArrayList<Transaction> transactions = new ArrayList<>();
        Bank.getTransactions().forEach(t -> {
            if(t.getReceiverNum() == accountNum || t.getSenderNum() == accountNum) transactions.add(t);
        });
        return transactions;
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
        while(Bank.getAccounts().containsKey(currentAccountNum)) currentAccountNum++;
        return currentAccountNum;
    }
}
