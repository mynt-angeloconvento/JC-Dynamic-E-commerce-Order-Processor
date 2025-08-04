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

        System.out.println("--- Calculation Steps ---");
        Double subtotal = unitPrice * quantity;
        System.out.printf("Initial Subtotal: $%.2f%n", subtotal);

        int tierDiscount = 0;
        if (customerTier.equals("Gold")) {
            tierDiscount = 15;
        } else if (customerTier.equals("Silver")) {
            tierDiscount = 10;
        }
        Double tierDiscountAmount = subtotal * tierDiscount / 100;
        subtotal -= tierDiscountAmount;
        System.out.printf("After Tier Discount (%s - %d%%): $%.2f%n", customerTier, tierDiscount, subtotal);

        int quantityDiscount = 0;
        if (quantity >= 5) {
            quantityDiscount = 5;
        }
        Double quantityDiscountAmount = subtotal * quantityDiscount / 100;
        subtotal -= quantityDiscountAmount;
        System.out.printf("After Quantity Discount (5%% for >=5 items): $%.2f%n", subtotal);

        if (discountCode.equals("SAVE10") && subtotal > 75.00) {
            subtotal -= 10;
            System.out.printf("After Promotional Code (SAVE10 for >$75): $%.2f%n", subtotal);
        } else if (discountCode.equalsIgnoreCase("FREESHIP")) {
            System.out.printf("After Promotional Code (FREESHIP): $%.2f%n", subtotal);
        }

        int surcharge = (subtotal < 25.00) ? 3 : 0;
        if (surcharge > 0) {
            subtotal += surcharge;
            System.out.printf("After Small Order Surcharge (if applicable): $%.2f (Surcharge: $%d)%n", subtotal,
                    surcharge);
        } else {
            System.out.printf("After Small Order Surcharge (if applicable): $%.2f (No surcharge)%n", subtotal);
        }
        System.out.println();

        double shippingCost = 0.0;
        if (!discountCode.equalsIgnoreCase("FREESHIP")) {
            switch (shippingZone) {
                case "ZoneA":
                    shippingCost = 5.00;
                    break;
                case "ZoneB":
                    shippingCost = 12.50;
                    break;
                case "ZoneC":
                    shippingCost = 20.00;
                    break;
                default:
                    shippingCost = 25.00;
                    break;
            }
        }
        System.out.printf("Shipping Cost: $%.2f (%s)%n", shippingCost, shippingZone);
        double finalOrderTotal = subtotal + shippingCost;
        System.out.println();

        System.out.printf("Final Order Total: $%.2f%n", finalOrderTotal);
        System.out.println();

        System.out.println("--- String Equality Demo ---");
        System.out.print("Enter first string for comparison: ");
        String firstString = sc.nextLine();
        System.out.print("Enter second string for comparison: ");
        String secondString = sc.nextLine();
        System.out.println();

        System.out.printf("String 1: \"%s\"%n", firstString);
        System.out.printf("String 2: \"%s\"%n", secondString);
        System.out.println();

        boolean references = firstString == secondString;
        boolean content = firstString.equals(secondString);
        boolean contentIgnoreCase = firstString.equalsIgnoreCase(secondString);
        System.out.printf(
                "String 1 == String 2: %b (Compares references, which are different for user input strings)%n",
                references);
        System.out.printf("String 1 .equals() String 2: %b (Content is %s)%n", content,
                content ? "identical" : "different");
        System.out.printf("String 1 .equalsIgnoreCase() String 2: %b (Content is %s, ignoring case)%n",
                contentIgnoreCase, contentIgnoreCase ? "identical" : "different");

        sc.close();
    }
}