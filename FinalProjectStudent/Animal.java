package FinalProjectStudent;

import FinalProjectStudent.api.AnimalPrototype;
import FinalProjectStudent.api.IAnimal;

/**
 * The {@code Animal} class represents an individual animal in a zoo.
 * It contains information about the animal's species, age, and health status.
 * This class implements the Prototype pattern, allowing animals to reproduce
 * by creating new instances of themselves through cloning.
 */
public final class Animal implements AnimalPrototype, IAnimal{
	/**
	 * Using prototype design pattern
	 * Src links:
	 * <a href="https://www.geeksforgeeks.org/prototype-design-pattern/"</a>
	 * <a href="https://www.tutorialspoint.com/design_pattern/prototype_pattern.htm"</a>
	 * Server as a concrete for AnimalFacade and AnimalFactory through IAnimal interface.
	 * Also it's implements the animalProtoytype interface for cloning animals.
	 * */
    /**
     * The chip number of the animal.
     */
    private String chipNumber;

    /**
     * Whether the animal is carnivorous or not.
     */
    private boolean isCarnivorous;

    /**
     * Whether the animal is nocturnal or not.
     */
    private boolean isNocturnal;

    /**
     * The species of the animal.
     */
    private String species;

    /**
     * The type of the animal.
     */
    private String type;
    /**
     * The name of the animal.
     */
    private String name;
    /**
     * The habitat of the animal.
     */
    private String habitat;
    /**
     * The age of the animal in months.
     */
    private int ageMonths;

    /**
     * The health status of the animal.
     */
    private boolean isHealthy;

    /**
     * The sound of the animal.
     */
    private String sound;
    /**
     * The Enclosure. 
     */
    private Enclosure enclosure;

    /**
     * The weight of the animal.
     * */
    private double weight;
    
    
    public String getType() {
        return type;
    }

    public String getName() {
    	return name;
    }
    /**
     * Constructs a new {@code Animal} object with the specified species, age, and health status.
     *
     * @param species    The species of the animal.
     * @param ageMonths  The age of the animal in months.
     * @param isHealthy  The health status of the animal (true if healthy, false otherwise).
     * @param name       The name  of the animal.
     * @param habitat    The habitat  of the animal.
     * @param type       The type  of the animal.
     * @param chipNumber The type  of the animal.
     * @param weight	 The weight of the animal.
     */
    public Animal(String species, int ageMonths, boolean isHealthy, String name, String habitat, String type, String chipNumber, double weight) {
        this.species = species;
        this.ageMonths = ageMonths;
        this.isHealthy = isHealthy;
        this.name = name;
        this.habitat = habitat;
        this.type = type;
        this.chipNumber = chipNumber;
        this.weight = weight;
    }

    /**
     * Creates a new {@code Animal} object by copying the attributes from another {@code Animal}.
     *
     * @param other The {@code Animal} object to copy attributes from.
     */
    public Animal(Animal other) {
        this.species = other.species;
        this.ageMonths = other.ageMonths;
        this.isHealthy = other.isHealthy;
        this.name = other.name;
        this.habitat = other.habitat;
        this.type = other.type;
        this.isCarnivorous = other.isCarnivorous;
        this.isNocturnal = other.isNocturnal;
        this.chipNumber = other.chipNumber;
    }

    //-----------------------------------------------------------------------
    /**
     * Creates a new {@code Animal} object by copying the attributes from another {@code Animal}.
     *
     * @param other The {@code Animal} object to copy attributes from.
     */
    //-----------------------------------------------------------------------
    
    /**
     * Returns the species of the animal.
     *
     * @return The species of the animal.
     */
    public String getSpecies() {
        return species;
    }

    /**
     * Returns the age of the animal in months.
     *
     * @return The age of the animal in months.
     */
    public int getAgeMonths() {
        return ageMonths;
    }

    /**
     * Returns the health status of the animal.
     *
     * @return {@code true} if the animal is healthy, {@code false} otherwise.
     */
    public boolean isHealthy() {
        return isHealthy;
    }

    /**
     * Sets the health status of the animal.
     *
     * @param healthy {@code true} if the animal is healthy, {@code false} otherwise.
     */
    public void setHealthy(boolean healthy) {
        isHealthy = healthy;
    }
    /**
     * Gets the enclosure where the animal is kept.
     *
     * @return The enclosure where the animal is kept.
     */
    public void setSound(String sound) {
        this.sound = sound;
    }
    /**
     * Returns the weight of the animal.
     *
     * @return The weight of the animal.
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Sets the weight of the animal.
     *
     * @param weight The new weight of the animal.
     */
    public void setWeight(double weight) {
        this.weight = weight;
        System.out.println("Weight of " + species + " is now: " + weight + " kg");
    }

    /**
     * Changes the weight of the animal by a specified amount.
     *
     * @param amount The amount by which to change the weight.
     */
    public void changeWeight(double amount) {
        this.weight += amount;
        System.out.println("Weight of " + species + " changed by " + amount + " kg. New weight: " + weight + " kg");
    }
    
    @Override
    public Enclosure getEnclosure() {
        return enclosure;
    }
    /**
     * Sets the enclosure where the animal is kept.
     *
     * @param enclosure The enclosure where the animal is kept.
     */
    
    @Override
    public void setEnclosure(Enclosure enclosure) {
        this.enclosure = enclosure;
    }
    
    public void setChipNumber(String chipNumber) {
    	this.chipNumber = chipNumber;
    }
    public String getChipNumber() {
    	return chipNumber;
    }

    /**
     * Returns a string representation of the animal.
     *
     * @return A string describing the animal.
     */
    @Override
    public String toString() {
        return "Animal{" +
                "chipNumber='" + chipNumber + '\'' +
                ", isCarnivorous=" + isCarnivorous +
                ", isNocturnal=" + isNocturnal +
                ", species='" + species + '\'' +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", habitat='" + habitat + '\'' +
                ", ageMonths=" + ageMonths +
                ", isHealthy=" + isHealthy +
                ", sound='" + sound + '\'' +
                '}';
    }

    //-----------------------------------------------------------------------
    /**
     * The {@code AnimalBuilder} class is used to construct instances of the {@code Animal} class
     * with various optional parameters, allowing for a flexible and convenient way to create animal objects.
     */
    //-----------------------------------------------------------------------

    /**
     * Reproduces to create a new instance of the same species.
     *
     * @return A new instance of the same species.
     */
    public Animal reproduce() {
    	return new Animal(this);
    }
    
    /**
     * Returns the chip number (unique ID) of the animal.
     *
     * @return The chip number (unique ID) of the animal.
     */
    public String getAnimalID() {
        return chipNumber;
    }

	@Override
	public void makeSound() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eat(String food) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayInfo() {
	    System.out.println("Animal Information:");
	    System.out.println("Species: " + species);
	    System.out.println("Name: " + name);
	    System.out.println("Habitat: " + habitat);
	    System.out.println("Age (Months): " + ageMonths);
	    System.out.println("Is Healthy: " + isHealthy);
	    System.out.println("Weight: " + weight + " kg");
	}


	@Override
	public void sleep() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void move(String movement) {
		// TODO Auto-generated method stub
		
	}
    @Override
    public AnimalPrototype clone() throws CloneNotSupportedException {
        return (AnimalPrototype) super.clone();
    }
}

