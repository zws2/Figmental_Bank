package com.company;

//Collaborators: Zach Snyder, James Benton, Eileen Lowers
public class Main {
    public static void main(String[] args) {

        //init();

        //testAccount();
        //testTransaction();

        testBank();

        //NEW ADDITIONS IN BANK --> readTransaction(); - writeTransaction(); getter & setter - transactionHashMap<Integer, Transaction>
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

        b.putUser(u);

        b.writeUsers();
        b.getUsers().clear();

        b.readUsers();

        User u1 = b.getUsers().get(u.getUserName());

        if(u.toString().equals(u1.toString())) System.out.println("Successfully wrote and retrieved user from file");
        else System.out.println("Something went wrong...");

        Account a1 = new Account(b.getBankNum());
        Account a2 = new Account(b.getBankNum());
        Account a3 = new Account(b.getBankNum());

        b.putAccount(a1);
        b.putAccount(a2);
        b.putAccount(a3);

        b.writeAccounts();

        System.out.println("Accounts after added to list");
        for(Account a : b.getAccounts().values()){
            System.out.println(a);
        }

        b.getAccounts().clear();

        b.readAccounts();

        System.out.println("Accounts after read from file");
        for(Account a : b.getAccounts().values()){
            System.out.println(a);
        }

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

        b.putAccount(a1);
        b.putAccount(a2);

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