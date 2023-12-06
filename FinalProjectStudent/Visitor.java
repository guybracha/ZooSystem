package FinalProjectStudent;

import FinalProjectStudent.ObserverSystem;
import FinalProjectStudent.Person;
import FinalProjectStudent.api.IObserver;
import FinalProjectStudent.api.IObserverSystem;

/**
 * The {@code Visitor} class represents a visitor at a zoo.
 * It stores information about the visitor, including their name, age, and ticket type.
 * This class is part of the observer pattern, serving as an observer alongside AnimalHandler,
 * Employee, and Veterinarian.
 */

public final class Visitor extends Person implements IObserver {

    private String ticketType;
    // Define constants for update types
    public static final int UPDATE_TYPE_1 = 1;
    public static final int UPDATE_TYPE_2 = 2;
    
    /**
     * Constructs a new {@code Visitor} with the specified attributes.
     *
     * @param firstName  The first name of the visitor.
     * @param lastName   The last name of the visitor.
     * @param age        The age of the visitor.
     * @param gender     The gender of the visitor.
     * @param visitorID  The unique ID of the visitor.
     */
    public Visitor(String firstName, String lastName, int age, String gender, String visitorID) {
        super(firstName, lastName, age, gender, visitorID);
        // Additional Visitor-specific attributes or logic can be added here
    }

    /**
     * Sets the type of ticket for the visitor.
     *
     * @param ticketType The type of ticket (e.g., "Adult," "Child").
     */
    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }


    /**
     * Gets the type of ticket held by the visitor.
     *
     * @return The ticket type of the visitor (e.g., "Adult," "Child").
     */
    public String getTicketType() {
        return ticketType;
    }

    /**
     * Returns a string representation of the {@code Visitor} object.
     *
     * @return A string representation including the name, age, and ticket type of the visitor.
     */
    @Override
    public String toString() {
        return "Visitor{" +
                "ticketType= '" + ticketType + '\'' +
                '}';
    }
    public void update(IObserverSystem observerSystem, int updateInfo) {
        // Handle the update based on the provided information
        // You can implement specific logic based on your requirements

        // Example: Check the updateInfo and perform corresponding actions
        if (updateInfo == UPDATE_TYPE_1) {
            // Handle update type 1
        } else if (updateInfo == UPDATE_TYPE_2) {
            // Handle update type 2
        }

        System.out.println("Visitor updated: " + updateInfo);
    }

	@Override
	public void update(Object updateInfo) {
		// TODO Auto-generated method stub
		
	}
}
