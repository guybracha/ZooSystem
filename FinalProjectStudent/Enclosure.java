package FinalProjectStudent;

import FinalProjectStudent.Animal;
import FinalProjectStudent.api.IEnclosure;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * The {@code Enclosure} class represents an enclosure in a zoo that houses animals.
 */
public final class Enclosure implements IEnclosure {
    private String enclosureID;
    private String enclosureName;
    private int capacity;
    private String type;
    private List<Animal> animals;

    /**
     * Constructs a new {@code Enclosure} object with the specified attributes.
     *
     * @param enclosureID   The ID of the enclosure.
     * @param enclosureName The name of the enclosure.
     * @param capacity      The capacity of the enclosure.
     * @param type           The type of animals the enclosure is designed for (e.g., "Mammals," "Birds").
     */
    public Enclosure(String enclosureID, String enclosureName, int capacity, String type) {
        this.enclosureID = enclosureID;
        this.enclosureName = enclosureName;
        this.capacity = capacity;
        this.type = type;
        this.animals = new LinkedList<>();
    }

    // Existing methods...

    /**
     * Gets the ID of the enclosure.
     *
     * @return The ID of the enclosure.
     */
    public String getEnclosureID() {
        return enclosureID;
    }

    /**
     * Gets the name of the enclosure.
     *
     * @return The name of the enclosure.
     */
    public String getEnclosureName() {
        return enclosureName;
    }

    public String getType() {
    	return type;
    }
    /**
     * Gets the capacity of the enclosure.
     *
     * @return The capacity of the enclosure.
     */
    public int getCapacity() {
        return capacity;
    }

    // Other getters and setters...

    /**
     * Returns a string representation of the {@code Enclosure} object.
     *
     * @return A string describing the enclosure, including its ID, name, capacity, and type.
     */
    @Override
    public String toString() {
        return "Enclosure{" +
                "enclosureID='" + enclosureID + '\'' +
                ", enclosureName='" + enclosureName + '\'' +
                ", capacity=" + capacity +
                ", type='" + type + '\'' +
                '}';
    }

	@Override
	public void clean() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addAnimal(Animal animal) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Animal removeAnimal(Animal animal) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Animal> getAnimals() {
	    return Collections.unmodifiableList(animals);
	}

    // Existing methods...
}
