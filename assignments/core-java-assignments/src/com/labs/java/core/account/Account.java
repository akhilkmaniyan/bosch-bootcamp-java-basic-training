package com.labs.java.core.account;

import java.util.Scanner;

public class Account {
    private static final int MAX_ACCOUNTS = 10;  // Limit to 10 accounts
    private static AccountManagerService[] accounts = new AccountManagerService[MAX_ACCOUNTS];  // Array to store accounts
    private static int accountCount = 0;  // To track  number of accounts created

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;

        while (true) {
            System.out.println("\nAccount Manager - Menu:");
            System.out.println("1. Create Account");
            System.out.println("2. Update Account");
            System.out.println("3. View Account");
            System.out.println("4. Deposit Amount");
            System.out.println("5. Withdraw Amount");
            System.out.println("6. Close Account");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    createAccount(scanner);
                    break;
                case 2:
                    updateAccount(scanner);
                    break;
                case 3:
                    viewAccount(scanner);
                    break;
                case 4:
                    depositAmount(scanner);
                    break;
                case 5:
                    withdrawAmount(scanner);
                    break;
                case 6:
                    closeAccount(scanner);
                    break;
                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;  // Exit the program
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Create a new account
    private static void createAccount(Scanner scanner) {
        if (accountCount >= MAX_ACCOUNTS) {
            System.out.println("Maximum account limit reached. Cannot create new account.");
            return;
        }

        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter account holder name: ");
        String name = scanner.nextLine();
        System.out.print("Enter initial deposit amount: ");
        double initialDeposit = scanner.nextDouble();
        scanner.nextLine();

        accounts[accountCount] = new AccountManagerService(accountNumber, name, initialDeposit);
        accountCount++;
        System.out.println("Account created successfully!");
    }

    // Update account holder's name
    private static void updateAccount(Scanner scanner) {
        if (accountCount == 0) {
            System.out.println("No accounts available.");
            return;
        }

        System.out.print("Enter account number to update: ");
        String accountNumber = scanner.nextLine();
        AccountManagerService account = findAccount(accountNumber);

        if (account != null) {
            System.out.print("Enter new account holder name: ");
            String newName = scanner.nextLine();
            account.updateName(newName);
        } else {
            System.out.println("Account not found.");
        }
    }

    // View account details
    private static void viewAccount(Scanner scanner) {
        if (accountCount == 0) {
            System.out.println("No accounts available.");
            return;
        }

        System.out.print("Enter account number to view: ");
        String accountNumber = scanner.nextLine();
        AccountManagerService account = findAccount(accountNumber);

        if (account != null) {
            account.viewAccountDetails();
        } else {
            System.out.println("Account not found.");
        }
    }

    // Deposit amount into an account
    private static void depositAmount(Scanner scanner) {
        if (accountCount == 0) {
            System.out.println("No accounts available.");
            return;
        }

        System.out.print("Enter account number to deposit: ");
        String accountNumber = scanner.nextLine();
        AccountManagerService account = findAccount(accountNumber);

        if (account != null) {
            System.out.print("Enter deposit amount: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();  // consume newline
            account.deposit(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    // Withdraw amount from an account
    private static void withdrawAmount(Scanner scanner) {
        if (accountCount == 0) {
            System.out.println("No accounts available.");
            return;
        }

        System.out.print("Enter account number to withdraw from: ");
        String accountNumber = scanner.nextLine();
        AccountManagerService account = findAccount(accountNumber);

        if (account != null) {
            System.out.print("Enter withdrawal amount: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();  // consume newline
            account.withdraw(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    // Close an account
    private static void closeAccount(Scanner scanner) {
        if (accountCount == 0) {
            System.out.println("No accounts available.");
            return;
        }

        System.out.print("Enter account number to close: ");
        String accountNumber = scanner.nextLine();
        AccountManagerService account = findAccount(accountNumber);

        if (account != null) {
            // Remove the account from the array (shift remaining accounts)
            for (int i = 0; i < accountCount - 1; i++) {
                if (accounts[i].getAccountNumber().equals(accountNumber)) {
                    for (int j = i; j < accountCount - 1; j++) {
                        accounts[j] = accounts[j + 1];
                    }
                    accounts[accountCount - 1] = null;  // Clear last account slot
                    accountCount--;
                    System.out.println("Account closed successfully.");
                    return;
                }
            }
        } else {
            System.out.println("Account not found.");
        }
    }

    //  method to find account by number
    private static AccountManagerService findAccount(String accountNumber) {
        AccountManagerService foundAccount = null;
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i].getAccountNumber().equals(accountNumber)) {
                foundAccount =  accounts[i];
                break;
            }
        }
        return foundAccount;  // Return null if account not found
    }
}
