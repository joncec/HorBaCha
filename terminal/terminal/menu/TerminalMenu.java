package terminal.menu;

import java.util.Scanner;

import terminal.entities.*;
import terminal.services.*;


public class TerminalMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserService userService = new UserService(); // Your user service instance

        while (true) {
            printMenu();
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    // Create a new user (you can add input prompts)
                    System.out.print("Enter user's name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter user's phone number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Enter user's CPF: ");
                    String cpf = scanner.nextLine();

                    User newUser = userService.createUser(name, phoneNumber, cpf);
                    System.out.println("User created with ID: " + newUser.getUserId());
                    break;

                case 2:
                    // View user's accounts
                    System.out.print("Enter user ID: ");
                    int userId = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    User user = userService.getUserById(userId);
                    if (user != null) {
                        System.out.println("User's Accounts:");
                        for (Account account : user.getAccounts()) {
                            System.out.println(account);
                        }
                    } else {
                        System.out.println("User not found.");
                    }
                    break;

                case 3:
                    // Exit the application
                    System.out.println("Exiting the Terminal Banking System.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
            scanner.close();
        }
    }

    private static void printMenu() {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║   Horizon Terminal Banking System      ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║ 1. Create User                         ║");
        System.out.println("║ 2. View User's Accounts                ║");
        System.out.println("║ 3. Exit                                ║");
        System.out.println("╚════════════════════════════════════════╝");
    }
}
