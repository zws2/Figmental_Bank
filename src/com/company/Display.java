package com.company;

import java.util.Scanner;

public class Display {

    static Scanner scan = new Scanner(System.in);


    void printHeader() {
        System.out.println("*********************************************");
        System.out.println("*             Welcome to the                *");
        System.out.println("*             Figmental Bank                *");
        System.out.println("*********************************************");
    }

    //prints out a fancy menu of choices
    void printMainMenu() {
        System.out.println("*********************************************");
        System.out.println("Please choose one of the following options:");
        System.out.println("1) Existing Account Login");
        System.out.println("2) Account Registration");
        System.out.println("3) Exit");
        System.out.println("*********************************************");
        getMainInput();
    }

    void printAccountMenu() {
        System.out.println("*********************************************");
        System.out.println("Please choose one of the following options:");
        System.out.println("1) Create New Account");
        System.out.println("2) View Accounts");
        System.out.println("3) Exit");
        System.out.println("*********************************************");
        manageAccountMenu();
    }

    //initializes option to zero, takes user input for MainMenu
    void getMainInput() {
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
        userMenu(option);
    }

    void userMenu(int option) {
        switch (option) {
            case 1:
                //option 1 - login existing user
                UserAccess.loginUser();
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
                userMenu(option);
        }
    }

    private void manageAccountMenu() {
        int option = 0;
        switch (option) {
            case 1:
                //create new account
                break;
            case 2:
                //select account / get account list method
                break;
            case 3:
                //option 3 - exit
                System.out.println("Thank you for banking with Figmental Bank!");
                System.exit(0);
                break;
            default:
                //any other input results in error and returns to beginning of the method
                System.out.println("Whoops! Something done broke!");
                viewAccountMenu(option);
        }
    }

    private void viewAccountMenu(int option) {
        switch (option) {
            case 1:
                //balance
                break;
            case 2:
                //deposit
                break;
            case 3:
                //withdraw
                break;
            case 4:
                //transfer
                break;
            case 5:
                //transactions print
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
}
