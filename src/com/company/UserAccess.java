package com.company;

import java.util.Scanner;

public class UserAccess {

    public static void registerUser(Scanner scan) {
    }

    public static void loginUser(Scanner scan) {
            String inputUser;
            String inputPW;

            //user input to check username and password
            System.out.println("Username: ");
            inputUser = scan.nextLine();
            System.out.println("Password: ");
            inputPW = scan.nextLine();

//            //sends username and password to validLogin method to check against record
//            User.validLogin(inputUser, inputPW);
    }
}
