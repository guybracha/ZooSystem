package FinalProjectStudent.test;

import FinalProjectStudent.Visitor;
import FinalProjectStudent.ObserverSystem;


/**
 * The {@code VisitorTest} class serves as a test class for the {@link FinalProjectStudent.Visitor} class.
 */
public class VisitorTest {

    /**
     * The main method for testing the Visitor class.
     *
     * @param args The command line arguments (not used in this example).
     */
    public static void main(String[] args) {
        // Create an instance of the ObserverSystem
        ObserverSystem observerSystem = new ObserverSystem();

        // Create an instance of the Visitor
        Visitor visitor = new Visitor("John", "Doe", 25, "Male", "V001");

        // Set the ticket type using the new setTicketType method
        visitor.setTicketType("Adult");

        // Add the Visitor instance to the ObserverSystem
        observerSystem.addObserver(visitor);

        // Trigger notification with a specific update type (e.g., UPDATE_TYPE_1)
        observerSystem.notifyObservers(Visitor.UPDATE_TYPE_1);

        // You can also perform other actions or test additional methods of the Visitor class
        System.out.println("Visitor details: " + visitor);
    }
}

