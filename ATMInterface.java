import java.util.ArrayList;
import java.util.Scanner;

public class ATMInterface{
    private static double balance = 100000.0; // Initial account balance
    private static ArrayList<String> transactionHistory = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character after reading the integer choice

            switch (choice) {
                case 1:
                    withdraw(scanner);
                    break;
                case 2:
                    deposit(scanner);
                    break;
                case 3:
                    transfer(scanner);
                    break;
                case 4:
                    showTransactionHistory();
                    break;
                case 5:
                    exit();
                    break;
                default:
                    System.out.println("Invalid choice. \nPlease try again.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("ATM MENU");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Transfer");
        System.out.println("4. Transaction History");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void withdraw(Scanner scanner) {
        System.out.println(); // Consume the newline character
        System.out.print("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character after reading the double amount

        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. \nCurrent balance: " + balance);
            addTransactionToHistory("Withdrawal: " + amount);
        } else {
            System.out.println("Insufficient funds or invalid amount. \nPlease try again.");
        }
        System.out.println(); // Consume the newline character
    }

    private static void deposit(Scanner scanner) {
        System.out.println(); // Consume the newline character
        System.out.print("Enter the amount to deposit: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character after reading the double amount

        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. \nCurrent balance: " + balance);
            addTransactionToHistory("Deposit: " + amount);
        } else {
            System.out.println("Invalid amount. \nPlease try again.");
        }
        System.out.println(); // Consume the newline character
    }

    private static void transfer(Scanner scanner) {
        System.out.println(); // Consume the newline character
        System.out.print("Enter the amount to transfer: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character after reading the double amount

        if (amount > 0 && amount <= balance) {
            System.out.print("Enter the recipient's account number: ");
            String recipientAccount = scanner.nextLine();

            balance -= amount;
            System.out.println("Transfer successful. \nCurrent balance: " + balance);
            addTransactionToHistory("Transfers " + amount + " to account no. " + recipientAccount);
        } else {
            System.out.println("Insufficient funds or invalid amount. \nPlease try again.");
        }
        System.out.println(); // Consume the newline character
    }

    private static void showTransactionHistory() {
        System.out.println(); // Consume the newline character
        System.out.println("Transaction History:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
        System.out.println(); // Consume the newline character
    }

    private static void addTransactionToHistory(String transaction) {
        System.out.println(); // Consume the newline character
        transactionHistory.add(transaction);
    }

    private static void exit() {
        System.out.println("Thank you for using our ATM. \nGoodbye!\nVisit Again!!");
        System.exit(0);
    }
}