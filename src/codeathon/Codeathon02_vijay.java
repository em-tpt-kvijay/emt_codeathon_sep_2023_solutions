package codeathon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Codeathon02_vijay{

    public static List<String> mostActive(String[] customers) {
        List<String> result = new ArrayList<>();
        int totalTrades = customers.length;
        int threshold = (int) (0.05 * totalTrades);

        // Sort the array of customers
        Arrays.sort(customers);

        int currentCount = 1;
        for (int i = 1; i < totalTrades; i++) {
            if (customers[i].equals(customers[i - 1])) {
                currentCount++;
            } else {
                if (currentCount >= threshold) {
                    result.add(customers[i - 1]);
                }
                currentCount = 1;
            }
        }

        // Check the last customer
        if (currentCount >= threshold) {
            result.add(customers[totalTrades - 1]);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of trades:");
        int numTrades = scanner.nextInt();
        scanner.nextLine();
        if (numTrades <= 0) {
            System.out.println("Please enter trades must be greater than zero.");
            return; // Exit the program if numTrades is not valid.
        }

        String[] customers = new String[numTrades];
        System.out.println("Enter the names of customers (one on each line):");
        for (int i = 0; i < numTrades; i++) {
            customers[i] = scanner.nextLine();
        }
        System.out.println("OUTPUT:");
        List<String> activeCustomers = mostActive(customers);
        if (activeCustomers.isEmpty()) {
            System.out.println("No active customers found.");
        }
        else {
            for (String customer : activeCustomers) {
                System.out.println(customer);
            }
        }
    }
}
