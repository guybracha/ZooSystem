package FinalProjectStudent.test;

import FinalProjectStudent.Employee;
import FinalProjectStudent.ObserverSystem;
import FinalProjectStudent.api.IObserverSystem;

/**
 * The {@code EmployeeTest} class serves as a test class for the {@link FinalProjectStudent.Employee} class.
 */
public class EmployeeTest {
    /**
     * The main method for testing the Employee class.
     *
     * @param args The command line arguments (not used in this example).
     */
    public static void main(String[] args) {
        // Create an employee
        Employee employee = new Employee("John", "Doe", 30, "Male", "E001", "Human Resources", 60000.0);

        // Display information about the employee
        System.out.println("Initial Employee Information:");
        displayEmployeeInfo(employee);

        // Set department and salary for the employee
        employee.setDepartment("Finance");
        employee.setSalary(65000.0);

        // Display updated information about the employee
        System.out.println("\nUpdated Employee Information:");
        displayEmployeeInfo(employee);

        // Simulate an update from the ObserverSystem
        IObserverSystem observerSystem = new ObserverSystem();
        observerSystem.addObserver(employee);
        observerSystem.notifyObservers(ObserverSystem.TASK_MODE);

        // Note: In a real application, the ObserverSystem would be responsible for managing observers and notifications.
    }

    /**
     * Displays information about the employee.
     *
     * @param employee The employee to display information about.
     */
    private static void displayEmployeeInfo(Employee employee) {
        System.out.println("Name: " + employee.getFirstName() + " " + employee.getLastName());
        System.out.println("Age: " + employee.getAge());
        System.out.println("Gender: " + employee.getGender());
        System.out.println("Employee ID: " + employee.getEmployeeID());
        System.out.println("Department: " + employee.getDepartment());
        System.out.println("Salary: " + employee.getSalary());
    }
}

