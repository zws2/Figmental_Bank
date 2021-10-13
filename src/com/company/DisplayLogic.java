package com.company;

import java.util.*;

public class DisplayLogic {

    static Scanner scan = new Scanner(System.in);

    //initializes option to zero, takes user input for Menus
    public static int getInput() {
        int option = 0;
        try {
            option = Integer.parseInt(scan.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Not a valid entry. Please enter option numbers.");
        }
        return option;
    }

    public static double getDoubleInput() {
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

    public static String getStringInput() {
        String input = "";
        do {
            try {
                input = scan.nextLine();
            } catch (NumberFormatException e) {
                System.out.println("Not a valid entry. Alphanumeric characters only.");
            }
        } while (!input.matches("[a-zA-Z0-9]+"));
        return input;
    }

    public static void registerUser() {

        String firstName;
        String lastName;
        String userName;
        String password;

        System.out.println("Thank you for creating an account with us.\n");
        System.out.println("Please enter your first name:");
        firstName = getStringInput();
        System.out.println("Please enter your last name:");
        lastName = getStringInput();

        System.out.println("Thank you, " + firstName + "!\n" +
                "To access your account, please enter a username and secure password.\n");

        do {
            System.out.println("Username: ");
            userName = getStringInput();
        }while(Bank.getUsers().get(userName) != null);

        System.out.println("Password: ");
        password = getStringInput();

        User user = new User(userName, password, firstName, lastName);
        Bank.putUser(user);
        Bank.writeUsers();

        //returns to user login menu
        System.out.println("Your account has been created!\n" +
                "Please login to continue or use option 3 to exit.");
        Display.printUserMenu();
    }

    public static User loginUser() {
        int attempts = 0;

        String inputUserName;
        String inputPassWord;

        do {
            System.out.println("Login");
            //user input to collect username and password
            System.out.println("Username: ");
            inputUserName = scan.nextLine();
            System.out.println("Password: ");
            inputPassWord = scan.nextLine();

            //validating username and password
            User currentUser = new User(inputUserName, inputPassWord);
            boolean validUser = currentUser.validateLogin();

            currentUser = Bank.getUsers().get(inputUserName);

            if (!validUser) {
                System.out.println("Invalid Login: User or password does not exist.\n");
                attempts++;
            }else {
                System.out.println("Login Success!\n");
                return currentUser;
            }
        } while (attempts < 3);

        System.out.println("You have exceeded the maximum number of login attempts.\n");
        return null;
    }

    public static void createAccount(User currentUser) {
        Account account = new Account(currentUser.getUserName());
        Bank.putAccount(account);
        Bank.writeAccounts();
        currentUser.addAccountNum(account.getAccountNum());
        Bank.putUser(currentUser);
        Bank.writeUsers();
    }
}