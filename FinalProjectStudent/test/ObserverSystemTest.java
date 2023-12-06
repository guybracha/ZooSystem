package FinalProjectStudent.test;
import FinalProjectStudent.Manager;
import FinalProjectStudent.Visitor;
import FinalProjectStudent.ObserverSystem;

/**
 * The {@code ObserverSystemTest} class serves as a test class for the {@link FinalProjectStudent.ObserverSystem} class.
 */
public class ObserverSystemTest {

    /**
     * The main method for testing the ObserverSystem class.
     *
     * @param args The command line arguments (not used in this example).
     */
    public static void main(String[] args) {
        // Create instances of observers (e.g., Manager, Visitor)
        Manager manager = new Manager("John", "Doe", 35, "Male", "M001", "HR", 50000, "HR Management");
        Visitor visitor = new Visitor("Alice", "Smith", 25, "Female", "V001");

        // Create an instance of the ObserverSystem
        ObserverSystem observerSystem = new ObserverSystem();

        // Add observers to the ObserverSystem
        observerSystem.addObserver(manager);
        observerSystem.addObserver(visitor);

        // Trigger notification with a specific mode (e.g., TASK_MODE)
        observerSystem.notifyObservers(ObserverSystem.TASK_MODE);
    }
}
