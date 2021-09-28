package com.company;

//Collaborators: Zach Snyder, James Benton, Eileen Lowers
public class Main {
    public static void main(String[] args) {


        init();

        //testAccount();
        //testTransaction();


    }

    private static void init(){
        int option = 0;
        Display display = new Display();
//        UserAccess userAccess = new UserAccess();

        Display.printHeader();
        Display.printMainMenu();
        display.getInput();
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
