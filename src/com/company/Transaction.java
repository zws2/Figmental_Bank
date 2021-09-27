package com.company;

import java.text.SimpleDateFormat;

public class Transaction {
    private String transactionType;
    private int senderNum;
    private int recieverNum;
    private double amount;
    private String timestamp;

    public Transaction(String transactionType, int senderNum, int recieverNum, double amount) {
        this.transactionType = transactionType;
        this.senderNum = senderNum;
        this.recieverNum = recieverNum;
        this.amount = amount;
        generateTimeStamp();
    }

    public Transaction(String transactionType, int accNum, double amount) {
        this.transactionType = transactionType;
        this.senderNum = accNum;
        this.recieverNum = accNum;
        this.amount = amount;
        generateTimeStamp();
    }

    public String getTransactionType() {
        return transactionType;
    }

    public int getSenderNum() {
        return senderNum;
    }

    public int getRecieverNum() {
        return recieverNum;
    }

    public double getAmount() {
        return amount;
    }

    public String getTimestamp() {
        return timestamp;
    }

    private void generateTimeStamp(){
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        timestamp = f.format(System.currentTimeMillis());
    }

}
