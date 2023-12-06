package FinalProjectStudent.Controller;

import FinalProjectStudent.DataImport;
import FinalProjectStudent.Manager;

import java.util.List;
import java.util.Scanner;
/**
 * The {@code ManagerMenu} class provides a menu-driven interface for managing managers in the zoo.
 * Users can display, add, and remove managers through various menu options.
 */
public class ManagerMenu {

    static void managerMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Manager Menu");
            System.out.println("1. Display Managers");
            System.out.println("2. Add Manager");
            System.out.println("3. Remove Manager");
            System.out.println("4. Return to Main Menu");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    displayManagers();
                    break;
                case 2:
                    addManager();
                    break;
                case 3:
                    removeManager();
                    break;
                case 4:
                    System.out.println("Returning to Main Menu");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

        } while (choice != 4);
    }

    private static void displayManagers() {
        List<Manager> managers = DataImport.importManagerData("data/manager.json");
        if (managers != null && !managers.isEmpty()) {
            System.out.println("Displaying Managers:");
            for (Manager manager : managers) {
                System.out.println(manager);
            }
        } else {
            System.out.println("No managers found.");
        }
    }

    private static void addManager() {
        // Implement logic to add a new manager
        System.out.println("Adding a new manager...");
    }

    private static void removeManager() {
        // Implement logic to remove a manager
        System.out.println("Removing a manager...");
    }
}
