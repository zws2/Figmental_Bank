package com.company;

import java.util.ArrayList;
import static com.company.DisplayLogic.*;

public class Display {

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
        manageAccountsForUserMenu(currentUser);
    }

    private static void printSelectAccountMenu(User currentUser) {
        System.out.println("*********************************************");

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

        System.out.println((currentUser.getAccounts().size()+1) + ") Exit");
        System.out.println("*********************************************");
        selectAccountMenu(currentUser);
    }

    private static void printManageAccountMenu(Account currentAccount) {
        System.out.println("*********************************************");
        System.out.println("Please choose one of the following options:");
        System.out.println("1) Check Balance");
        System.out.println("2) Make a Deposit");
        System.out.println("3) Make a Withdraw");
        System.out.println("4) Transfer Funds");
        System.out.println("5) View Transactions");
        System.out.println("6) Exit");
        System.out.println("*********************************************");
        manageAccountMenu(currentAccount);
    }

    private static void selectAccountMenu(User currentUser){

        int input = getInput();
        int size = currentUser.getAccounts().size();

        if(input == size+1){
            System.out.println("Thank you for banking with Figmental Bank!");
            System.exit(0);
        }else if(input > 0 && input <= size){
            printManageAccountMenu(currentUser.getAccounts().get(input-1));
        }else {
            System.out.println("Your selection is out of range.");
            selectAccountMenu(currentUser);
        }
    }

    static void userMenu() {
        switch (getInput()) {
            case 1:
                //option 1 - login existing user
                User currentUser = DisplayLogic.loginUser();
                if(currentUser != null) {
                    printAccountMenu(currentUser);
                } else {
                    System.out.println("Invalid login!");
                }
                break;
            case 2:
                //option 2 - register new user
                DisplayLogic.registerUser();
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

    static void manageAccountsForUserMenu(User currentUser) {
        switch (getInput()) {
            case 1:
                //create new account
                createAccount(currentUser);
                printAccountMenu(currentUser);
                break;
            case 2:
                //get account list method
                printSelectAccountMenu(currentUser);
                break;
            case 3:
                //exit
                System.out.println("Thank you for banking with Figmental Bank!");
                System.exit(0);
                break;
            default:
                //any other input results in error and returns to beginning of the method
                System.out.println("Whoops! Something done broke!");
                manageAccountsForUserMenu(currentUser);
        }
    }

    static void manageAccountMenu(Account currentAccount) {
        double amount;
        switch (getInput()) {
            case 1:
                //balance
                System.out.println("Current account balance: " + currentAccount.getBalance());
                break;
            case 2:
                //deposit
                System.out.println("Please enter an amount to deposit: ");
                amount = getDoubleInput();
                currentAccount.depositTransaction(amount);
                break;
            case 3:
                //withdraw
                System.out.println("Please enter an amount to withdraw: ");
                amount = getDoubleInput();
                currentAccount.withdrawTransaction(amount);
                break;
            case 4:
                //transfer
                System.out.println("Please enter an amount to transfer: ");
                amount = getDoubleInput();

                System.out.println("Please enter an account number to transfer the amount to: ");
                int bankNum = getInput();
                currentAccount.transfer(bankNum, amount);
                break;
            case 5:
                //transactions print
//                printTransaction();
                System.out.println("Beep boop.");
                break;
            case 6:
                //exit
                System.out.println("Thank you for banking with Figmental Bank!");
                System.exit(0);
                break;
            default:
                //any other input results in error and returns to beginning of the method
                System.out.println("Whoops! Something done broke!");
        }
        printManageAccountMenu(currentAccount);
    }
}
