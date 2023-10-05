package shop.util;
interface PaymentStrategy {
    void processPayment(double amount);

    double getBalance();
}
