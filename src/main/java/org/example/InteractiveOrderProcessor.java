package org.example;

import java.util.Scanner;

public class InteractiveOrderProcessor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the Interactive Order Processor");
        System.out.println();

        System.out.println("--- Enter Order Details ---");
        System.out.print("Enter unit price: ");
        Double unitPrice = Double.parseDouble(sc.nextLine());
        System.out.print("Enter quantity: ");
        Integer quantity = Integer.parseInt(sc.nextLine());
        System.out.print("Is customer a member (true/false)?: ");
        Boolean isMember = Boolean.parseBoolean(sc.nextLine());
        System.out.print("Enter customer tier (Regular, Silver, Gold): ");
        String customerTier = sc.nextLine();
        System.out.print("Enter shipping zone (ZoneA, ZoneB, ZoneC, Unknown): ");
        String shippingZone = sc.nextLine();
        System.out.print("Enter discount code (SAVE10, FREESHIP, or \"\" for none): ");
        String discountCode = sc.nextLine();
        System.out.println();

        System.out.println("--- Order Details ---");
        System.out.printf("Unit Price: $%.2f%n", unitPrice);
        System.out.printf("Quantity: %d%n", quantity);
        System.out.printf("Is Member: %b%n", isMember);
        System.out.printf("Customer Tier: %s%n", customerTier);
        System.out.printf("Shipping Zone: %s%n", shippingZone);
        System.out.printf("Discount Code: %s%n", discountCode);
        System.out.println();

        sc.close();
    }
}