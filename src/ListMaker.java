
import java.util.ArrayList;
import java.util.Scanner;

public class ListMaker {

    // Create the ArrayList
    private static ArrayList<String> myList = new ArrayList<>();

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        boolean quit = false;

        // Keep showing the menu until the user quits
        while (!quit) {

            // Display the current list and menu
            displayMenu();

            // Get the user's menu choice
            String choice = SafeInput.getRegExString(
                    console, "Enter your choice: ", "[AaDdIiPpQq]");

            // Perform the selected action
            switch (choice.toUpperCase()) {

                case "A":
                    addItem(console);
                    break;

                case "D":
                    deleteItem(console);
                    break;

                case "I":
                    insertItem(console);
                    break;

                case "P":
                    printList();
                    break;

                case "Q":
                    if (SafeInput.getYNConfirm(
                            console, "Are you sure you want to quit? ")) {
                        quit = true;
                    }
                    break;
            }
        }

        System.out.println("Goodbye!");

        console.close();
    }

    // Display the current list and menu options
    private static void displayMenu() {

        System.out.println("\n===== LIST MAKER =====");

        displayList();

        System.out.println("\nA - Add an item");
        System.out.println("D - Delete an item");
        System.out.println("I - Insert an item");
        System.out.println("P - Print the list");
        System.out.println("Q - Quit");
    }

    // Display the numbered list
    private static void displayList() {

        System.out.println("\nCurrent List:");

        if (myList.isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            for (int i = 0; i < myList.size(); i++) {
                System.out.println((i + 1) + ". " + myList.get(i));
            }
        }
    }

    // Add an item to the end of the list
    private static void addItem(Scanner console) {

        String item = SafeInput.getRegExString(
                console, "Enter the item to add: ", ".+");

        myList.add(item);

        System.out.println("Item added!");
    }

    // Delete an item from the list
    private static void deleteItem(Scanner console) {

        if (myList.isEmpty()) {
            System.out.println("There are no items to delete.");
        } else {

            displayList();

            int itemNumber = SafeInput.getRangedInt(
                    console, "Enter the item number to delete: ",
                    1, myList.size());

            myList.remove(itemNumber - 1);

            System.out.println("Item deleted!");
        }
    }

    // Insert an item at a selected location
    private static void insertItem(Scanner console) {

        String item = SafeInput.getRegExString(
                console, "Enter the item to insert: ", ".+");

        int location = SafeInput.getRangedInt(
                console, "Enter the location to insert the item: ",
                1, myList.size() + 1);

        myList.add(location - 1, item);

        System.out.println("Item inserted!");
    }

    // Print the current list
    private static void printList() {

        displayList();
    }
}

