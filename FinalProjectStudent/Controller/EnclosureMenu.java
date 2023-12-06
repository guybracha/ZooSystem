package FinalProjectStudent.Controller;

import FinalProjectStudent.DataImport;
import FinalProjectStudent.Enclosure;

import java.util.List;
import java.util.Scanner;

/**
 * The {@code EnclosureMenu} class provides a menu-driven interface for managing enclosures in the zoo.
 * Users can display, add, and remove enclosures through various menu options.
 */
public class EnclosureMenu {

    public static void enclosureMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Enclosure Menu");
            System.out.println("1. Display Enclosures");
            System.out.println("2. Add Enclosure");
            System.out.println("3. Remove Enclosure");
            System.out.println("4. Return to Main Menu");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    displayEnclosures();
                    break;
                case 2:
                    addEnclosure();
                    break;
                case 3:
                    removeEnclosure();
                    break;
                case 4:
                    System.out.println("Returning to Main Menu");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

        } while (choice != 4);
    }

    private static void displayEnclosures() {
        // Use DataImport to import enclosure data from "data/enclosure.json"
        List<Enclosure> enclosures = DataImport.importEnclosureData("data/enclosure.json");

        if (enclosures != null && !enclosures.isEmpty()) {
            System.out.println("Displaying Enclosures:");
            for (Enclosure enclosure : enclosures) {
                System.out.println(enclosure);
            }
        } else {
            System.out.println("No enclosure data available.");
        }
    }

    private static void addEnclosure() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter enclosure details:");

        System.out.print("Enclosure ID: ");
        String enclosureID = scanner.nextLine();

        System.out.print("Enclosure Name: ");
        String enclosureName = scanner.nextLine();

        System.out.print("Capacity: ");
        int capacity = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Type: ");
        String type = scanner.nextLine();

        // Create an Enclosure object with the gathered information
        Enclosure newEnclosure = new Enclosure(enclosureID, enclosureName, capacity, type);

        // Add the new enclosure to your data structure (e.g., a list)
        List<Enclosure> enclosures = DataImport.importEnclosureData("data/enclosure.json");
        enclosures.add(newEnclosure);

        // Save the updated list back to the file (You may need to implement this)
        // DataExport.exportEnclosureData("data/enclosure.json", enclosures);

        System.out.println("New enclosure added successfully.");
    }

    private static void removeEnclosure() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter enclosure ID to remove: ");
        String enclosureIDToRemove = scanner.nextLine();

        List<Enclosure> enclosures = DataImport.importEnclosureData("data/enclosure.json");

        // Find the enclosure with the specified ID
        Enclosure enclosureToRemove = null;
        for (Enclosure enclosure : enclosures) {
            if (enclosure.getEnclosureID().equals(enclosureIDToRemove)) {
                enclosureToRemove = enclosure;
                break;
            }
        }

        // Remove the enclosure if found
        if (enclosureToRemove != null) {
            enclosures.remove(enclosureToRemove);

            // Save the updated list back to the file (You may need to implement this)
            // DataExport.exportEnclosureData("data/enclosure.json", enclosures);

            System.out.println("Enclosure removed successfully.");
        } else {
            System.out.println("Enclosure with ID " + enclosureIDToRemove + " not found.");
        }
    }
}
