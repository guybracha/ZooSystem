package FinalProjectStudent.test;

import FinalProjectStudent.Animal;
import FinalProjectStudent.Enclosure;

/**
 * The {@code EnclosureTest} class serves as a test class for the {@link FinalProjectStudent.Enclosure} class.
 */
public class EnclosureTest {
    /**
     * The main method for testing the Enclosure class.
     *
     * @param args The command line arguments (not used in this example).
     */
    public static void main(String[] args) {
        // Create an enclosure for Mammals
        Enclosure mammalEnclosure = new Enclosure("Mammal Enclosure", "Mammals", 0, null);

        // Create some animals
        Animal lion = new Animal("Lion", 5, true, "Simba", "Savannah", "Wild", "A123", 150.0);
        Animal elephant = new Animal("Elephant", 10, true, "Dumbo", "Jungle", "Wild", "B456", 500.0);
        Animal giraffe = new Animal("Giraffe", 7, true, "Longneck", "Savannah", "Wild", "C789", 300.0);

        // Add animals to the enclosure
        mammalEnclosure.addAnimal(lion);
        mammalEnclosure.addAnimal(elephant);

        // Display information about the enclosure
        System.out.println("Initial Enclosure Information:");
        displayEnclosureInfo(mammalEnclosure);

        // Attempt to add a giraffe (different species) to the enclosure
        mammalEnclosure.addAnimal(giraffe);

        // Display updated information about the enclosure
        System.out.println("\nUpdated Enclosure Information:");
        displayEnclosureInfo(mammalEnclosure);
    }

    /**
     * Displays information about the enclosure.
     *
     * @param enclosure The enclosure to display information about.
     */
    private static void displayEnclosureInfo(Enclosure enclosure) {
        System.out.println("Enclosure Name: " + enclosure.getEnclosureName());
        System.out.println("Enclosure Type: " + enclosure.getType());
        System.out.println("Animals in the Enclosure: " + enclosure.getAnimals());
    }
}

