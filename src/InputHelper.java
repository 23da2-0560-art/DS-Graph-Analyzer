import java.util.Scanner;

/**
 * Helper class for safe console input.
 * Keeps asking until the user enters valid data, so the program never crashes
 * on wrong input such as letters instead of numbers.
 */
public class InputHelper {
    private static final Scanner scanner = new Scanner(System.in);

    /** Reads a whole number. Repeats until the input is valid. */
    public static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a whole number.");
            }
        }
    }

    /** Reads a whole number between min and max (inclusive). */
    public static int readIntInRange(String prompt, int min, int max) {
        while (true) {
            int value = readInt(prompt);
            if (value >= min && value <= max) {
                return value;
            }
            System.out.println("Please enter a number between " + min + " and " + max + ".");
        }
    }

    /** Reads a yes/no answer. */
    public static boolean readYesNo(String prompt) {
        while (true) {
            System.out.print(prompt + " (y/n): ");
            String line = scanner.nextLine().trim().toLowerCase();
            if (line.equals("y") || line.equals("yes")) {
                return true;
            }
            if (line.equals("n") || line.equals("no")) {
                return false;
            }
            System.out.println("Please type y or n.");
        }
    }
}
