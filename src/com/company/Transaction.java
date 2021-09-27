package com.company;

import java.text.SimpleDateFormat;

public class Transaction {
    private final String transactionType;
    private final int senderNum;
    private final int receiverNum;
    private final double amount;
    private final String timestamp;

    public Transaction(String transactionType, int senderNum, int recieverNum, double amount) {
        this.transactionType = transactionType;
        this.senderNum = senderNum;
        this.receiverNum = recieverNum;
        this.amount = amount;
        timestamp = generateTimeStamp();

        //recordTransaction(this);
    }

    public Transaction(String transactionType, int accNum, double amount) {
        this.transactionType = transactionType;
        this.senderNum = accNum;
        this.receiverNum = accNum;
        this.amount = amount;
        timestamp = generateTimeStamp();

        //recordTransaction(this);
    }

    private String generateTimeStamp(){
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return f.format(System.currentTimeMillis());
    }

    public String toString(){
        return transactionType + ", " + senderNum + ", " + receiverNum + ", " + amount + ", " + timestamp;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public int getSenderNum() {
        return senderNum;
    }

    public int getReceiverNum() {
        return receiverNum;
    }

    public double getAmount() {
        return amount;
    }

    public String getTimestamp() {
        return timestamp;
    }


}
