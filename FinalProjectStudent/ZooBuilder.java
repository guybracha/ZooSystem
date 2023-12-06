package FinalProjectStudent;

import java.util.ArrayList;
import java.util.List;
/**
 * The {@code ZooBuilder} class is responsible for building a {@code Zoo} object with specified attributes.
 */
public class ZooBuilder {
    private String zooName;
    private Manager manager;
    private List<Animal> animals;
    private List<Enclosure> enclosures;
    /**
     * Constructs a new {@code ZooBuilder} with the given zoo name and manager.
     *
     * @param zooName The name of the zoo.
     * @param manager The manager of the zoo.
     */
    public ZooBuilder(String zooName, Manager manager) {
        this.zooName = zooName;
        this.manager = manager;
        this.animals = new ArrayList<>();
        this.enclosures = new ArrayList<>();
    }
    /**
     * Adds an animal to the zoo.
     *
     * @param animal The animal to be added.
     * @return The updated {@code ZooBuilder} instance.
     */
    public ZooBuilder addAnimal(Animal animal) {
        this.animals.add(animal);
        return this;
    }
    /**
     * Adds an enclosure to the zoo.
     *
     * @param enclosure The enclosure to be added.
     * @return The updated {@code ZooBuilder} instance.
     */
    public ZooBuilder addEnclosure(Enclosure enclosure) {
        this.enclosures.add(enclosure);
        return this;
    }

    public ZooBuilder setZooName(String zooName) {
        this.zooName = zooName;
        return this;
    }
    /**
     * Sets the manager of the zoo.
     *
     * @param manager The manager of the zoo.
     * @return The updated {@code ZooBuilder} instance.
     */
    public ZooBuilder setManager(Manager manager) {
        this.manager = manager;
        return this;
    }

    /**
     * Builds and returns a {@code Zoo} object based on the specified attributes.
     *
     * @return The constructed {@code Zoo} object.
     */
    public Zoo build() {
        String finalZooName = (zooName != null) ? zooName : "DefaultZoo";
        Manager finalManager = (manager != null)
                ? manager
                : new Manager("Default", "Manager", 30, "Male", "M123", "Administration", 50000, "Admin");

        Zoo zoo = new Zoo(finalZooName, finalManager);

        for (Animal animal : animals) {
            zoo.addAnimal(animal);
        }

        for (Enclosure enclosure : enclosures) {
            zoo.addEnclosure(enclosure);
        }

        return zoo;
    }
    /**
     * Example usage of the {@code ZooBuilder} to create a zoo with animals and enclosures.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        // Create a manager
        Manager manager = new Manager("John", "Doe", 35, "Male", "M456", "Administration", 60000, "Admin");

        // Create animals
        Animal lion = new Animal("Lion", 5, true, "Simba", "Savannah", "Wild", "A123", 150.0);
        Animal elephant = new Animal("Elephant", 10, true, "Dumbo", "Jungle", "Wild", "A456", 500.0);

     // Create enclosures
        Enclosure lionEnclosure = new Enclosure("Lion Enclosure", "Savannah", 0, "Savannah");
        Enclosure elephantEnclosure = new Enclosure("Elephant Enclosure", "Jungle", 0, "Jungle");

        // Build the zoo using the ZooBuilder
        Zoo zoo = new ZooBuilder("Safari Zoo", manager)
                .addAnimal(lion)
                .addAnimal(elephant)
                .addEnclosure(lionEnclosure)
                .addEnclosure(elephantEnclosure)
                .build();

        // Display zoo statistics
        zoo.displayStatistics();
    }
}
