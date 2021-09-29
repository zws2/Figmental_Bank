package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Bank {

    private int bankNum;

    private HashMap<Integer, User> users = new  HashMap<Integer, User>();
    private  HashMap<Integer, Account> accounts = new  HashMap<Integer, Account>();

    public Bank(){
        bankNum = 1;
        try {
            readAccountsFromFile();
            readUsersFromFile();
        }catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public void processTransaction(Transaction t){

        switch(t.getTransactionType()){
            case "transfer": makeTransfer(t);
                break;
            case "deposit": makeDeposit(t);
                break;
            case "withdraw": makeWithdrawal(t);
                break;
            default: break;
        }
    }

    public void makeTransfer(Transaction t){
        Account sender = accounts.get(t.getSenderNum());
        Account receiver = accounts.get(t.getReceiverNum());

        sender.withdraw(t.getAmount());
        receiver.deposit(t.getAmount());

        accounts.put(sender.getAccountNumber(), sender);
        accounts.put(receiver.getAccountNumber(), receiver);

        writeAccountToFile(sender);
        writeAccountToFile(receiver);
    }

    public void makeWithdrawal(Transaction t){
        Account sender = accounts.get(t.getSenderNum());

        sender.withdraw(t.getAmount());

        accounts.put(sender.getAccountNumber(), sender);

        writeAccountToFile(sender);
    }

    public void makeDeposit(Transaction t){
        Account receiver = accounts.get(t.getReceiverNum());

        receiver.deposit(t.getAmount());

        accounts.put(receiver.getAccountNumber(), receiver);

        writeAccountToFile(receiver);
    }

    public void writeUserToFile(User user){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src\\com\\company\\users.txt"))){
            oos.writeObject(user);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void writeAccountToFile(Account account){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src\\com\\company\\accounts.txt"))){
            oos.writeObject(account);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void readUsersFromFile() throws IOException, ClassNotFoundException{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src\\com\\company\\users.txt"));
        while(true){
            try{
                User u = (User)ois.readObject();
                users.put(u.getAcctNo(), u);
            }catch (EOFException e){
                break;
            }
        }
    }

    public void readAccountsFromFile() throws IOException, ClassNotFoundException{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src\\com\\company\\accounts.txt"));
        while(true){
            try{
                Account a = (Account)ois.readObject();
                accounts.put(a.getAccountNumber(), a);
            }catch (EOFException e){
                break;
            }
        }
    }

    public void setBankNum(int bankNum){
        this.bankNum = bankNum;
    }

    public int getBankNum(){
        return bankNum;
    }

    public HashMap<Integer, User> getUsers() {
        return users;
    }

    public void setUsers(HashMap<Integer, User> users) {
        this.users = users;
    }

    public HashMap<Integer, Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(HashMap<Integer, Account> accounts) {
        this.accounts = accounts;
    }
}