package FinalProjectStudent.test;

import FinalProjectStudent.Manager;
import FinalProjectStudent.Animal;
import FinalProjectStudent.Zoo;
import FinalProjectStudent.Enclosure;
import FinalProjectStudent.ZooFacade;
import FinalProjectStudent.Visitor;


/**
 * The {@code ZooFacadeTest} class serves as a test class for the {@link FinalProjectStudent.ZooFacade} class.
 */
public class ZooFacadeTest {
    /**
     * The main method for testing the ZooFacade class.
     *
     * @param args The command line arguments (not used in this example).
     */
    public static void main(String[] args) {
        // Create a manager
        Manager manager = new Manager("John", "Doe", 35, "Male", "M456", "Administration", 60000, "Admin");

        // Create a zoo
        Zoo zoo = new Zoo("Safari Zoo", manager);

        // Create a ZooFacade
        ZooFacade zooFacade = new ZooFacade(zoo);

        // Create some animals and enclosures
        Animal lion = new Animal("Lion", 5, true, "Simba", "Savannah", "Wild", "A123", 150.0);
        Enclosure lionEnclosure = new Enclosure("Lion Enclosure", "Savannah", 0, null);

        // Add animals and enclosures using the ZooFacade
        zooFacade.addAnimal(lion);
        zooFacade.addEnclosure(lionEnclosure);

        // Open the zoo
        zooFacade.openTheZoo();

        // Add a visitor
        Visitor visitor = new Visitor("Alice", "Smith", 30, "Female", "V001");
        zooFacade.addVisitor(visitor);

        // Feed all animals
        zooFacade.feedAnimals();

        // Clean all enclosures
        zooFacade.cleanEnclosures();

        // Close the zoo
        zooFacade.closeTheZoo();
    }
}
