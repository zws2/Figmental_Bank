<<<<<<< HEAD
import java.io.Serializable;

public class User implements Serializable {
    
    private String firstName;
    
    private String lastName;
    
    private String acctNo;
    
    private double balance;
    
    private String password;
    
    public User(){}
    
    public User(String firstName, String lastName, String acctNo, double balance, String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.acctNo = acctNo;
        this.balance = balance;
        this.password = password;
    }
    
=======
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

>>>>>>> main
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
<<<<<<< HEAD
    public void setAcctNo(String acctNo){
        this.acctNo = acctNo;
    }
=======
>>>>>>> main
    public void setBalance(double balance){
        this.balance = balance;
    }
    public void setPassword(String password){
        this.password = password;
    }
<<<<<<< HEAD
    
=======

    public static int getNewAccountNum(){
        currentAccountNum++;
        return currentAccountNum;
    }

>>>>>>> main
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
<<<<<<< HEAD
    public String getAcctNo(){
        return acctNo;
=======
    public int getUserNum(){
        return userNum;
>>>>>>> main
    }
    public double getBalance(){
        return balance;
    }
    public String getPassword(){
        return password;
    }
<<<<<<< HEAD
    
    public String toString(){
        return "User Account : [First Name=" + firstName +
                                ", Last Name=" + lastName +
                                ", Account No.=" + acctNo +
                                ", Balance :=" + balance +
                                "]";
=======

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
>>>>>>> main
    }
}