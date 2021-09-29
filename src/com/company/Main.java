package com.company;

import java.io.IOException;

//Collaborators: Zach Snyder, James Benton, Eileen Lowers
public class Main {
    public static void main(String[] args) {


        //init();

        //testAccount();
        //testTransaction();

        testBank();


    }

    private static void init(){
        int option = 0;
        Display display = new Display();
//        UserAccess userAccess = new UserAccess();

        Display.printHeader();
        Display.printMainMenu();
        display.getInput();
    }

    private static void testBank(){

        User u = new User();
        Bank b = new Bank();


        b.writeUserToFile(u);
        try{
            b.readUsersFromFile();
        }catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }

        User u1 = b.getUsers().get(u.getAcctNo());

        if(u.info().equals(u1.info())) System.out.println("Successfully wrote and retrieved user from file");
        else System.out.println("Something went wrong...");

    }

    private static void testAccount(){
        Account a = new Account("Zach", 123);
        a.deposit(100d);
        System.out.println(a.accountDetails());
        a.withdraw(50d);
        System.out.println(a.accountDetails());
    }

    private static void testTransaction(){
        Transaction t = new Transaction("transfer", 100, 101, 100d);
        System.out.println(t);

        Account a = new Account("Zach", 123);
        a.deposit(100d);

        Account b = new Account("Carl", 124);

        t = a.transfer(b.accountNumber, 50d);
        System.out.println(t);
    }

}
