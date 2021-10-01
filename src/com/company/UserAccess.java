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

        System.out.println("Thank you, " + firstName + lastName + "!\n" +
                "Your User Account has been created!\n" +
                "To access your account, please enter a username and secure password.\n");

        System.out.println("Username: ");
        userName = scan.nextLine();
        System.out.println("Password: ");
        password = scan.nextLine();

        User user = new User(userName, password, firstName, lastName);
        Bank.putUser(user);
        Bank.writeUsers();

//        loginUser();
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
        }while(!(reply.equals("yes") || reply.equals("no") || reply.equals("y") || reply.equals("n")));

        System.out.println("How much would you like to deposit to open your account?");
        do {
            try {
                deposit = scan.nextDouble();
                if(!(deposit >= 5)) {
                    System.out.println("The amount you entered does not meet the minimum.");
                }
            } catch (Exception ignored) {
            }
        }while(deposit < 5d);

        System.out.println("The amount you entered is $" + deposit + ".");

        Account account = new Account();
        Bank.putAccount(account);
        Bank.writeAccounts();

//        account.depositTransaction(int bankNum, String userName, int accountNum, double balance);
    }

//    public static void loginUser() {
//
//        Scanner scan = Display.scan;
//
//        String inputUser;
//        String inputPW;
//
//        while (true) {
//            //user input to check username and password
//            System.out.println("Username: ");
//            inputUser = scan.nextLine();
//            if (!getUserName.containsKey(inputUser)) {
//                System.out.println("Invalid Login: User does not exist.\n");
//            }
//            else {
//                System.out.println("Password: ");
//                inputPW = scan.nextLine();
//                if(!loginInfo.get(inputUser).equals(inputPW)) {
//                    System.out.println("Invalid Login: Password does not match.\n");
//                }
//                else {
//                    System.out.println("Login Success!\n");
//                }
//            }
//        }

        //sends username and password to validLogin method to check against record
//        User.validLogin(inputUser, inputPW);
//    }
}
