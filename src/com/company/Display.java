package com.company;

import java.util.Scanner;

public class Display {

    static Scanner scan = new Scanner(System.in);
    static int option = 0;

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
        getInput(option);
        userMenu(option);
    }

    static void printAccountMenu() {
        System.out.println("*********************************************");
        System.out.println("Please choose one of the following options:");
        System.out.println("1) Create New Account");
        System.out.println("2) View Accounts");
        System.out.println("3) Exit");
        System.out.println("*********************************************");
        getInput(option);
        manageAccountMenu(option);
    }

    static void printManageAccountMenu() {
        System.out.println("*********************************************");
        System.out.println("Please choose one of the following options:");
        System.out.println("1) Check Balance");
        System.out.println("2) Make a Deposit");
        System.out.println("3) Make a Withdraw");
        System.out.println("4) Transfer Funds");
        System.out.println("5) View Transactions");
        System.out.println("6) Exit");
        System.out.println("*********************************************");
        getInput(option);
        viewAccountMenu(option);
    }

    //initializes option to zero, takes user input for Menus
    static int getInput(int option) {
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
        return option;
    }

    static void userMenu(int option) {
        switch (option) {
            case 1:
                //option 1 - login existing account user
//                UserAccess.loginUser();
                break;
            case 2:
                //option 2 - register new account
                UserAccess.registerUser();
                break;
            case 3:
                //option 3 - exit
                System.out.println("Thank you for banking with Figmental Bank!");
                System.exit(0);
                break;
            default:
                //any other input results in error and returns to beginning of the method
                System.out.println("Whoops! Something done broke!");
                userMenu(option);
        }
    }

    static void manageAccountMenu(int option) {
        switch (option) {
            case 1:
                //create new account
                //add to bank hashmap - HashMap<Integer, Account> accounts
                //add to userlist - addAccountNum?
                break;
            case 2:
                //select account / get account list method
                printAccountList();
                break;
            case 3:
                //option 3 - exit
                System.out.println("Thank you for banking with Figmental Bank!");
                System.exit(0);
                break;
            default:
                //any other input results in error and returns to beginning of the method
                System.out.println("Whoops! Something done broke!");
                manageAccountMenu(option);
        }
    }

    static void viewAccountMenu(int option) {
        switch (option) {
            case 1:
                //balance
                printBalance();
                break;
            case 2:
                //deposit
                inputDeposit();
                break;
            case 3:
                //withdraw
                inputWithdraw();
                break;
            case 4:
                //transfer
                inputTransfer();
                break;
            case 5:
                //transactions print
                printTransaction();
                break;
            case 6:
                //exit
                System.out.println("Thank you for banking with Figmental Bank!");
                System.exit(0);
                break;
            default:
                //any other input results in error and returns to beginning of the method
                System.out.println("Whoops! Something done broke!");
                viewAccountMenu(option);
        }
    }

    private static void printBalance() {
    }
    private static void inputDeposit() {
    }
    private static void inputWithdraw() {
    }
    private static void inputTransfer() {
    }
    private static void printTransaction() {
    }
    private static void printAccountList() {
        //getAccountNumbers?
    }

}
