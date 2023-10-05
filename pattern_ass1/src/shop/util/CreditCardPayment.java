package shop.util;
public class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private double balance;
    private double spendingLimit;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
        this.balance = balance;
        this.spendingLimit = spendingLimit;
    }

    @Override
    public void processPayment(double amount) {
        if (amount > spendingLimit) {
            System.out.println();
        } else {
            balance -= amount;
            System.out.println("Payment successful. Payment has passed:: " + balance);
        }
    }

    public double getBalance() {
        return balance;
    }
}
