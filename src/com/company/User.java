package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {

    public static int currentUserNum = 100;

    private final String userName;
    private String password;

    private String firstName;
    private String lastName;

    private ArrayList<Integer> accountsNumbers;

    public User(){

        userName = "" + getNewAccountNum();
        password = "password";

        firstName = "firstName";
        lastName = "lastName";

        accountsNumbers = new ArrayList<Integer>();

    }

    public User(String userName, String password){

        this.userName = userName;
        this.password = password;

        firstName = "firstName";
        lastName = "lastName";

        accountsNumbers = new ArrayList<Integer>();

    }

    public User(String userName, String password, String firstName, String lastName){
        this.userName = userName;
        this.password = password;

        this.firstName = firstName;
        this.lastName = lastName;

        accountsNumbers = new ArrayList<Integer>();
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", accountsNumbers=" + accountsNumbers +
                '}';
    }

    public boolean validateLogin(Bank b){
        User storedUser = b.getUsers().get(userName);

        return (storedUser.password.equals(password));
    }

    public boolean userNameAvailable(Bank b){
        User storedUser = b.getUsers().get(userName);

        return (storedUser == null);
    }

    public static int getNewAccountNum(){
        currentUserNum++;
        return currentUserNum;
    }

    public void addAccountNum(int num){
        accountsNumbers.add(num);
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

    public void setAccountsNumbers(ArrayList<Integer> accountsNumbers) {
        this.accountsNumbers = accountsNumbers;
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

    public ArrayList<Integer> getAccountsNumbers() {
        return accountsNumbers;
    }

}