package com.company;

import java.util.ArrayList;

public class Bank {
    ArrayList<Account> accountList;

    public Bank(ArrayList<Account> accountList) {
        this.accountList = accountList;
    }

    public Bank() {
        accountList = new ArrayList<Account>();
    }

    public ArrayList<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(ArrayList<Account> accountList) {
        this.accountList = accountList;
    }
}
