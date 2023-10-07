import java.util.Scanner;

class BankAccount{
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit of $" + amount + " successful.");
        } else {
            System.out.println("Invalid deposit amount. Please enter a positive amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal of $" + amount + " successful.");
        } else if (amount <= 0) {
            System.out.println("Invalid withdrawal amount. Please enter a positive amount.");
        } else {
            System.out.println("Insufficient balance. Withdrawal failed.");
        }
    }
}

class ATM {
    private BankAccount bankAccount;

    public ATM(BankAccount account) {
        bankAccount = account;
    }

    public void displayMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void processOption(int option) {
        Scanner scanner = new Scanner(System.in);

        switch (option) {
            case 1:
                System.out.println("Your balance is: $" + bankAccount.getBalance());
                break;
            case 2:
                System.out.print("Enter deposit amount: $");
                double depositAmount = scanner.nextDouble();
                bankAccount.deposit(depositAmount);
                break;
            case 3:
                System.out.print("Enter withdrawal amount: $");
                double withdrawalAmount = scanner.nextDouble();
                bankAccount.withdraw(withdrawalAmount);
                break;
            case 4:
                System.out.println("Thank you for using the ATM.");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option. Please select a valid option.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter initial account balance: $");
        double initialBalance = scanner.nextDouble();
        BankAccount userAccount = new BankAccount(initialBalance);

        ATM atm = new ATM(userAccount);

        while (true) {
            atm.displayMenu();
            System.out.print("Enter your choice (1-4): ");
            int choice = scanner.nextInt();

            atm.processOption(choice);
        }
    }
}