package FinalProjectStudent;

import FinalProjectStudent.Employee;
import FinalProjectStudent.ObserverSystem;
import FinalProjectStudent.api.IObserver;
import FinalProjectStudent.api.IObserverSystem;

/**
 * The {@code Veterinarian} class represents a veterinarian who is an employee responsible for
 * providing medical care and treatment to animals in a zoo.
 */
public final class Veterinarian extends Employee implements IObserver {
    private String specialization;


    /**
     * Constructs a new {@code Veterinarian} with the specified attributes.
     *
     * @param firstName       The first name of the veterinarian.
     * @param lastName        The last name of the veterinarian.
     * @param age             The age of the veterinarian.
     * @param gender          The gender of the veterinarian.
     * @param employeeID      The unique ID of the veterinarian as an employee.
     * @param department      The department in which the veterinarian works.
     * @param salary          The salary of the veterinarian.
     * @param specialization  The medical specialization of the veterinarian (e.g., "Wildlife Medicine," "Exotic Animals").
     */
    public Veterinarian(String firstName, String lastName, int age, String gender,
            String employeeID, String department, double salary, String specialization) {
        super(firstName, lastName, age, gender, employeeID, department, salary);
        this.specialization = specialization;
    }


    /**
     * Gets the medical specialization of the veterinarian.
     *
     * @return The medical specialization of the veterinarian.
     */
    public String getSpecialization() {
        return specialization;
    }

    /**
     * Sets the medical specialization of the veterinarian.
     *
     * @param specialization The medical specialization to set for the veterinarian.
     */
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    /**
     * Provides medical care and treatment to animals based on the veterinarian's specialization.
     */
    public void provideMedicalCare() {
        // Implement medical care logic based on specialization
    }
    
    public void update(IObserverSystem subject, int mode) {
        // Implement actions to be taken when notified by the manager
        System.out.println("Veterinarian " + getFirstName() + " received a task notification.");
        // Perform specific actions based on the mode or task
    }


}
