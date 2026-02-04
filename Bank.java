import java.util.*;

public class Bank {
    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<Account> accounts = new ArrayList<>();

    public static void main(String[] args) {
        int choice;
        do {
            printMenu();
            choice = sc.nextInt();
            sc.nextLine(); 
            switch (choice) {
                case 1 -> createSavings();
                case 2 -> createSal();
                case 3 -> deposit();
                case 4 -> withdraw();
                case 5 -> displayAccount();
                case 6 -> calculateInterest();
                case 7 -> System.out.println("Thank you for using the Bank Application!");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 7);
    }

    private static void printMenu() {
        System.out.println("\n===== BANK APPLICATION MENU =====");
        System.out.println("1. Create Savings Account");
        System.out.println("2. Create Salary Account");
        System.out.println("3. Deposit Money");
        System.out.println("4. Withdraw Money");
        System.out.println("5. Display Account Details");
        System.out.println("6. Calculate Interest (Savings Only)");
        System.out.println("7. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void createSavings() {
        System.out.print("Account Number: ");
        int accNo = sc.nextInt();
        sc.nextLine();
        System.out.print("Holder Name: ");
        String name = sc.nextLine();
        System.out.print("Initial Balance: ");
        double bal = sc.nextDouble();

        accounts.add(new SavingsAccount(accNo, name, bal));
        System.out.println("Savings account created successfully.");
    }

    private static void createSal() {
        System.out.print("Account Number: ");
        int accNo = sc.nextInt();
        sc.nextLine();
        System.out.print("Holder Name: ");
        String name = sc.nextLine();
        System.out.print("Initial Balance: ");
        double bal = sc.nextDouble();

        accounts.add(new SalaryAccount(accNo, name, bal));
        System.out.println("Current account created successfully.");
    }

    private static Account findAccount(int accNo) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber() == accNo)
                return acc;
        }
        return null;
    }

    private static void deposit() {
        System.out.print("Account Number: ");
        int accNo = sc.nextInt();
        Account acc = findAccount(accNo);

        if (acc != null) {
            System.out.print("Amount to deposit: ");
            double amt = sc.nextDouble();
            acc.deposit(amt);
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void withdraw() {
        System.out.print("Account Number: ");
        int accNo = sc.nextInt();
        Account acc = findAccount(accNo);

        if (acc != null) {
            System.out.print("Amount to withdraw: ");
            double amt = sc.nextDouble();
            acc.withdraw(amt); 
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void displayAccount() {
        System.out.print("Account Number: ");
        int accNo = sc.nextInt();
        Account acc = findAccount(accNo);

        if (acc != null) {
            acc.display();
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void calculateInterest() {
        System.out.print("Account Number: ");
        int accNo = sc.nextInt();
        Account acc = findAccount(accNo);

        if (acc instanceof SavingsAccount sa) {
            sa.calculateInterest();
        } else {
            System.out.println("Interest calculation is only applicable for Savings Account.");
        }
    }
}
