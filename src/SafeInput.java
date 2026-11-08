
import java.util.Scanner;

public class SafeInput {

    // Get an integer within a specified range
    public static int getRangedInt(Scanner console, String prompt, int low, int high) {

        int number;

        do {
            System.out.print(prompt);

            while (!console.hasNextInt()) {
                System.out.println("Please enter a valid number.");
                console.nextLine();
                System.out.print(prompt);
            }

            number = console.nextInt();
            console.nextLine();

            if (number < low || number > high) {
                System.out.println("Please enter a number between " + low + " and " + high + ".");
            }

        } while (number < low || number > high);

        return number;
    }

    // Get a yes or no answer
    public static boolean getYNConfirm(Scanner console, String prompt) {

        String answer;

        do {
            System.out.print(prompt);
            answer = console.nextLine().trim();

            if (!answer.equalsIgnoreCase("Y") && !answer.equalsIgnoreCase("N")) {
                System.out.println("Please enter Y or N.");
            }

        } while (!answer.equalsIgnoreCase("Y") && !answer.equalsIgnoreCase("N"));

        return answer.equalsIgnoreCase("Y");
    }

    // Get a string that matches a regular expression
    public static String getRegExString(Scanner console, String prompt, String regExPattern) {

        String value;

        do {
            System.out.print(prompt);
            value = console.nextLine();

            if (!value.matches(regExPattern)) {
                System.out.println("Invalid input. Please try again.");
            }

        } while (!value.matches(regExPattern));

        return value;
    }
}

