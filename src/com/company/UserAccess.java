package com.company;

import java.util.*;

public class UserAccess {

    public static void registerUser() {

        Scanner scan = Display.scan;

        String firstName;
        String lastName;
        String userName;
        String password;

        System.out.println("Thank you for creating an account with us.\n");
        System.out.println("Please enter your first name:");
        firstName = scan.nextLine();
        System.out.println("Please enter your last name:");
        lastName = scan.nextLine();

        System.out.println("Thank you, " + firstName + "!\n" +
                "To access your account, please enter a username and secure password.\n");
        System.out.println("Username: ");
        userName = scan.nextLine();

        //checking username exists?

        System.out.println("Password: ");
        password = scan.nextLine();

        User user = new User(userName, password, firstName, lastName);
        Bank.putUser(user);
        Bank.writeUsers();

        //returns to user login menu
        System.out.println("Your account has been created!\n" +
                "Please login to continue or use option 3 to exit.");
        Display.printUserMenu();
    }

    public static void registerAccount(User user) {

        Scanner scan = Display.scan;

        double deposit = 0;

        System.out.println("Would you like to open an account? \n" +
                "We require a minimum balance of $5.\n");

        String reply = null;
        do {
            try {
                reply = scan.nextLine();
            } catch (Exception ignored) {
                assert reply != null;
                reply = reply.toLowerCase();
            }
        } while (!(reply.equals("yes") || reply.equals("no") || reply.equals("y") || reply.equals("n")));

        System.out.println("How much would you like to deposit to open your account?");
        do {
            try {
                deposit = scan.nextDouble();
                if (!(deposit >= 5)) {
                    System.out.println("The amount you entered does not meet the minimum.");
                }
            } catch (Exception ignored) {
            }
        } while (deposit < 5d);

        System.out.println("The amount you entered is $" + deposit + ".");

        Account account = new Account();
        Bank.putAccount(account);
        Bank.writeAccounts();

//        account.depositTransaction(int bankNum, String userName, int accountNum, double balance);
    }

    public static User loginUser() {
        Scanner scan = Display.scan;
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

            if (!validUser) {
                System.out.println("Invalid Login: User or password does not exist.\n");
                attempts++;
            }
            if (validUser) {
                System.out.println("Login Success!\n");
                return currentUser;
            }
        } while (attempts < 3);

        System.out.println("You have exceeded the maximum number of login attempts.\n");
        return null;
    }
}