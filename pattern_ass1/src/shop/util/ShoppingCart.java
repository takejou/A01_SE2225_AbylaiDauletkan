package shop.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ShoppingCart {
    private final Map<String, Integer> items = new HashMap<>();
    private PaymentStrategy paymentStrategy;
    private double totalAmount = 0;

    private static final Map<String, Double> availableProducts = new HashMap<>();

    static {
        availableProducts.put("Bread", 4.99);
        availableProducts.put("Milk", 7.49);
        availableProducts.put("Banana", 6.40);
        availableProducts.put("Meat", 17.99);
        availableProducts.put("Toy Car", 9.00);
    }

    public void addProduct(String productName, int quantity) {
        if (quantity <= 0) {
            System.out.println("Invalid quantity. Please specify a positive quantity.");
            return;
        }

        if (!availableProducts.containsKey(productName)) {
            System.out.println("Invalid product name. Please select a product from the available list.");
            return;
        }

        double productPrice = availableProducts.get(productName);
        double itemTotal = productPrice * quantity;

        if (items.containsKey(productName)) {
            int existingQuantity = items.get(productName);
            items.put(productName, existingQuantity + quantity);
        } else {
            items.put(productName, quantity);
        }

        totalAmount += itemTotal;
        System.out.println("Added " + quantity + " " + productName + "(s) to the cart.");
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout() {
        if (paymentStrategy == null) {
            System.out.println("Please set a payment strategy before checking out.");
            return;
        }

        if (totalAmount <= 0) {
            System.out.println("No items in the cart. Add some items before checking out.");
            return;
        }
        paymentStrategy.processPayment(totalAmount);
        System.out.println("Payment completed. Total amount: " + totalAmount+"$");
        totalAmount = 0;
        items.clear();
    }

    public void viewCart() {
        System.out.println("Shopping Cart Contents:");
        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            String productName = entry.getKey();
            int quantity = entry.getValue();
            System.out.println(productName + " - Sum: " + quantity);
        }
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}
