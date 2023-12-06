package FinalProjectStudent.Controller;

import FinalProjectStudent.DataImport;
import FinalProjectStudent.Visitor;

import java.util.List;
import java.util.Scanner;
/**
 * The {@code VisitorMenu} class provides a menu-driven interface for managing visitors in the zoo.
 * Users can display, add, and remove visitors through various menu options.
 */
public class VisitorMenu {

    public static void visitorMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Visitor Menu");
            System.out.println("1. Display Visitors");
            System.out.println("2. Add Visitor");
            System.out.println("3. Remove Visitor");
            System.out.println("4. Return to Main Menu");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    displayVisitors();
                    break;
                case 2:
                    addVisitor();
                    break;
                case 3:
                    removeVisitor();
                    break;
                case 4:
                    System.out.println("Returning to Main Menu");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

        } while (choice != 4);
    }

    private static void displayVisitors() {
        List<Visitor> visitors = DataImport.importVisitorData("data/visitors.json");
        if (visitors != null && !visitors.isEmpty()) {
            System.out.println("Displaying Visitors:");
            for (Visitor visitor : visitors) {
                System.out.println(visitor);
            }
        } else {
            System.out.println("No visitors found.");
        }
    }

    private static void addVisitor() {
        // Implement logic to add a new visitor
        System.out.println("Adding a new visitor...");
    }

    private static void removeVisitor() {
        // Implement logic to remove a visitor
        System.out.println("Removing a visitor...");
    }
}
