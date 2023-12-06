package FinalProjectStudent.test;

import FinalProjectStudent.Manager;

/**
 * The {@code ManagerTest} class serves as a test class for the {@link FinalProjectStudent.Manager} class.
 */
public class ManagerTest {
    /**
     * The main method for testing the Manager class.
     *
     * @param args The command line arguments (not used in this example).
     */
    public static void main(String[] args) {
        // Create a manager instance
        Manager manager = new Manager("John", "Doe", 35, "Male", "M001", "Zoo Department", 75000.0, "Operations");

        // Display information about the manager
        System.out.println("Manager Information:");
        displayManagerInfo(manager);

        // Set the department managed for the manager
        manager.setDepartmentManaged("Animals");

        // Display updated information about the manager
        System.out.println("\nUpdated Manager Information:");
        displayManagerInfo(manager);

        // Simulate a notification to the manager
        manager.notifyObserver(1);
    }

    /**
     * Displays information about the manager.
     *
     * @param manager The manager to display information about.
     */
    private static void displayManagerInfo(Manager manager) {
        System.out.println("Name: " + manager.getFirstName() + " " + manager.getLastName());
        System.out.println("Age: " + manager.getAge());
        System.out.println("Gender: " + manager.getGender());
        System.out.println("Employee ID: " + manager.getEmployeeID());
        System.out.println("Department: " + manager.getDepartmentManaged());
        System.out.println("Salary: " + manager.getSalary());
    }
}
