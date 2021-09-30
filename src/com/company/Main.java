package com.company;

import java.io.IOException;

//Collaborators: Zach Snyder, James Benton, Eileen Lowers
public class Main {
    public static void main(String[] args) {


//        init();

//        testAccount();
//        testTransaction();

//        testBank();

        testReadUserOperation();

    }

    private static void testReadUserOperation() {
        Bank b = new Bank();
        try{
            b.readUsersFromFile();
        }catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        System.out.println(b);
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

        User u1 = b.getUsers().get(u.getUserNum());

        if(u.info().equals(u1.info())) System.out.println("Successfully wrote and retrieved user from file");
        else System.out.println("Something went wrong...");

    }

    private static void testAccount(){
        Bank b = new Bank();
        Account a = new Account(b.getBankNum());
        a.deposit(100d);
        System.out.println(a.accountDetails());
        a.withdraw(50d);
        System.out.println(a.accountDetails());
    }

    private static void testTransaction(){

        Bank b = new Bank();

        User u = new User();

        Account a1 = new Account(b.getBankNum());
        Account a2 = new Account(b.getBankNum());

        b.addAccount(a1);
        b.addAccount(a2);

        System.out.println(a1);
        System.out.println(a2);

        Transaction t = new Transaction(b.getBankNum(),"transfer", a1.getAccountNum(),
                a2.getAccountNum(), 100d);
        System.out.println(t);

        a1.depositTransaction(100d);

        t = a1.transfer(a2.getAccountNum(), 50d);
        System.out.println(t);
    }

}
