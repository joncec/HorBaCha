package terminal.entities;

import java.util.UUID;

public class Account {
    private int accountId;
    private String accountNumber;
    private double accountBalance;
    private String accountType;
    private User owner;

    // Default Constructor
    public Account() {}

    // Parameterized Constructor
    public Account(String accountNumber, double accountBalance, String accountType, User owner) {
        this.accountId = UUID.randomUUID().hashCode();
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
        this.accountType = accountType;
        this.setOwner(owner);
        owner.addAccount(this); // Add this account to the owner's accounts
    }

    // Getters & Setters for other fields

    public int getAccountId() {
        return accountId; 
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    // ToString
    @Override
    public String toString() {
        return "Account ID = " + accountId +
               "\nAccount Number = " + accountNumber +
               "\nAccount Balance=" + accountBalance +
               "\nAccount Type=" + accountType;
    }
}
