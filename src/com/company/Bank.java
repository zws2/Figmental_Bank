package com.company;

import java.io.*;
import java.util.HashMap;

public class Bank implements Serializable{

    private final int bankNum;
    private static int currentBankNum = 100;

    private HashMap<Integer, User> users = new  HashMap<Integer, User>();
    private HashMap<Integer, Account> accounts = new  HashMap<Integer, Account>();

    private static HashMap<Integer, Bank> banks = new  HashMap<Integer, Bank>();

    public Bank(){
        bankNum = getNewBankNum();
//        try {
//            try {
//                readAccountsFromFile();
//            }catch (EOFException ignored){}
//            try {
//                readUsersFromFile();
//            }catch (EOFException ignored){}
//        }catch(IOException | ClassNotFoundException e){
//            e.printStackTrace();
//        }
        banks.put(bankNum, this);
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

        writeAccountToFile(sender);
        writeAccountToFile(receiver);
    }

    public void makeWithdrawal(Transaction t){
        Account sender = accounts.get(t.getSenderNum());

        if(sender == null) {
            System.out.println("Withdrawal failed.");
            return;
        }

        sender.withdraw(t.getAmount());

        accounts.put(sender.getAccountNum(), sender);

        writeAccountToFile(sender);
    }

    public void makeDeposit(Transaction t){
        Account receiver = accounts.get(t.getReceiverNum());

        if(receiver == null) {
            System.out.println("Deposit failed.");
            return;
        }

        receiver.deposit(t.getAmount());

        accounts.put(receiver.getAccountNum(), receiver);

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
                users.put(u.getUserNum(), u);
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
                accounts.put(a.getAccountNum(), a);
            }catch (EOFException e){
                break;
            }
        }
    }

    public void addUser(User u){
        users.put(u.getUserNum(), u);
    }

    public void addAccount(Account a){
        accounts.put(a.getAccountNum(), a);
    }

    public static Bank get(int num){
        return banks.get(num);
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

    private static int getNewBankNum() {
        currentBankNum++;
        return currentBankNum;
    }

    public static HashMap<Integer, Bank> getBanks() {
        return banks;
    }

    public static void setBanks(HashMap<Integer, Bank> banks) {
        Bank.banks = banks;
    }

    public String toString(){
        return "" + bankNum;
    }
}