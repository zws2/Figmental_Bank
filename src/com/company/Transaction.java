package com.company;

import java.io.Serializable;
import java.text.SimpleDateFormat;

public class Transaction implements Serializable {
    private final int bankNum;
    private final String transactionType;
    private final int senderNum;
    private final int receiverNum;
    private final double amount;
    private final String timestamp;

    public Transaction(int bankNum, String transactionType, int senderNum, int receiverNum, double amount) {
        this.bankNum = bankNum;
        this.transactionType = transactionType;
        this.senderNum = senderNum;
        this.receiverNum = receiverNum;
        this.amount = amount;
        timestamp = generateTimeStamp();

        Bank.get(bankNum).processTransaction(this);
    }

    public Transaction(int bankNum, String transactionType, int accNum, double amount) {
        this.bankNum = bankNum;
        this.transactionType = transactionType;
        this.senderNum = accNum;
        this.receiverNum = accNum;
        this.amount = amount;
        timestamp = generateTimeStamp();

        Bank.get(bankNum).processTransaction(this);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "bankNum=" + bankNum +
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

    public int getBank() {
        return bankNum;
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
