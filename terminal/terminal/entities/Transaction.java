package terminal.entities;

import java.util.Date;

public class Transaction {
    private int transactionId;
    private Account origemAccount;
    private Account destinoAccount;
    private double value;
    private Date date;

    // Default Constructor
    public Transaction() {}

    // Parameterized Constructor
    public Transaction(int transactionId, Account origemAccount, Account destinoAccount, double value, Date date) {
        this.transactionId = transactionId;
        this.origemAccount = origemAccount;
        this.destinoAccount = destinoAccount;
        this.value = value;
        this.date = date;
    }

    // Getters & Setters
    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public Account getOrigemAccount() {
        return origemAccount;
    }

    public void setOrigemAccount(Account origemAccount) {
        this.origemAccount = origemAccount;
    }

    public Account getDestinoAccount() {
        return destinoAccount;
    }

    public void setDestinoAccount(Account destinoAccount) {
        this.destinoAccount = destinoAccount;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    // ToString
    @Override
    public String toString() {
        return "Transaction ID = " + transactionId +
               "\n Origin Account Number = " + origemAccount.getAccountNumber() +
               "\n Destination Account Number = " + destinoAccount.getAccountNumber() +
               "\n Transaction Value = " + value +
               "\n Transaction Date = " + date;
    }
}
