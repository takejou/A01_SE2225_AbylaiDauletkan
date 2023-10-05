package shop.util;
abstract class KaspiPayment implements PaymentStrategy {
    private final String number;

    public KaspiPayment(String number) {
        this.number = number;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Paid " + amount*500 + "KZT using Kaspi with number: " + number);
    }
}