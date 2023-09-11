package terminal.entities;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int userId;
    private String name;
    private String phoneNumber;
    private String cpf;
    private List<Account> accounts; // Maintain a list of associated accounts

    // Default Constructor
    public User() {
        accounts = new ArrayList<>();
    }

    // Parameterized Constructor
    public User(int userId, String name, String phoneNumber, String cpf) {
        this.userId = userId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.cpf = cpf;
        accounts = new ArrayList<>();
    }

    // Add an account to the user's account list
    public boolean addAccount(Account account) {
        if (accounts.size() < 2) {
            accounts.add(account);
            return true; // Account added successfully
        }
        return false; // User already has the maximum allowed number of accounts
    }

    // Getters & Setters for other fields

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    // ToString
    @Override
    public String toString() {
        return  "\nID= " + userId +
                "\nName= " + name + 
                "\nPhone Number= " + phoneNumber + 
                "\nCPF= " + cpf;
    }
}
