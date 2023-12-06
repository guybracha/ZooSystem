package FinalProjectStudent.test;

import FinalProjectStudent.Animal;
/**
 * The {@code AnimalTest} class serves as a test class for the {@link FinalProjectStudent.Animal} class.
 */
public class AnimalTest {
    /**
     * The main method for testing the Animal class.
     *
     * @param args The command line arguments (not used in this example).
     */
    public static void main(String[] args) {
        // Create an animal
        Animal lion = new Animal("Lion", 5, true, "Simba", "Savannah", "Wild", "A123", 150.0);

        // Display information about the initial lion
        System.out.println("Initial Lion Information:");
        System.out.println(lion);

        // Reproduce the lion to create a new instance
        Animal lionCub = lion.reproduce();

        // Display information about the lion cub
        System.out.println("\nReproduced Lion Cub Information:");
        System.out.println(lionCub);
    }
}
