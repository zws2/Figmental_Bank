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

    public String toString(){
        return name + ", " + accountNumber + ", " + balance + "\n";
    }

    public String accountDetails(){
        return name + "'s account\naccountNumber: " + accountNumber
                + "\n + balance: " + balance;
    }

    public void deposit(double amount){
        balance += amount;
    }

    public boolean withdraw(double amount){
        if(balance >= amount){
            balance -= amount;
            return true;
        }else return false;
    }

    public boolean makeTransfer(int recieverNumber, double amount){
//        if(withdraw(amount)){
//            Transaction t = new Transaction("transfer", accountNumber, recieverNumber, amount);
//        }
//        return true;
    }

    public String getName() {
        return name;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public float getBalance() {
        return balance;
    }

}
