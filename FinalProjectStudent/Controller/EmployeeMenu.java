package FinalProjectStudent.Controller;

import FinalProjectStudent.DataImport;
import FinalProjectStudent.Employee;

import java.util.List;
import java.util.Scanner;
/**
 * The {@code EmployeeMenu} class provides a menu-driven interface for managing employees in the zoo.
 * Users can display, add, and remove employees through various menu options.
 */
public class EmployeeMenu {

    public static void employeeMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Employee Menu");
            System.out.println("1. Display Employees");
            System.out.println("2. Add Employee");
            System.out.println("3. Remove Employee");
            System.out.println("4. Return to Main Menu");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    displayEmployees();
                    break;
                case 2:
                    addEmployee();
                    break;
                case 3:
                    removeEmployee();
                    break;
                case 4:
                    System.out.println("Returning to Main Menu");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

        } while (choice != 4);
    }

    private static void displayEmployees() {
        // Use DataImport to import employee data from "data/employee.json"
        List<Employee> employees = DataImport.importEmployeeData("data/employee.json");

        if (employees != null && !employees.isEmpty()) {
            System.out.println("Displaying Employees:");
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        } else {
            System.out.println("No employee data available.");
        }
    }

    private static void addEmployee() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter employee details:");

        System.out.print("First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Gender: ");
        String gender = scanner.nextLine();

        System.out.print("Employee ID: ");
        String employeeID = scanner.nextLine();

        System.out.print("Department: ");
        String department = scanner.nextLine();

        System.out.print("Salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character

        // Create an Employee object with the gathered information
        Employee newEmployee = new Employee(firstName, lastName, age, gender, employeeID, department, salary);

        // Add the new employee to your data structure (e.g., a list)
        List<Employee> employees = DataImport.importEmployeeData("data/employee.json");
        employees.add(newEmployee);

        // Save the updated list back to the file (You may need to implement this)
        // DataExport.exportEmployeeData("data/employee.json", employees);

        System.out.println("New employee added successfully.");
    }

    private static void removeEmployee() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter employee ID to remove: ");
        String employeeIDToRemove = scanner.nextLine();

        List<Employee> employees = DataImport.importEmployeeData("data/employee.json");

        // Find the employee with the specified ID
        Employee employeeToRemove = null;
        for (Employee employee : employees) {
            if (employee.getEmployeeID().equals(employeeIDToRemove)) {
                employeeToRemove = employee;
                break;
            }
        }

        // Remove the employee if found
        if (employeeToRemove != null) {
            employees.remove(employeeToRemove);

            // Save the updated list back to the file (You may need to implement this)
            // DataExport.exportEmployeeData("data/employee.json", employees);

            System.out.println("Employee removed successfully.");
        } else {
            System.out.println("Employee with ID " + employeeIDToRemove + " not found.");
        }
    }
}
