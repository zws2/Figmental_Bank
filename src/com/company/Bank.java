package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Bank implements Serializable{

    private static HashMap<String, User> users = new  HashMap<>();
    private static HashMap<Integer, Account> accounts = new  HashMap<>();
    private static ArrayList<Transaction> transactions = new ArrayList<>();

    public static void initBank(){
        readAccounts();
        readUsers();
        readTransaction();
    }

    @Override
    public String toString() {
        return "Bank{" +
                ", users=" + users +
                ", accounts=" + accounts +
                '}';
    }

    public static void processTransaction(Transaction t){
        transactions.add(t);
        writeTransactions();
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

    public static void makeTransfer(Transaction t){
        Account sender = accounts.get(t.getSenderNum());
        Account receiver = accounts.get(t.getReceiverNum());

        if(sender == null || receiver == null) {
            System.out.println("Recipient not found.");
            return;
        }
        if(!sender.withdraw(t.getAmount())){
            System.out.println("Insufficient funds for transfer.");
            return;
        }
        receiver.deposit(t.getAmount());

        accounts.put(sender.getAccountNum(), sender);
        accounts.put(receiver.getAccountNum(), receiver);

        putAccount(sender);
        putAccount(receiver);
        writeAccounts();
    }

    public static void makeWithdrawal(Transaction t){
        Account sender = accounts.get(t.getSenderNum());

        if(sender == null) {
            System.out.println("Account not found.");
            return;
        }
        if(!sender.withdraw(t.getAmount())){
            System.out.println("Insufficient funds for transfer.");
            return;
        }

        putAccount(sender);
        writeAccounts();
    }

    public static void makeDeposit(Transaction t){
        Account receiver = accounts.get(t.getReceiverNum());

        if(receiver == null) {
            System.out.println("Account not found.");
            return;
        }

        receiver.deposit(t.getAmount());

        putAccount(receiver);
        writeAccounts();
    }

    public static void writeUsers(){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src\\com\\company\\users.txt"))){
            oos.writeObject(users);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void writeAccounts(){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src\\com\\company\\accounts.txt"))){
            oos.writeObject(accounts);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void writeTransactions(){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src\\com\\company\\transactions.txt"))){
            oos.writeObject(transactions);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static void readUsers() {
        try{
            try {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src\\com\\company\\users.txt"));
                Object obj = ois.readObject();
                if (obj instanceof HashMap) users = (HashMap<String, User>) obj;

            } catch (EOFException ignored) {}
        }catch(IOException | ClassNotFoundException ignored){
                System.out.println("Error reading users.");
        }
    }

    @SuppressWarnings("unchecked")
    public static void readAccounts(){
        try{
            try{
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src\\com\\company\\accounts.txt"));
                Object obj = ois.readObject();
                if(obj instanceof HashMap) accounts = (HashMap<Integer, Account>) obj;
            }catch (EOFException ignored){}
        }catch(IOException | ClassNotFoundException ignored){
            System.out.println("Error reading accounts.");
        }
    }

    @SuppressWarnings("unchecked")
    public static void readTransaction(){
        try{
            try{
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src\\com\\company\\transactions.txt"));
                Object obj = ois.readObject();
                if(obj instanceof ArrayList) transactions = (ArrayList<Transaction>) obj;
            }catch (EOFException ignored){}
        }catch(IOException | ClassNotFoundException ignored){
            System.out.println("Error reading transactions.");
        }
    }

    public static void putUser(User u){
        users.put(u.getUserName(), u);
        writeUsers();
    }

    public static void putAccount(Account a){
        accounts.put(a.getAccountNum(), a);
        writeAccounts();
    }

    public static HashMap<String, User> getUsers() {
        return users;
    }

    public static HashMap<Integer, Account> getAccounts() {
        return accounts;
    }

    public static ArrayList<Transaction> getTransactions() {
        return transactions;
    }
}