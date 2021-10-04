package com.company;

//Collaborators: Zach Snyder, James Benton, Eileen Lowers
public class Main {
    public static void main(String[] args) {

        init();

//        testAccount();
//        testTransaction();
//        testBank();

    }

    private static void init(){
        Bank.initBank();
        Display.startMenu();
    }

    private static void testBank(){

        User u = new User();

        Bank.putUser(u);

        Bank.writeUsers();
        Bank.getUsers().clear();

        Bank.readUsers();

        User u1 = Bank.getUsers().get(u.getUserName());

        if(u.toString().equals(u1.toString())) System.out.println("Successfully wrote and retrieved user from file");
        else System.out.println("Something went wrong...");

        Account a1 = new Account();
        Account a2 = new Account();
        Account a3 = new Account();

        Bank.putAccount(a1);
        Bank.putAccount(a2);
        Bank.putAccount(a3);

        Bank.writeAccounts();

        System.out.println("Accounts after added to list");
        for(Account a : Bank.getAccounts().values()){
            System.out.println(a);
        }

        Bank.getAccounts().clear();

        Bank.readAccounts();

        System.out.println("Accounts after read from file");
        for(Account a : Bank.getAccounts().values()){
            System.out.println(a);
        }
    }

    private static void testAccount(){
        Account a = new Account();
        a.deposit(100d);
        System.out.println(a.accountDetails());
        a.withdraw(50d);
        System.out.println(a.accountDetails());
    }

    private static void testTransaction(){

        Bank.initBank();

        User u = new User("test", "password");

        Account a1 = new Account(u.getUserName());
        Account a2 = new Account(u.getUserName());

        Bank.putAccount(a1);
        Bank.putAccount(a2);

        System.out.println(a1);
        System.out.println(a2);

        Transaction t = a1.transferTransaction(a2.getAccountNum(), 75d);
        System.out.println(t);

        System.out.println(a1);
        System.out.println(a2);

        t = a1.depositTransaction(200d);
        System.out.println(t);

        System.out.println(a1);
        System.out.println(a2);

        t = a1.transferTransaction(a2.getAccountNum(), 75d);
        System.out.println(t);

        System.out.println(a1);
        System.out.println(a2);
    }

}