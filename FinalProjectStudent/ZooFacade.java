package FinalProjectStudent;

import FinalProjectStudent.api.IObserverSystem;
import FinalProjectStudent.api.IZooAction;
import java.util.ArrayList;
import java.util.List;
import FinalProjectStudent.DataImport;

/**
 * The {@code ZooFacade} class simplifies interactions between zoo workers and the system.
 * It provides high-level methods for common tasks in the zoo.
 * Implements the interface of IZooAction using the Facade Pattern.
 * - [Facade Pattern Tutorial](https://www.tutorialspoint.com/design_pattern/facade_pattern.htm)
 * - [Introduction to Facade Design Pattern](https://www.geeksforgeeks.org/facade-design-pattern-introduction/)
 */
public class ZooFacade implements IZooAction {

    private final Zoo zoo;
    private List<IObserverSystem> observers = new ArrayList<>();

    /**
     * Constructs a {@code ZooFacade} with the specified zoo.
     *
     * @param zoo The underlying zoo system.
     */
    public ZooFacade(Zoo zoo) {
        this.zoo = zoo;
    }

    /**
     * Adds an observer to the list of observers.
     *
     * @param observer The observer to be added.
     */
    public void addObserver(IObserverSystem observer) {
        observers.add(observer);
    }

    /**
     * Removes an observer from the list of observers.
     *
     * @param observer The observer to be removed.
     */
    public void removeObserver(IObserverSystem observer) {
        observers.remove(observer);
    }

    /**
     * Notifies all observers with a specific task.
     *
     * @param task The task to be performed.
     */
    public void notifyObservers(String task) {
        for (IObserverSystem observer : observers) {
            observer.update(task);
        }
    }

    /**
     * Loads zoo data from a JSON file.
     *
     * @param jsonFilePath The path to the JSON file containing zoo data.
     */
    public void loadZooDataFromJson(String jsonFilePath) {
        try {
            List<Animal> animals = DataImport.importAnimalData(jsonFilePath);
            if (animals != null) {
                zoo.setAnimals(animals);
                System.out.println("Zoo data loaded successfully.");
            } else {
                System.out.println("Failed to load zoo data. No animals found.");
            }
        } catch (Exception e) {
            System.err.println("Error loading zoo data from file - " + jsonFilePath);
            e.printStackTrace();
        }
    }
    
    /**
     * Adds an animal to the zoo.
     *
     * @param animal The animal to be added.
     */
    public void addAnimal(Animal animal) {
        zoo.addAnimal(animal);
        System.out.println(animal.getSpecies() + " added to the zoo.");
    }

    /**
     * Removes an animal from the zoo.
     *
     * @param animal The animal to be removed.
     */
    public void removeAnimal(Animal animal) {
        zoo.removeAnimal(animal);
        System.out.println(animal.getSpecies() + " removed from the zoo.");
    }

    /**
     * Displays all animals in the zoo.
     */
    public void displayAnimals() {
        List<Animal> animals = zoo.getAnimals();
        if (animals != null && !animals.isEmpty()) {
            for (Animal animal : animals) {
                System.out.println(animal);
            }
        } else {
            System.out.println("No animals in the zoo.");
        }
    }

    /**
     * Adds an enclosure to the zoo.
     *
     * @param enclosure The enclosure to be added.
     */
    public void addEnclosure(Enclosure enclosure) {
        zoo.addEnclosure(enclosure);
        System.out.println("Enclosure added to the zoo.");
    }

    /**
     * Adds a visitor to the zoo.
     *
     * @param visitor The visitor to be added.
     */
    public void addVisitor(Visitor visitor) {
        zoo.addVisitor(visitor);
        System.out.println("Visitor added to the zoo.");
    }

    /**
     * Adds an employee to the zoo.
     *
     * @param employee The employee to be added.
     */
    public void addEmployee(Employee employee) {
        zoo.addEmployee(employee);
        System.out.println("Employee added to the zoo.");
    }

    /**
     * Removes an employee from the zoo.
     *
     * @param employee The employee to be removed.
     */
    public void removeEmployee(Employee employee) {
        zoo.removeEmployee(employee);
        System.out.println("Employee removed from the zoo.");
    }

    /**
     * Opens the zoo for visitors.
     */
    public void openTheZoo() {
        if (zoo.openTheZoo()) {
            System.out.println("The zoo is now open for visitors.");
        } else {
            System.out.println("Failed to open the zoo.");
        }
    }

    /**
     * Closes the zoo.
     */
    public void closeTheZoo() {
        if (zoo.closeTheZoo()) {
            System.out.println("The zoo is now closed.");
        } else {
            System.out.println("Failed to close the zoo.");
        }
    }



    @Override
    public void feedAnimals() {
        zoo.feedAnimals();
        System.out.println("All animals have been fed.");
    }

    @Override
    public void cleanEnclosures() {
        zoo.cleanEnclosures();
        System.out.println("All enclosures have been cleaned.");
    }

    /**
     * Performs a generic task and notifies observers.
     */
    public void performTask() {
        // Perform some task

        // Notify observers
        notifyObservers(IObserverSystem.TASK_MODE);
    }

    /**
     * Gets the underlying zoo.
     *
     * @return The zoo object.
     */
    public Zoo getZoo() {
        return zoo;
    }
}
