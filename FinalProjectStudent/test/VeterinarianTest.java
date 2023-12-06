package FinalProjectStudent.test;

import FinalProjectStudent.ObserverSystem;
import FinalProjectStudent.Veterinarian;

/**
 * The {@code VeterinarianTest} class serves as a test class for the {@link FinalProjectStudent.Veterinarian} class.
 */
public class VeterinarianTest {

    /**
     * The main method for testing the Veterinarian class.
     *
     * @param args The command line arguments (not used in this example).
     */
    public static void main(String[] args) {
        // Create an instance of the ObserverSystem
        ObserverSystem observerSystem = new ObserverSystem();

        // Create an instance of the Veterinarian
        Veterinarian veterinarian = new Veterinarian("Dr. Sarah", "Smith", 40, "Female",
                "VET001", "Veterinary Department", 70000, "Wildlife Medicine");

        // Add the Veterinarian instance to the ObserverSystem
        observerSystem.addObserver(veterinarian);

        // Trigger notification with a specific mode (e.g., TASK_MODE)
        observerSystem.notifyObservers(ObserverSystem.TASK_MODE);

        // You can also perform other actions or test additional methods of the Veterinarian class
        veterinarian.provideMedicalCare();
    }
}
