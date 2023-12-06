package FinalProjectStudent.test;

import FinalProjectStudent.AnimalHandler;
import FinalProjectStudent.ObserverSystem;
import FinalProjectStudent.api.IObserverSystem;

/**
 * The {@code AnimalHandlerTest} class demonstrates the use of the AnimalHandler
 * class and its interaction with the ObserverSystem.
 */
public class AnimalHandlerTest {
    /**
     * The main method for testing the AnimalHandler and ObserverSystem.
     *
     * @param args The command line arguments (not used in this example).
     */
    public static void main(String[] args) {
        // Create an animal handler
        AnimalHandler animalHandler = new AnimalHandler("John", "Doe", 30, "Male", "AH001", "Zoo Department", 50000.0, "Mammals");

        // Display information about the animal handler
        System.out.println("Initial Animal Handler Information:");
        displayAnimalHandlerInfo(animalHandler);

        // Set specialization for the animal handler
        animalHandler.setSpecialization("Birds");

        // Display updated information about the animal handler
        System.out.println("\nUpdated Animal Handler Information:");
        displayAnimalHandlerInfo(animalHandler);

        // Simulate an update from the ObserverSystem
        IObserverSystem observerSystem = new ObserverSystem();
        observerSystem.addObserver(animalHandler);
        observerSystem.notifyObservers(ObserverSystem.TASK_MODE);

        // Note: In a real application, the ObserverSystem would be responsible for managing observers and notifications.
    }

    /**
     * Displays information about an AnimalHandler.
     *
     * @param animalHandler The AnimalHandler to display information about.
     */
    private static void displayAnimalHandlerInfo(AnimalHandler animalHandler) {
        System.out.println("Name: " + animalHandler.getFirstName() + " " + animalHandler.getLastName());
        System.out.println("Age: " + animalHandler.getAge());
        System.out.println("Gender: " + animalHandler.getGender());
        System.out.println("Employee ID: " + animalHandler.getEmployeeID());
        System.out.println("Department: " + animalHandler.getDepartment());
        System.out.println("Salary: " + animalHandler.getSalary());
        System.out.println("Specialization: " + animalHandler.getSpecialization());
    }
}

