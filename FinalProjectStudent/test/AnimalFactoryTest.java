package FinalProjectStudent.test;
import FinalProjectStudent.Animal;
import FinalProjectStudent.AnimalFactory;

/**
 * The {@code AnimalFactoryTest} class demonstrates the use of the AnimalFactory
 * to create and clone different types of animals.
 */
public class AnimalFactoryTest {
    /**
     * The main method for testing the AnimalFactory.
     *
     * @param args The command line arguments (not used in this example).
     */
    public static void main(String[] args) {
        // Create a lion using the factory method
        Animal lion = AnimalFactory.createAnimal("Lion", 5, true, "Simba", "Savannah", "Wild", "A123", 150.0);

        // Clone the lion using the factory method
        Animal clonedLion = AnimalFactory.cloneAnimal(lion);

        // Create a specialized animal using the factory method
        Animal specializedAnimal = AnimalFactory.createSpecializedAnimal("Giraffe", 3, true, "Gerry", "Grassland", "Wild", "A456", 800.0, "Long Neck");

        // Display information about the created animals
        System.out.println("Lion Information:");
        System.out.println(lion);

        System.out.println("\nCloned Lion Information:");
        System.out.println(clonedLion);

        System.out.println("\nSpecialized Animal Information:");
        System.out.println(specializedAnimal);
    }
}