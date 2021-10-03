package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Display {

    static Scanner scan = new Scanner(System.in);
    static int option = 0;

    public static void startMenu() {
        printHeader();
        printUserMenu();
    }

    static void printHeader() {
        System.out.println("*********************************************");
        System.out.println("*             Welcome to the                *");
        System.out.println("*             Figmental Bank                *");
        System.out.println("*********************************************");
    }

    //prints out a fancy menu of choices
    static void printUserMenu() {
        System.out.println("*********************************************");
        System.out.println("Please choose one of the following options:");
        System.out.println("1) Existing Account Login");
        System.out.println("2) Account Registration");
        System.out.println("3) Exit");
        System.out.println("*********************************************");
        userMenu();
    }

    private static void printAccountMenu(User currentUser) {
        System.out.println("*********************************************");
        System.out.println("Please choose one of the following options:");
        System.out.println("1) Create New Account");
        System.out.println("2) View Accounts");
        System.out.println("3) Exit");
        System.out.println("*********************************************");
        manageAccountMenu(currentUser);
    }

    private static void selectAccountMenu(User currentUser) {
    }

    private static void printManageAccountMenu() {
        System.out.println("*********************************************");
        System.out.println("Please choose one of the following options:");
        System.out.println("1) Check Balance");
        System.out.println("2) Make a Deposit");
        System.out.println("3) Make a Withdraw");
        System.out.println("4) Transfer Funds");
        System.out.println("5) View Transactions");
        System.out.println("6) Exit");
        System.out.println("*********************************************");
        viewAccountMenu();
    }



    //initializes option to zero, takes user input for Menus
    static int getInput() {
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

    static void userMenu() {
        switch (getInput()) {
            case 1:
                //option 1 - login existing user
                User currentUser = UserAccess.loginUser();
                if(currentUser != null) {
                    printAccountMenu(currentUser);
                } else {
                    System.out.println("Invalid login!");
                }
                break;
            case 2:
                //option 2 - register new user
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
                userMenu();
        }

    }

    static void manageAccountMenu(User currentUser) {
        switch (getInput()) {
            case 1:
                //create new account
                createUserAcct(currentUser);
                printAccountMenu(currentUser);
                break;
            case 2:
                //get account list method
                printAccountList(currentUser);
                selectAccountMenu(currentUser);
                break;
            case 3:
                //option 3 - exit
                System.out.println("Thank you for banking with Figmental Bank!");
                System.exit(0);
                break;
            default:
                //any other input results in error and returns to beginning of the method
                System.out.println("Whoops! Something done broke!");
                manageAccountMenu(currentUser);
        }
    }

    private static void createUserAcct(User currentUser) {
        Account userAcct = new Account(currentUser.getUserName());
        Bank.putAccount(userAcct);
        Bank.writeAccounts();
        currentUser.addAccountNum(userAcct.getAccountNum());
        Bank.putUser(currentUser);
        Bank.writeUsers();
    }


    private static void printAccountList(User currentUser) {
        ArrayList<Account> accountList = currentUser.getAccounts();
        if (accountList.size() == 0) {
            System.out.println("No accounts are registered to this user.");
            printAccountMenu(currentUser);
        }
        else {
            for(int i = 1; i < accountList.size() + 1; i++) {
               System.out.println(i + ") " + accountList.get(i - 1));
            }
        }
    }

    static void viewAccountMenu() {
        switch (getInput()) {
            case 1:
                //balance
//                printBalance();
                break;
            case 2:
                //deposit
//                inputDeposit();
                break;
            case 3:
                //withdraw
//                inputWithdraw();
                break;
            case 4:
                //transfer
//                inputTransfer();
                break;
            case 5:
                //transactions print
//                printTransaction();
                break;
            case 6:
                //exit
                System.out.println("Thank you for banking with Figmental Bank!");
                System.exit(0);
                break;
            default:
                //any other input results in error and returns to beginning of the method
                System.out.println("Whoops! Something done broke!");
                viewAccountMenu();
        }
    }



//    private static void printBalance() {
//    }
//    private static void inputDeposit() {
//    }
//    private static void inputWithdraw() {
//    }
//    private static void inputTransfer() {
//    }
//    private static void printTransaction() {
//        Bank.getTransactionArrayList();
//    }
//    private static void printAccountList() {
//        //getAccountNumbers?
//    }

}
