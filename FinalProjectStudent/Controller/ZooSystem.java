package FinalProjectStudent.Controller;

import java.util.Scanner;

import FinalProjectStudent.Animal;
import FinalProjectStudent.AnimalFacade;
import FinalProjectStudent.ZooFacade;
import FinalProjectStudent.Employee;
import FinalProjectStudent.Enclosure;
import FinalProjectStudent.Manager;
import FinalProjectStudent.Zoo;
import FinalProjectStudent.DataImport;

import java.util.List;
/**
 * The ZooSystem class serves as the main entry point for the Zoo Management System.
 * It provides a console-based menu for users to interact with different functionalities
 * such as managing animals, employees, enclosures, managers, and visitors.
 */
public class ZooSystem {
	 /**
     * The main method that starts the Zoo Management System.
     * It displays a welcome message and a menu for users to navigate through the system.
     *
     * @param args Command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
    	
        System.out.println("Welcome to the Zoo");

        while (true) {
            int num = MainMenu();
            switch (num) {
                case 1:
                    AnimalMenu.animalMenu();
                    break;
                case 2:
                    EmployeeMenu.employeeMenu();
                    break;
                case 3:
                    EnclosureMenu.enclosureMenu();
                    break;
                case 4:
                    ManagerMenu.managerMenu();
                    break;
                case 5:
                    VisitorMenu.visitorMenu();
                    break;
                case 6:
                    System.out.println("Bye Bye");
                    return;
            }
        }
    }
    /**
     * Loads animal data from a data source.
     * Note: The implementation of this method is currently missing.
     */
	  private static void loadAnimalData() {
	        // Implement logic to load animal data
	        System.out.println("Loading animal data...");
	    }
	  /**
	     * Loads zoo data from a data source.
	     * Note: The implementation of this method is currently missing.
	     */
	    private static void loadZooData() {
	        // Implement logic to load zoo data
	        System.out.println("Loading zoo data...");
	    }

	    /**
	     * Displays a simple menu to the user, prompting them to choose an option.
	     *
	     * @return The user's selected option.
	     */
	   private static int MainMenu() {
	        System.out.println("Menu");
	        System.out.println("Select the desired option");
	        System.out.println("1. Animal Menu");
	        System.out.println("2. Employee Menu");
	        System.out.println("3. Enclosure Menu");
	        System.out.println("4. Manager Menu");
	        System.out.println("5. Visitor Menu");
	        System.out.println("6. Exit");

	        // Read user input
	        Scanner scanner = new Scanner(System.in);
	        return scanner.nextInt();

	    }

	   /**
	     * Creates a default Zoo instance.
	     * Note: Currently, it returns a Zoo instance with null parameters.
	     * You can customize this method to create a Zoo with default data.
	     *
	     * @return The default Zoo instance.
	     */
    private static Zoo createDefaultZoo() {
        Zoo zoo = new Zoo(null, null);
        // You can add default animals, employees, enclosures, etc. here
        return zoo;
    }

}