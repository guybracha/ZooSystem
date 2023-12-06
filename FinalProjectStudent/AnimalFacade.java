package FinalProjectStudent;
import FinalProjectStudent.api.AnimalPrototype;
/**
 * The {@code AnimalFacade} class provides a simplified interface for creating and interacting with animal objects.
 */
public final class AnimalFacade{
	/**
	 * Facade pattern soruces:
	 * <a href="https://www.tutorialspoint.com/design_pattern/facade_pattern.htm"</a>
	 * <a href="https://www.geeksforgeeks.org/facade-design-pattern-introduction/"</a>
	 **/
	
    /**
     * Clones an existing animal to create a new one with identical attributes.
     *
     * @param animal The animal to clone.
     * @return A new animal object that is a clone of the original animal.
     */
	 public static AnimalPrototype cloneAnimal(AnimalPrototype animal) {
	        try {
	            return animal.clone();
	        } catch (CloneNotSupportedException e) {
	            throw new UnsupportedOperationException("Cloning not supported for this type of animal");
	        }
	    }


    /**
     * Displays information about the specified animal.
     *
     * @param animal The animal to display information about.
     */
    public static void displayAnimalInfo(Animal animal) {
        animal.displayInfo();
    }
}

