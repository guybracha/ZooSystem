package FinalProjectStudent;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
import java.util.List;
/**
 * The {@code DataImport} class provides methods for importing various data types from JSON files.
 * It utilizes the Gson library for JSON parsing and deserialization.
 * src info:
 * <a href="https://stackoverflow.com/questions/10926353/how-to-read-json-file-into-java-with-simple-json-library"</a>
 */
public class DataImport {
	  /**
     * Imports data of a specified type from a JSON file.
     *
     * @param jsonFilePath The path to the JSON file.
     * @param type         The type of data to import.
     * @param <T>          The generic type of data.
     * @return The imported data or null if an error occurs.
     */
    private static <T> T importData(String jsonFilePath, Type type) {
        try {
            Gson gson = new Gson();
            return gson.fromJson(new FileReader(jsonFilePath), type);
        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found - " + jsonFilePath);
        } catch (JsonSyntaxException e) {
            System.err.println("Error: Invalid JSON syntax in file - " + jsonFilePath);
        } catch (Exception e) {
            System.err.println("Error importing data from file - " + jsonFilePath);
            e.printStackTrace();
        }
        return null;
    }
    /**
     * Imports a list of data of a specified type from a JSON file.
     *
     * @param jsonFilePath The path to the JSON file.
     * @param type         The type of data to import.
     * @param <T>          The generic type of data.
     * @return The imported list of data or null if an error occurs.
     */
    private static <T> List<T> importListData(String jsonFilePath, Type type) {
        try {
            Gson gson = new Gson();
            return gson.fromJson(new FileReader(jsonFilePath), type);
        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found - " + jsonFilePath);
        } catch (JsonSyntaxException e) {
            System.err.println("Error: Invalid JSON syntax in file - " + jsonFilePath);
        } catch (Exception e) {
            System.err.println("Error importing data from file - " + jsonFilePath);
            e.printStackTrace();
        }
        return null;
    }
    /**
     * Imports a list of {@code Animal} objects from a JSON file.
     *
     * @param jsonFilePath The path to the JSON file.
     * @return The imported list of animals or null if an error occurs.
     */
    public static List<Animal> importAnimalData(String jsonFilePath) {
        Type animalListType = new TypeToken<List<Animal>>() {}.getType();
        return importListData(jsonFilePath, animalListType);
    }
    /**
     * Imports a {@code Zoo} object from a JSON file.
     *
     * @param jsonFilePath The path to the JSON file.
     * @return The imported zoo or null if an error occurs.
     */
    public static Zoo importZooData(String jsonFilePath) {
        Type zooType = new TypeToken<Zoo>() {}.getType();
        return importData(jsonFilePath, zooType);
    }
    /**
     * Imports a {@code Employee} object from a JSON file.
     *
     * @param jsonFilePath The path to the JSON file.
     * @return The imported list of Employees or null if an error occurs.
     */

    public static List<Employee> importEmployeeData(String filePath) {
        try (FileReader reader = new FileReader(filePath)) {
            Gson gson = new Gson();
            Type employeeListType = new TypeToken<List<Employee>>() {}.getType();
            List<Employee> employees = gson.fromJson(reader, employeeListType);
            System.out.println("Employee data imported successfully.");
            return employees;
        } catch (IOException e) {
            System.out.println("Error importing employee data from file - " + filePath);
            e.printStackTrace();
            return null;
        }
    }
    /**
     * Imports a {@code Visitors} object from a JSON file.
     *
     * @param jsonFilePath The path to the JSON file.
     * @return The imported list of Visitors or null if an error occurs.
     */

    public static List<Visitor> importVisitorData(String jsonFilePath) {
        Type visitorListType = new TypeToken<List<Visitor>>() {}.getType();
        return importListData(jsonFilePath, visitorListType);
    }
    /**
     * Imports a {@code Enclosure} object from a JSON file.
     *
     * @param jsonFilePath The path to the JSON file.
     * @return The imported list of Enclosures or null if an error occurs.
     */

    public static List<Enclosure> importEnclosureData(String jsonFilePath) {
        Type enclosureListType = new TypeToken<List<Enclosure>>() {}.getType();
        return importListData(jsonFilePath, enclosureListType);
    }
    /**
     * Imports a {@code Manager} object from a JSON file.
     *
     * @param jsonFilePath The path to the JSON file.
     * @return The imported list of Managers or null if an error occurs.
     */
    public static List<Manager> importManagerData(String jsonFilePath) {
        Type managerListType = new TypeToken<List<Manager>>() {}.getType();
        return importListData(jsonFilePath, managerListType);
    }
    // Add more methods as needed for additional data types
    /**
     * Example main method demonstrating the usage of DataImport.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        // Example usage:
        String enclosureJsonFileName = "data/enclosure.json";
        List<Enclosure> enclosures = importEnclosureData(enclosureJsonFileName);

        if (enclosures != null) {
            System.out.println("Imported Enclosures:");
            for (Enclosure enclosure : enclosures) {
                System.out.println(enclosure);
            }
        } else {
            System.out.println("Failed to import enclosure data.");
        }
    }
}
