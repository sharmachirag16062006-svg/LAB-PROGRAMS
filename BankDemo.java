package kelly;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BankDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account account = null; // No account at start

        System.out.println("---- Welcome to the Bank System ----");

        while (true) {
            System.out.println("\n---- Bank Menu ----");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Show Balance");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");

            String input = scanner.nextLine(); // Read full line
            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number between 1 and 5.");
                continue;
            }

            switch (choice) {
                case 1:
                    if (account != null) {
                        System.out.println("Account already exists for " + account.getName());
                        break;
                    }
                    System.out.print("Enter account number: ");
                    String accNumber = scanner.nextLine();

                    System.out.print("Enter account holder name: ");
                    String name = scanner.nextLine();

                    double initialBalance = 0;
                    while (true) {
                        System.out.print("Enter initial balance: ");
                        String balInput = scanner.nextLine();
                        try {
                            initialBalance = Double.parseDouble(balInput);
                            if (initialBalance < 0) {
                                System.out.println("Balance cannot be negative.");
                                continue;
                            }
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid amount! Please enter a valid number.");
                        }
                    }

                    account = new Account(accNumber, name, initialBalance);
                    System.out.println("Account created successfully for " + account.getName());
                    break;

                case 2:
                    if (account == null) {
                        System.out.println("No account found. Please create an account first.");
                        break;
                    }
                    System.out.print("Enter deposit amount: ");
                    try {
                        double depositAmount = Double.parseDouble(scanner.nextLine());
                        if (depositAmount <= 0) {
                            System.out.println("Deposit amount must be positive.");
                            break;
                        }
                        account.deposit(depositAmount);
                        System.out.println("Deposited $" + depositAmount);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid amount! Please enter a valid number.");
                    }
                    break;

                case 3:
                    if (account == null) {
                        System.out.println("No account found. Please create an account first.");
                        break;
                    }
                    System.out.print("Enter withdrawal amount: ");
                    try {
                        double withdrawAmount = Double.parseDouble(scanner.nextLine());
                        if (withdrawAmount <= 0) {
                            System.out.println("Withdrawal amount must be positive.");
                            break;
                        }
                        account.withdraw(withdrawAmount);
                        System.out.println("Withdrew $" + withdrawAmount);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid amount! Please enter a valid number.");
                    } catch (InsufficientBalanceException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    if (account == null) {
                        System.out.println("No account found. Please create an account first.");
                        break;
                    }
                    account.showBalance();
                    break;

                case 5:
                    System.out.println("Exiting the system.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please select between 1 and 5.");
            }
        }
    }
}
