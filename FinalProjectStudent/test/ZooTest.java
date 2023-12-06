package FinalProjectStudent.test;

import FinalProjectStudent.Manager;
import FinalProjectStudent.Zoo;
import FinalProjectStudent.Zoo.ZooBuilder;
import FinalProjectStudent.Animal;
import FinalProjectStudent.Enclosure;

/**
 * The {@code ZooTest} class serves as a test class for the {@link FinalProjectStudent.Zoo} class.
 */
public class ZooTest {
    /**
     * The main method for testing the Zoo class.
     *
     * @param args The command line arguments (not used in this example).
     */
    public static void main(String[] args) {
        Manager manager = new Manager("John", "Doe", 35, "Male", "M456", "Administration", 60000, "Admin");
        Zoo.ZooBuilder zooBuilder = new Zoo.ZooBuilder("Safari", manager);

        // Create animals
        Animal lion = new Animal("Lion", 5, true, "Simba", "Savannah", "Wild", "A123", 150.0);
        Animal elephant = new Animal("Elephant", 10, true, "Dumbo", "Jungle", "Wild", "A456", 500.0);

        // Create enclosures
        Enclosure lionEnclosure = new Enclosure("Lion Enclosure", "Savannah", 0, null);
        Enclosure elephantEnclosure = new Enclosure("Elephant Enclosure", "Jungle", 0, null);

        // Add animals and enclosures to the ZooBuilder
        zooBuilder.addAnimal(lion);
        zooBuilder.addAnimal(elephant);
        zooBuilder.addEnclosure(lionEnclosure);
        zooBuilder.addEnclosure(elephantEnclosure);

        // Build the zoo using the ZooBuilder
        Zoo zoo = Zoo.createZoo(zooBuilder);

        // Display zoo statistics
        zoo.displayStatistics();
    }
}
