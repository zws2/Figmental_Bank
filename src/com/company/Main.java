package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//Collaborators: Zach Snyder, James Benton, Eileen Lowers
public class Main {
    public static void main(String[] args) {

        init();
        //testAccount();
        //testTransaction();

//        testBank();

        //NEW ADDITIONS IN BANK --> readTransaction(); - writeTransaction(); getter & setter - transactionHashMap<Integer, Transaction>
        System.out.println(listUserTransactions());
    }

    private static void init(){
        Display display = new Display();

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

        User u = new User();

        Account a1 = new Account();
        Account a2 = new Account();

        Bank.putAccount(a1);
        Bank.putAccount(a2);

        System.out.println(a1);
        System.out.println(a2);

        Transaction t = new Transaction("transfer", a1.getAccountNum(),
                a2.getAccountNum(), 100d);
        System.out.println(t);

        a1.depositTransaction(100d);

        t = a1.transfer(a2.getAccountNum(), 50d);
        System.out.println(t);
    }

    //completing all operations in this single method
    private static List<Transaction> listUserTransactions() {
        int bankNum = Bank.getNewBankNum();
        Bank bank = new Bank();
        Bank.getBanks().put(bankNum, bank);

        User user = new User("Figmental_Bank", "test123", "Figmental", "Banking");

        HashMap<String, User> map = new HashMap<>();
        map.put("Figmental", user);
        bank.setUsers(map);
        bank.writeUsers();
        user.addUserTransaction(new Transaction(bankNum, "transfer", 86534534, 345234433, 2000.00));
        user.addUserTransaction(new Transaction(bankNum, "deposit", 782345234, 86534534, 5000.00));
        user.addUserTransaction(new Transaction(bankNum, "withdraw", 86534534, 1342345324, 1000.00));
        user.addUserTransaction(new Transaction(bankNum, "deposit", 345280534, 86534534, 3000.00));

        return user.getUserTransactions();
    }
}