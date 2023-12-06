package FinalProjectStudent;

import FinalProjectStudent.api.AnimalPrototype;

public final class AnimalFactory implements AnimalPrototype {

    private AnimalFactory() {
        // Private constructor to prevent instantiation
        throw new UnsupportedOperationException("AnimalFactory cannot be instantiated.");
    }

    // Creating and returning a new animal.
    public static Animal createAnimal(String species, int ageMonths, boolean isHealthy, String name, String habitat, String type, String chipNumber, double weight) {
        return new Animal(species, ageMonths, isHealthy, name, habitat, type, chipNumber, weight);
    }

    // Cloning a new animal.
    public static Animal cloneAnimal(Animal animal) {
        return new Animal(animal); // Assuming you have a copy constructor in Animal
    }

    // Creating a specialized animal directly
    public static Animal createSpecializedAnimal(String species, int ageMonths, boolean isHealthy, String name, String habitat, String type, String chipNumber, double weight, String specialization) {
        return new Animal(species, ageMonths, isHealthy, name, habitat, type, chipNumber, weight);
        // Add specialization logic here if needed
    }

    @Override
    public AnimalPrototype clone() {
        // Implement the logic to create a clone of the current animal
        throw new UnsupportedOperationException("Cloning not supported for this type of animal");
    }
}
