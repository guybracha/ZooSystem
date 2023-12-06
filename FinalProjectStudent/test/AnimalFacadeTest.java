package FinalProjectStudent.test;
import FinalProjectStudent.AnimalFacade;
import FinalProjectStudent.Animal;

/**
 * The {@code AnimalFacadeTest} class demonstrates the use of the AnimalFacade
 * to clone an Animal and display information about both the original and cloned animals.
 */
public class AnimalFacadeTest {
    /**
     * The main method for testing the AnimalFacade.
     *
     * @param args The command line arguments (not used in this example).
     */
    public static void main(String[] args) {
        // Create an animal
        Animal lion = new Animal("Lion", 5, true, "Simba", "Savannah", "Wild", "A123", 150.0);

        // Clone the animal using the facade
        Animal clonedLion = (Animal) AnimalFacade.cloneAnimal(lion);

        // Display information about the original and cloned lions
        System.out.println("Original Lion Information:");
        AnimalFacade.displayAnimalInfo(lion);

        System.out.println("\nCloned Lion Information:");
        AnimalFacade.displayAnimalInfo(clonedLion);
    }
}