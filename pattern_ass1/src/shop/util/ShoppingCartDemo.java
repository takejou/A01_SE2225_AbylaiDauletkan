package shop.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ShoppingCartDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShoppingCart cart = new ShoppingCart();

        Map<String, Double> availableProducts = new HashMap<>();
        availableProducts.put("Bread", 4.99);
        availableProducts.put("Milk", 7.49);
        availableProducts.put("Banana", 6.40);
        availableProducts.put("Meat", 17.99);
        availableProducts.put("Toy Car", 9.00);

        while (true) {
            System.out.println("A number to choose from:");
            System.out.println("1. Add to shopping cart");
            System.out.println("2. Pay");
            System.out.println("3. Quit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("All Products:");
                    int productNumber = 1;
                    for (Map.Entry<String, Double> entry : availableProducts.entrySet()) {
                        System.out.println(productNumber + ". Name: " + entry.getKey() + " Price: " + entry.getValue());
                        productNumber++;
                    }

                    System.out.print("Choose product: ");
                    int selectedProductNumber = scanner.nextInt();
                    scanner.nextLine();

                    if (selectedProductNumber >= 1 && selectedProductNumber <= availableProducts.size()) {
                        String[] productNames = availableProducts.keySet().toArray(new String[0]);
                        String selectedProductName = productNames[selectedProductNumber - 1];

                        System.out.print("Enter the sum: ");
                        int productQuantity = scanner.nextInt();
                        scanner.nextLine();

                        cart.addProduct(selectedProductName, productQuantity);
                    } else {
                        System.out.println("Invalid product number.");
                    }
                    break;
                case 2:
                    System.out.println("Checkout options:");
                    System.out.println("1. Credit Card Payment");
                    System.out.println("2. Kaspi Remittance Payment");
                    int paymentChoice = scanner.nextInt();
                    PaymentStrategy paymentStrategy = null;
                    if (paymentChoice == 1) {
                        System.out.print("Enter your credit card number: ");
                        scanner.nextLine();
                        String cardNumber = scanner.nextLine();
                        if(cardNumber.length()<12 || cardNumber.length()>13){
                            System.out.println("Invalid card number");
                            break;
                        }
                        paymentStrategy = new CreditCardPayment(cardNumber) {
                            @Override
                            public double getBalance() {
                                return 0;
                            }
                        };
                    } else if (paymentChoice == 2) {
                        System.out.print("Enter your Kaspi number: ");
                        scanner.nextLine();
                        String number = scanner.nextLine();
                        if(number.length()<12 || number.length()>12){
                            System.out.println("Invalid phone number");
                        }
                        paymentStrategy = new KaspiPayment(number) {
                            @Override
                            public double getBalance() {
                                return 0;
                            }
                        };
                    } else {
                        System.out.println("Invalid option.");
                    }
                    if (paymentStrategy != null) {
                        cart.setPaymentStrategy(paymentStrategy);
                        cart.checkout();
                    }
                    break;
                case 3:
                    System.out.println("Goodbye.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
