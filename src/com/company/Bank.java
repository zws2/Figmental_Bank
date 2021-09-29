package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Bank {

    private String bankNum;

    private HashMap<Integer, User> users = new  HashMap<Integer, User>();
    private  HashMap<Integer, Account> accounts = new  HashMap<Integer, Account>();

    public Bank(){}

    //Serializing user to file
    public void writeUserToFile(User user){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src\\com\\company\\users.txt"))){
            oos.writeObject(user);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    //Serializing Accounts to file
    public void writeAccountToFile(Account account){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src\\com\\company\\accounts.txt"))){
            oos.writeObject(account);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    //Deserializing users from file
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

    //Deserializing Account from file
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

    public void setBankNum(String bankNum){
        this.bankNum = bankNum;
    }

    public String getBankNum(){
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