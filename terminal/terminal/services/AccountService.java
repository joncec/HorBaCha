package terminal.services;

import terminal.entities.Account;
import terminal.exeptions.*;

public class AccountService {
    public Account depositToAccount(Account account, double amount) {
        // Update the balance by adding the deposit amount
        double currentBalance = account.getAccountBalance();
        account.setAccountBalance(currentBalance + amount);

        // Return the updated account
        return account;
    }

    public Account withdrawFromAccount(Account account, double amount) {
        // Check if there are sufficient funds
        double currentBalance = account.getAccountBalance();
        if (currentBalance < amount) {
            throw new InsufficientFundsException("Insufficient funds in the account");
        }

        // Deduct the withdrawal amount from the balance
        account.setAccountBalance(currentBalance - amount);

        // Return the updated account
        return account;
    }
}
