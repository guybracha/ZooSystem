package FinalProjectStudent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import FinalProjectStudent.api.IZoo;
/**
 * The {@code Zoo} class represents a zoo and provides methods for managing
 * animals, enclosures, employees, visitors, and zoo operations.
 */
final public class Zoo implements IZoo {
    // Fields for zoo information
    private String zooName;
    private Manager manager;
    private Map<String, Enclosure> enclosureMap;
    private Map<String, Employee> employeeMap;
    private List<Visitor> visitors;
    private List<Animal> animals;
    
    /**
     * Constructs a new {@code Zoo} object with the specified name and manager.
     *
     * @param zooName The name of the zoo.
     * @param manager The manager of the zoo.
     */   
    public Zoo(String zooName, Manager manager) {
        this.zooName = zooName;
        this.manager = manager;
        this.employeeMap = new HashMap<>();
        this.enclosureMap = new HashMap<>();
        this.visitors = new ArrayList<>();
        this.animals = new ArrayList<>();
    }

    public String getZooName() {
        return zooName;
    }

    public Manager getManager() {
        return manager;
    }

    public List<Animal> getAnimals() {
        return Collections.unmodifiableList(animals);
    }

    public void addAnimals(List<Animal> newAnimals) {
        this.animals.addAll(newAnimals);
    }

    public Map<String, Enclosure> getEnclosureMap() {
        return Collections.unmodifiableMap(enclosureMap);
    }

    public Map<String, Employee> getEmployeeMap() {
        return employeeMap;
    }

    public List<Visitor> getVisitors() {
        return visitors;
    }

    public static Zoo createZoo(ZooBuilder zooBuilder) {
        return zooBuilder.build();
    }

    public void addEnclosure(Enclosure enclosure) {
        enclosureMap.put(enclosure.getEnclosureName(), enclosure);
    }

    @Override
    public void addAnimal(Animal animal) {
        this.animals.add(animal);
    }

    @Override
    public Animal removeAnimal(Animal animal) {
        if (this.animals.contains(animal)) {
            this.animals.remove(animal);
            return animal; // Animal found and removed
        } else {
            System.out.println("Animal not found in the zoo.");
            return null; // Animal not found
        }
    }
    
    @Override
    public Enclosure removeEnclosure(Enclosure enclosure) {
        return enclosureMap.remove(enclosure.getEnclosureName());
    }

    @Override
    public void addVisitor(Visitor visitor) {
        visitors.add(visitor);
    }

    @Override
    public Visitor removeVisitor(Visitor visitor) {
        visitors.remove(visitor);
        return visitor;
    }

    @Override
    public boolean openTheZoo() {
        // Logic to open the zoo
        return true; // Return true if successfully opened
    }

    @Override
    public boolean closeTheZoo() {
        // Logic to close the zoo
        return true; // Return true if successfully closed
    }

    public void reproduceAnimals() {
        List<Animal> newAnimals = new ArrayList<>();

        for (Animal existingAnimal : animals) {
            Animal newAnimal = existingAnimal.reproduce();
            newAnimals.add(newAnimal);
        }

        animals.clear();
        animals.addAll(newAnimals);
        System.out.println("Animals have reproduced. New animals added to the zoo.");
    }

    public void feedAnimals() {
        for (Animal animal : animals) {
            Enclosure enclosure = animal.getEnclosure();
            if (enclosure != null) {
                System.out.println("Feeding " + animal.getSpecies() + " in " + enclosure.getEnclosureName());
                // Add your feeding logic here
            } else {
                System.out.println("Warning: Animal " + animal.getSpecies() + " does not have an enclosure.");
            }
        }
        // Additional logic for feeding all animals
    }

    @Override
    public void cleanEnclosures() {
        for (Enclosure enclosure : enclosureMap.values()) {
            enclosure.clean();
        }
    }

    @Override
    public void clean() {
        System.out.println("Zoo is cleaned.");
    }

    public void displayStatistics() {
        ZooStatistics.displayStatistics(this);
    }

    public static class ZooBuilder {
        private String zooName;
        private Manager manager;
        private List<Animal> animals;
        private List<Enclosure> enclosures;

        public ZooBuilder(String zooName, Manager manager) {
            this.zooName = zooName;
            this.manager = manager;
            this.animals = new ArrayList<>();
            this.enclosures = new ArrayList<>();
        }

        public ZooBuilder addAnimal(Animal animal) {
            this.animals.add(animal);
            return this;
        }

        public ZooBuilder addEnclosure(Enclosure enclosure) {
            this.enclosures.add(enclosure);
            return this;
        }

        public ZooBuilder setZooName(String zooName) {
            this.zooName = zooName;
            return this;
        }

        public ZooBuilder setManager(Manager manager) {
            this.manager = manager;
            return this;
        }

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
    }
    
    /**
     * Initializes the zoo using data from JSON files.
     *
     * @param animalJsonFilePath The path to the JSON file containing animal data.
     * @param zooJsonFilePath    The path to the JSON file containing zoo data.
     */
    public void initializeZoo(String animalJsonFilePath, String zooJsonFilePath) {
        // Import animal data
        List<Animal> animals = DataImport.importAnimalData(animalJsonFilePath);

        // Import zoo data
        Zoo zoo = DataImport.importZooData(zooJsonFilePath);

        // Set the imported animals to the zoo
        setAnimals(animals);

        // Do other initialization with the zoo data
    }
    
    /**
     * Sets the list of animals in the zoo.
     *
     * @param animals The list of animals to set.
     */
    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    /**
     * Adds an employee to the zoo.
     *
     * @param employee The employee to add.
     */
    public void addEmployee(Employee employee) {
        employeeMap.put(employee.getEmployeeID(), employee);
    }
    /**
     * Removes an employee from the zoo.
     *
     * @param employee The employee to remove.
     * @return The removed employee or null if not found.
     */
    public Employee removeEmployee(Employee employee) {
        return employeeMap.remove(employee.getEmployeeID());
    }
}
