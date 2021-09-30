package com.company;

import java.io.*;
import java.util.HashMap;

public class Bank implements Serializable{

    private final int bankNum;
    private static int currentBankNum = 0;

    private HashMap<String, User> users = new  HashMap<String, User>();
    private HashMap<Integer, Account> accounts = new  HashMap<Integer, Account>();

    private static HashMap<Integer, Bank> banks = new  HashMap<Integer, Bank>();

    public Bank(){
        bankNum = getNewBankNum();
        readAccounts();
        readUsers();
        banks.put(bankNum, this);
    }

    @Override
    public String toString() {
        return "Bank{" +
                "bankNum=" + bankNum +
                ", users=" + users +
                ", accounts=" + accounts +
                '}';
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

        if(sender == null || receiver == null) {
            System.out.println("Transfer failed.");
            return;
        }

        sender.withdraw(t.getAmount());
        receiver.deposit(t.getAmount());

        accounts.put(sender.getAccountNum(), sender);
        accounts.put(receiver.getAccountNum(), receiver);

        putAccount(sender);
        putAccount(receiver);
        writeAccounts();
    }

    public void makeWithdrawal(Transaction t){
        Account sender = accounts.get(t.getSenderNum());

        if(sender == null) {
            System.out.println("Withdrawal failed.");
            return;
        }

        sender.withdraw(t.getAmount());

        putAccount(sender);
        writeAccounts();
    }

    public void makeDeposit(Transaction t){
        Account receiver = accounts.get(t.getReceiverNum());

        if(receiver == null) {
            System.out.println("Deposit failed.");
            return;
        }

        receiver.deposit(t.getAmount());

        putAccount(receiver);
        writeAccounts();
    }

    public void writeUsers(){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src\\com\\company\\users.txt"))){
            oos.writeObject(users);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void writeAccounts(){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src\\com\\company\\accounts.txt"))){
            oos.writeObject(accounts);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public void readUsers() {
        try{
            try {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src\\com\\company\\users.txt"));
                Object obj = ois.readObject();
                if (obj instanceof HashMap) users = (HashMap<String, User>) obj;

            } catch (EOFException ignored) {}
        }catch(IOException | ClassNotFoundException e){
                e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public void readAccounts(){
        try{
            try{
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src\\com\\company\\accounts.txt"));
                Object obj = ois.readObject();
                if(obj instanceof HashMap) accounts = (HashMap<Integer, Account>) obj;
            }catch (EOFException ignored){}
        }catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public void putUser(User u){
        users.put(u.getUserName(), u);
    }

    public static int getNewBankNum() {
        currentBankNum++;
        return currentBankNum;
    }

    public void putAccount(Account a){
        accounts.put(a.getAccountNum(), a);
    }

    public static Bank get(int num){
        return banks.get(num);
    }

    public int getBankNum(){
        return bankNum;
    }

    public HashMap<String, User> getUsers() {
        return users;
    }

    public void setUsers(HashMap<String, User> users) {
        this.users = users;
    }

    public void setAccounts(HashMap<Integer, Account> accounts) {
        this.accounts = accounts;
    }

    public static void setBanks(HashMap<Integer, Bank> banks) {
        Bank.banks = banks;
    }

    public HashMap<Integer, Account> getAccounts() {
        return accounts;
    }

    public static HashMap<Integer, Bank> getBanks() {
        return banks;
    }


}