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


//    public boolean makeTransfer(int receiverNumber, double amount){
//        if(withdraw(amount)){
//            Transaction t = new Transaction("transfer", accountNumber, receiverNumber, amount);
//        }
//        return true;
//    }
    //A person deposits money into their own account.
    public Transaction depositTransaction(double amount){
        balance += amount;
        //Bank.writeAccountToFile(this);
        return new Transaction("deposit", accountNumber, amount);
    }

    //A person withdraws from their own account.
    public Transaction withdrawTransaction(double amount){
        if(balance >= amount){
            balance -= amount;
            //Bank.writeAccountToFile(this);
            return new Transaction("withdraw", accountNumber, amount);
        }else return new Transaction("declined", accountNumber, amount);
    }

    //an account transfers money to another account
    //use this when you want to send a transaction to Bank
    public Transaction transfer(int receiverNumber, double amount){
        if(withdraw(amount)){
            return new Transaction("transfer", accountNumber, receiverNumber, amount);
        }else return new Transaction("declined", accountNumber, receiverNumber, amount);
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
