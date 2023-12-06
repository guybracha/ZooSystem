package FinalProjectStudent;

import java.util.ArrayList;
import java.util.List;

import FinalProjectStudent.api.IObserver;
import FinalProjectStudent.api.IObserverSystem;

/**
 * The {@code Manager} class represents a manager who is an employee responsible for overseeing
 * operations in a department or section of a zoo.
 * Concrete Observer of IObserverSystem.
 * Src info:
 * <a href="https://www.youtube.com/watch?v=_BpmfnqjgzQ"</a>
 * <a href="https://www.tutorialspoint.com/design_pattern/observer_pattern.htm"</a>
 * <a href="https://www.geeksforgeeks.org/observer-pattern-set-1-introduction/"</a>
 * <a href="https://www.geeksforgeeks.org/observer-pattern-set-2-implementation/"</a>
 */
public class Manager extends Person implements IObserverSystem {
    private String departmentManaged;
    private double salary;
    private List<IObserver> observers = new ArrayList<>();

    /**
     * Constructs a new {@code Manager} with the specified attributes.
     *
     * @param firstName         The first name of the manager.
     * @param lastName          The last name of the manager.
     * @param age               The age of the manager.
     * @param gender            The gender of the manager.
     * @param employeeID        The unique ID of the manager as an employee.
     * @param department        The department in which the manager works.
     * @param salary            The salary of the manager.
     * @param departmentManaged The department or section managed by the manager.
     */
    public Manager(String firstName, String lastName, int age, String gender, String employeeID, String department, double salary, String departmentManaged) {
        super(firstName, lastName, age, gender, employeeID);
        this.salary = salary;
        this.departmentManaged = departmentManaged;
    }


	/**
     * Gets the department or section managed by the manager.
     *
     * @return The department or section managed by the manager.
     */
    public String getDepartmentManaged() {
        return departmentManaged;
    }

    public String getManagerFirstName() {
        return getFirstName();
    }
    /**
     * Sets the department or section managed by the manager.
     *
     * @param departmentManaged The department or section to be managed by the manager.
     */
    public void setDepartmentManaged(String departmentManaged) {
        this.departmentManaged = departmentManaged;
    }
    
 // Access employeeID in Manager
    public String getEmployeeIDInManager() {
        return getEmployeeID();
    }

    /**
     * Manages department-specific operations and tasks as per the manager's responsibilities.
     */
    public void manageDepartment() {
        // Implement department management logic here
    }

    @Override
    public void addObserver(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(IObserver observer) {
        observers.remove(observer);
    }

    public void notifyObserver(int mode) {
        System.out.println("Manager " + getFirstName() + " has been notified.");
        update(this, mode); // Pass relevant information (this and mode) to the update method
    }
    
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void update(IObserverSystem subject, int mode) {
        // Implement actions to be taken when the manager is notified
        System.out.println("Manager " + getFirstName() + " is taking action based on the notification. Mode: " + mode);
    }

    @Override
    public void update(String task) {
        // Implement actions to be taken when the manager is notified with a task
        System.out.println("Manager " + getFirstName() + " is taking action based on the task: " + task);
    }

    @Override
    public void update(Object updateInfo) {
        // Implement actions to be taken when the manager is notified with generic update info
        System.out.println("Manager " + getFirstName() + " is taking action based on generic update info: " + updateInfo);
    }


	@Override
	public void notifyObservers(int mode) {
		// TODO Auto-generated method stub
		
	}

}
