package util;

import java.util.Scanner;

public class ValidationUtil {
    private static Scanner scanner = new Scanner(System.in);

    public static int getInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please enter a valid integer.");
            }
        }
    }

    public static double getDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please enter a valid decimal.");
            }
        }
    }

    public static String getString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }
    public static int getPositiveInt(String prompt) {
        int value;
        do {
            value = getInt(prompt);
            if (value <= 0) System.out.println("Please enter a positive number.");
        } while (value <= 0);
        return value;
    }
    
}
