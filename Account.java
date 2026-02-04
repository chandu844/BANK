public class Account {
    private int accountNumber;
    private String holderName;
    protected double balance;

    public Account(int accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("₹" + amount + " deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw money - overridden in child classes
    public void withdraw(double amount) {
        // Default: do nothing
    }

    // Display account details
    public void display() {
        System.out.println("\n--- ACCOUNT DETAILS ---");
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Holder Name    : " + holderName);
        System.out.printf("Balance        : ₹%.2f\n", balance);
    }

    public int getAccountNumber() {
        return accountNumber;
    }
}
