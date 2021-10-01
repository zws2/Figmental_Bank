package com.company;

import java.io.Serializable;
import java.text.SimpleDateFormat;

public class Transaction implements Serializable {
    private final String transactionType;
    private final int senderNum;
    private final int receiverNum;
    private final double amount;
    private final String timestamp;

    public Transaction(String transactionType, int senderNum, int receiverNum, double amount) {
        this.transactionType = transactionType;
        this.senderNum = senderNum;
        this.receiverNum = receiverNum;
        this.amount = amount;
        timestamp = generateTimeStamp();

        Bank.processTransaction(this);
    }

    public Transaction(String transactionType, int accNum, double amount) {
        this.transactionType = transactionType;
        this.senderNum = accNum;
        this.receiverNum = accNum;
        this.amount = amount;
        timestamp = generateTimeStamp();

        Bank.processTransaction(this);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                ", transactionType='" + transactionType + '\'' +
                ", senderNum=" + senderNum +
                ", receiverNum=" + receiverNum +
                ", amount=" + amount +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }

    private String generateTimeStamp(){
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return f.format(System.currentTimeMillis());
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
