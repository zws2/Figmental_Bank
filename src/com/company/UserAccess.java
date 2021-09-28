package com.company;

import java.util.HashMap;
import java.util.Scanner;

public class UserAccess {


    static HashMap<String, String> loginInfo = new HashMap<>();

    UserAccess(HashMap<String, String> loginInfoNew) {
        loginInfo = loginInfoNew;
    }

    public static void registerUser(Scanner scan) {
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
