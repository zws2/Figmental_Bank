package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class UserAccess {


    static HashMap<String, String> loginInfo = new HashMap<>();

    UserAccess(HashMap<String, String> loginInfoNew) {
        loginInfo = loginInfoNew;
    }

    public static void registerUser(Scanner scan) {
        Random random = new Random();

        String firstName;
        String lastName;
        String acctNo = "1";
        double deposit = 0;
        double balance = 0;
        String username;
        String password;

        ArrayList<String> accountSet = new ArrayList<>();

        System.out.println("Thank you for creating an account with us.\n");
        System.out.println("Please enter your first name:");
        firstName = scan.nextLine();
        System.out.println("Please enter your last name:");
        lastName = scan.nextLine();

        for (int i = 0; i < 2; i++)
        {
            int n = random.nextInt(10);
            acctNo += Integer.toString(n);
        }

        System.out.println("Thank you, " + firstName + "!\n" +
                "To open an account, we require a minimum balance of $5.\n" +
                "How much would you like to deposit to open your account?");
        deposit = scan.nextDouble();
        if(!(deposit >= 5)) {
            System.out.println("The amount you entered does not meet the minimum.");
        }
        else {
            System.out.println("The amount you entered is $" + deposit + ".");
            balance = balance + deposit;
        }

        accountSet.add(firstName);
        accountSet.add(lastName);
        accountSet.add(acctNo);
        accountSet.add(String.valueOf(balance));

        System.out.println("Thank you, " + firstName + lastName + "!\n" +
                "Your account has been created!\n" +
                "Your account number is " + acctNo + "and your new balance is " + balance + ".\n" +
                "To access your account, please enter a username and secure password.\n");

        System.out.println("Username: ");
        username = scan.nextLine();
        System.out.println("Password: ");
        password = scan.nextLine();

        loginInfo.put(username, password);

    }

    public static void loginUser(Scanner scan) throws NullPointerException {
        String inputUser;
        String inputPW;

        while (true) {
            //user input to check username and password
            System.out.println("Username: ");
            inputUser = scan.nextLine();
            if (!loginInfo.containsKey(inputUser)) {
                System.out.println("Invalid Login: User does not exist.\n");
            }
            else {
                System.out.println("Password: ");
                inputPW = scan.nextLine();
                if(!loginInfo.get(inputUser).equals(inputPW)) {
                    System.out.println("Invalid Login: Password does not match.\n");
                }
                else {
                    System.out.println("Login Success!\n");
                }
            }
        }

        //sends username and password to validLogin method to check against record
//        User.validLogin(inputUser, inputPW);
    }
}
