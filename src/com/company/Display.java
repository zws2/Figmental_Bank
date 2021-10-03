package com.company;

import java.util.Scanner;

public class Display {

    static Scanner scan = new Scanner(System.in);


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
        printAccountList(currentUser);
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



    //initializes option to zero, takes user input for Menus
    static int getInput() {
        int option = 0;
        try {
            option = Integer.parseInt(scan.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Not a valid entry. Please enter option numbers.");
        }
        return option;
    }

    static double getDoubleInput() {
        double amount = 0;
        do {
            try {
                amount = Double.parseDouble(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Not a valid entry. Please enter option numbers.");
            }
            if (amount < 0) {
                System.out.println("Please enter a positive number.");
            }
        }
        while (amount < 0 );
        return amount;
    }

    void performAction(int option) {
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
                performAction(option);
        }
    }

    static void manageAccountsForUserMenu(User currentUser) {
        switch (getInput()) {
            case 1:
                //create new account
                createUserAcct(currentUser);
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

    static void manageAccountMenu(Account currentAccount) {
        double amount = 0;
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
                manageAccountMenu(currentAccount);
        }
    }
}
