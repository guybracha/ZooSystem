package FinalProjectStudent;

import FinalProjectStudent.api.IObserver;
import FinalProjectStudent.api.IObserverSystem;
import com.google.gson.annotations.SerializedName;

/**
 * The {@code Employee} class represents an employee with various attributes,
 * including their first name, last name, age, gender, employee ID, department,
 * and salary.
 * It extends the {@link FinalProject.Person} class to inherit basic personal information.
 *
 * This class also implements the {@link IObserver} interface to be notified of changes
 * in the system through the {@link IObserverSystem}.
 */
public class Employee extends Person implements IObserver {

    @SerializedName("empID")
    private String employeeID;

    private String department;
    private double salary;

    /**
     * Constructs a new {@code Employee} with the specified attributes.
     *
     * @param firstName  The first name of the employee.
     * @param lastName   The last name of the employee.
     * @param age        The age of the employee.
     * @param gender     The gender of the employee.
     * @param employeeID The employee ID of the employee.
     * @param department The department in which the employee works.
     * @param salary     The salary of the employee.
     * @throws IllegalArgumentException if employeeID or department is null or empty.
     */
    public Employee(String firstName, String lastName, int age, String gender, String employeeID, String department, double salary) {
        super(firstName, lastName, age, gender, "");
        if (employeeID == null || employeeID.isEmpty() || department == null || department.isEmpty()) {
            throw new IllegalArgumentException("Employee ID and department cannot be null or empty.");
        }
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    /**
     * Gets the employee ID of the employee.
     *
     * @return The employee ID.
     */
    public String getEmployeeID() {
        return employeeID;
    }

    /**
     * Sets the employee ID of the employee.
     *
     * @param employeeID The employee ID to set.
     */
    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    /**
     * Gets the department in which the employee works.
     *
     * @return The department.
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Sets the department in which the employee works.
     *
     * @param department The department to set.
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * Gets the salary of the employee.
     *
     * @return The salary.
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Sets the salary of the employee.
     *
     * @param salary The salary to set.
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * Represents the performance of duties by the employee.
     * Implement specific duties logic in subclasses as needed.
     */
    public void performDuties() {
        // Implement employee's duties logic here
    }

    /**
     * {@inheritDoc}
     * <p>
     * This implementation prints a message indicating that the employee is taking action based on the notification.
     */
    public void update(int mode) {
        // Implement actions to be taken when the employee is notified
        System.out.println("Employee " + getFirstName() + " is taking action based on the notification.");
    }

	public void update(String task) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Object updateInfo) {
		// TODO Auto-generated method stub
		
	}
}
