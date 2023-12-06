package FinalProjectStudent.Controller;

import FinalProjectStudent.Animal;
import FinalProjectStudent.DataImport;
import FinalProjectStudent.AnimalFacade;
import FinalProjectStudent.ZooFacade;
import FinalProjectStudent.Zoo;
import java.util.List;
import java.util.Scanner;

/**
 * The {@code AnimalMenu} class provides a menu-driven interface for managing animals in the zoo.
 * Users can display, add, and remove animals through various menu options.
 */
public class AnimalMenu {

    private static ZooFacade zooFacade;

    /**
     * The main entry point for the AnimalMenu functionality.
     * Displays a menu with options to display, add, or remove animals.
     */
    public static void animalMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        zooFacade = new ZooFacade(createDefaultZoo());

        do {
            System.out.println("Animal Menu");
            System.out.println("1. Display Animals");
            System.out.println("2. Add Animal");
            System.out.println("3. Remove Animal");
            System.out.println("4. Return to Main Menu");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    loadAnimalData(); // Load animal data from JSON
                    zooFacade.displayAnimals(); // Display animals
                    break;
                case 2:
                    addAnimal(); // Add a new animal
                    break;
                case 3:
                    removeAnimal(); // Remove an existing animal
                    break;
                case 4:
                    System.out.println("Returning to Main Menu");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

        } while (choice != 4);
    }

    /**
     * Adds a new animal to the zoo based on user input.
     */
    private static void addAnimal() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter animal details:");

        System.out.print("Species: ");
        String species = scanner.nextLine();

        System.out.print("Age (months): ");
        int ageMonths = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        System.out.print("Is Healthy (true/false): ");
        boolean isHealthy = scanner.nextBoolean();
        scanner.nextLine();  // Consume the newline character

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Habitat: ");
        String habitat = scanner.nextLine();

        System.out.print("Type: ");
        String type = scanner.nextLine();

        System.out.print("Chip Number: ");
        String chipNumber = scanner.nextLine();

        System.out.print("Weight: ");
        double weight = scanner.nextDouble();
        scanner.nextLine();  // Consume the newline character

        Animal newAnimal = new Animal(species, ageMonths, isHealthy, name, habitat, type, chipNumber, weight);

        zooFacade.addAnimal(newAnimal);
    }

    /**
     * Removes an animal from the zoo based on user input.
     */
    private static void removeAnimal() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter chip number of the animal to remove: ");
        String chipNumber = scanner.nextLine();

        List<Animal> animals = zooFacade.getZoo().getAnimals();

        Animal animalToRemove = findAnimal(chipNumber, animals);

        if (animalToRemove != null) {
            zooFacade.removeAnimal(animalToRemove);
            System.out.println(animalToRemove.getSpecies() + " removed from the zoo.");
        } else {
            System.out.println("Animal with chip number " + chipNumber + " not found in the zoo.");
        }
    }

    /**
     * Finds an animal in the list based on its chip number.
     *
     * @param chipNumber The chip number of the animal to find.
     * @param animals    The list of animals to search.
     * @return The found animal or null if not found.
     */
    private static Animal findAnimal(String chipNumber, List<Animal> animals) {
        for (Animal animal : animals) {
            if (animal.getChipNumber().equals(chipNumber)) {
                return animal; // Found the animal
            }
        }
        return null; // Animal with the specified ID not found
    }

    /**
     * Loads animal data from a JSON file using the {@code DataImport} class.
     */
    private static void loadAnimalData() {
        zooFacade.loadZooDataFromJson("data/animal.json");
    }

    /**
     * Creates a default Zoo instance.
     *
     * @return The default Zoo instance.
     */
    private static Zoo createDefaultZoo() {
        return new Zoo(null, null);
        // You can add default animals, employees, enclosures, etc. here
    }
}
