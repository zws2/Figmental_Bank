package com.company;

import java.util.Scanner;
import java.io.IOException;

//Collaborators: Zach Snyder, James Benton, Eileen Lowers
public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        LoginCred credentials = new LoginCred();
        UserAccess userAccess = new UserAccess(credentials.getLoginInfo());


        init(scan);

        //testAccount();
        //testTransaction();
    }

    private static void init(Scanner scan) {

        int option = 0;

        printHeader();
        printMainMenu();
        getInput(scan);

        testBank();
    }

    static void printHeader() {
        System.out.println("*********************************************");
        System.out.println("*             Welcome to the                *");
        System.out.println("*             Figmental Bank                *");
        System.out.println("*********************************************");
    }

    //prints out a fancy menu of choices
    static void printMainMenu() {
        System.out.println("*********************************************");
        System.out.println("Please choose one of the following options:");
        System.out.println("1) Existing Account Login");
        System.out.println("2) Account Registration");
        System.out.println("3) Exit");
        System.out.println("*********************************************");
    }

    //initializes option to zero, takes user input for MainMenu
    static void getInput(Scanner scan) {
        int option = 0;
        do {
            try {
                option = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Not a valid entry. Please enter option numbers.");
            }
            if (option < 1 || option > 3) {
                System.out.println("Sorry! Your selection is out of option range.\nPlease enter a listed option.");
            }
        }
        while (option < 1 || option > 3);
        performAction(option, scan);
    }

    static void performAction(int option, Scanner scan) {
        switch (option) {
            case 1:
                //option 1 - login existing account user
                UserAccess.loginUser(scan);
                break;
            case 2:
                //option 2 - register new account
                UserAccess.registerUser(scan);
                break;
            case 3:
                //option 3 - exit
                System.out.println("Thank you for banking with Figmental Bank!");
                System.exit(0);
                break;
            default:
                //any other input results in error and returns to beginning of the method
                System.out.println("Whoops! Something done broke!");
                performAction(option, scan);
        }

    }

    private static void testBank() {

        User u = new User();
        Bank b = new Bank();

        b.putUser(u);

        b.writeUsers();
        b.getUsers().clear();
        try {
            b.readUsers();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        User u1 = b.getUsers().get(u.getUserNum());

        if (u.info().equals(u1.info())) System.out.println("Successfully wrote and retrieved user from file");
        else System.out.println("Something went wrong...");

        Account a1 = new Account();
        Account a2 = new Account();
        Account a3 = new Account();

        b.putAccount(a1);
        b.putAccount(a2);
        b.putAccount(a3);

        b.writeAccounts();

        System.out.println("Accounts after added to list");
        for (Account a : b.getAccounts().values()) {
            System.out.println(a);
        }

        b.getAccounts().clear();

        try {
            b.readAccounts();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Accounts after read from file");
        for (Account a : b.getAccounts().values()) {
            System.out.println(a);
        }

    }

    private static void testAccount() {
        Bank b = new Bank();
        Account a = new Account(b.getBankNum());
        a.deposit(100d);
        System.out.println(a.accountDetails());
        a.withdraw(50d);
        System.out.println(a.accountDetails());
    }

    private static void testTransaction() {

        Bank b = new Bank();

        User u = new User();

        Account a1 = new Account(b.getBankNum());
        Account a2 = new Account(b.getBankNum());

        b.putAccount(a1);
        b.putAccount(a2);

        System.out.println(a1);
        System.out.println(a2);

        Transaction t = new Transaction(b.getBankNum(), "transfer", a1.getAccountNum(),
                a2.getAccountNum(), 100d);
        System.out.println(t);

        a1.depositTransaction(100d);

        t = a1.transfer(a2.getAccountNum(), 50d);
        System.out.println(t);
    }
}