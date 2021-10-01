package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {

    public static int currentUserNum = 100;

    private final String userName;
    private String password;

    private String firstName;
    private String lastName;

    private ArrayList<Integer> accountNumbers;

    private ArrayList<Transaction> userTransactions = new ArrayList<>();

    public User(){

        userName = "" + newUserNum();
        password = "password";

        firstName = "firstName";
        lastName = "lastName";

        accountNumbers = new ArrayList<Integer>();

    }

    public User(String userName, String password){

        this.userName = userName;
        this.password = password;

        firstName = "firstName";
        lastName = "lastName";

        accountNumbers = new ArrayList<Integer>();

    }

    public User(String userName, String password, String firstName, String lastName){
        this.userName = userName;
        this.password = password;

        this.firstName = firstName;
        this.lastName = lastName;

        accountNumbers = new ArrayList<Integer>();
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", accountsNumbers=" + accountNumbers +
                '}';
    }

    public ArrayList<Account> getAccounts(){

        ArrayList<Account> accountsForUser = new ArrayList<Account>();
        for(int num: accountNumbers){
            accountsForUser.add(Bank.getAccounts().get(num));
        }

        return accountsForUser;
    }

    public boolean validateLogin(Bank b){
        User storedUser = b.getUsers().get(userName);

        return (storedUser.password.equals(password));
    }

    public boolean userNameAvailable(Bank b){
        User storedUser = b.getUsers().get(userName);

        return (storedUser == null);
    }

    public static int newUserNum(){
        currentUserNum++;
        return currentUserNum;
    }

    public void addAccountNum(int num){
        accountNumbers.add(num);
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setAccountNumbers(ArrayList<Integer> accountNumbers) {
        this.accountNumbers = accountNumbers;
    }

    public String getUserName(){
        return userName;
    }

    public String getPassword(){
        return password;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public ArrayList<Integer> getAccountNumbers() {
        return accountNumbers;
    }

    public ArrayList<Transaction> getUserTransactions() {
        return userTransactions;
    }

    public void setUserTransactions(ArrayList<Transaction> userTransactions) {
        this.userTransactions = userTransactions;
    }

    public void addUserTransaction(Transaction transaction){
        userTransactions.add(transaction);
    }
}