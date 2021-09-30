package com.company;

import java.io.Serializable;

public class User implements Serializable {

    private String firstName;

    private String lastName;

    private final int userNum;

    private double balance;

    private String password;

    public static int currentAccountNum = 10000;

    public User(){
        firstName = "firstName";
        lastName = "lastName";
        userNum = getNewAccountNum();
        balance = 0;
        password = "password";
    }

    public User(String firstName, String lastName, double balance, String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.userNum = getNewAccountNum();
        this.balance = balance;
        this.password = password;
    }

    public User(String firstName, String lastName, int userNum, double balance, String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.userNum = userNum;
        this.balance = balance;
        this.password = password;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }
    public void setPassword(String password){
        this.password = password;
    }

    public static int getNewAccountNum(){
        currentAccountNum++;
        return currentAccountNum;
    }

    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public int getUserNum(){
        return userNum;
    }
    public double getBalance(){
        return balance;
    }
    public String getPassword(){
        return password;
    }

    public String info(){
        return "User Account : [First Name=" + firstName +
                ", Last Name=" + lastName +
                ", Account No.=" + userNum +
                ", Balance :=" + balance +
                "]";
    }

    public String toString(){
        return firstName +
                ", " + lastName +
                ", " + userNum +
                ", " + balance;
    }
}