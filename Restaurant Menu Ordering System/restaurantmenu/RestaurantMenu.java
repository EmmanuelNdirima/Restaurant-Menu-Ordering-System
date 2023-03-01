package restaurantmenu;

import java.util.Scanner;
import java.util.ArrayList;

public class RestaurantMenu {

    // Declaration of menu items
    private static ArrayList<String> menuItems = new ArrayList<String>();
    private static ArrayList<Double> menuPrices = new ArrayList<Double>();

    public static void main(String[] args) {
        // Add meals to menu
        menuItems.add("Rice and Beans");
        menuPrices.add(60.0);

        menuItems.add("Masala");
        menuPrices.add(100.0);

        menuItems.add("Chapo and Cabbage");
        menuPrices.add(50.0);

        menuItems.add("Chips");
        menuPrices.add(120.0);

        menuItems.add("Soda");
        menuPrices.add(80.0);

        menuItems.add("Water");
        menuPrices.add(50.0);

        menuItems.add("Porridge");
        menuPrices.add(40.0);

        // Printing the menu
        System.out.println("Our Restaurant Menu");
        System.out.println("MENU:");

        for (int i = 0; i < menuItems.size(); i++) {
            // Fixed the print statement to show the menu item and its price
            System.out.println((i + 1) + ". " + menuItems.get(i) + " - Ksh " + menuPrices.get(i));
        }

        // Allow user to add menu items
        Scanner scanner = new Scanner(System.in);
        int choice = 1;
        while (choice != 0) {
            System.out.println("\nEnter 1 to add a new menu item or 0 to continue:");
            choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println("\nEnter the name of the new menu item:");
                String newItem = scanner.next();
                System.out.println("Enter the price of " + newItem + " in Ksh:");
                double newPrice = scanner.nextDouble();
                menuItems.add(newItem);
                menuPrices.add(newPrice);
            }
        }

        // Allow customer to order
        ArrayList<String> customerOrder = new ArrayList<String>();
        ArrayList<Double> customerPrices = new ArrayList<Double>();

        choice = 1;
        while (choice != 0) {

            System.out.println("\nEnter the number of the menu item you want to order or 0 to finish:");
            choice = scanner.nextInt();

            if (choice != 0 && choice <= menuItems.size()) {
                customerOrder.add(menuItems.get(choice - 1));
                customerPrices.add(menuPrices.get(choice - 1));

            }
        }

        // Calculate the total bill
        double totalBill = 0.0;
        System.out.println("\nORDER SUMMARY:");
        for (int i = 0; i < customerOrder.size(); i++) {
            System.out.println(customerOrder.get(i) + " - Ksh " + customerPrices.get(i));

            totalBill += customerPrices.get(i);
        }
        System.out.println("Total bill: Ksh " + totalBill);

        // Allow user to make payment
        System.out.println("\nEnter the mobile money payment amount in Ksh:");
        double paymentAmount = scanner.nextDouble();
        System.out.println("Enter the date of payment in YYYY-MM-DD format:");
        String paymentDate = scanner.next();

        // Store payment information
        storePayment(paymentAmount, paymentDate);
    }

    // Store payment information
    public static void storePayment(double amount, String date) {
        // Implementation code here
        System.out.println("Payment of Ksh " + amount + " on " + date + " has been processed.");
    }
}
