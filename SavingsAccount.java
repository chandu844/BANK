public class SavingsAccount extends Account {
    private static final double MIN_BALANCE = 1000;

    public SavingsAccount(int accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount.");
        } else if (balance - amount >= MIN_BALANCE) {
            balance -= amount;
            System.out.println("Withdrawal successful: ₹" + amount);
        } else {
            System.out.println("Cannot withdraw. Minimum balance of ₹1000 required.");
        }
    }

        public void calculateInterest() {
        double interest = balance * 0.04; // 4% interest
        System.out.printf("Interest calculated: ₹%.2f\n", interest);
    }
}
