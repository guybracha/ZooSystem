package FinalProjectStudent;

import java.util.HashSet;
import java.util.Set;
import FinalProjectStudent.DataImport;

public class ZooStatistics {
	public static void displayStatistics(Zoo zoo) {
		
		/**
		 * @param totalAnimals from the zoo class.
		 * @param speciesSet.
		 * @return the total amount of animals in the zoo, total number of sick animals, average age and weight.
		 * */
        System.out.println("Zoo Statistics:");

        // Total number of animals
        int totalAnimals = zoo.getAnimals().size();
        System.out.println("Total number of animals: " + totalAnimals);

        // Number of species
        Set<String> speciesSet = new HashSet<>();
        for (Animal animal : zoo.getAnimals()) {
            speciesSet.add(animal.getSpecies());
        }
        int totalSpecies = speciesSet.size();
        System.out.println("Total number of species: " + totalSpecies);

        // Number of existing enclosures
        int totalEnclosures = zoo.getEnclosureMap().size();
        System.out.println("Total number of enclosures: " + totalEnclosures);

        // Average age of animals
        double averageAge = calculateAverageAge(zoo);
        System.out.println("Average age of animals: " + averageAge + " months");

        // Average weight of animals
        double averageWeight = calculateAverageWeight(zoo);
        System.out.println("Average weight of animals: " + averageWeight + " kg");

        // Animal amount for each enclosure
        System.out.println("Animal count in each enclosure:");
        for (Enclosure enclosure : zoo.getEnclosureMap().values()) {
            int animalCount = enclosure.getAnimals().size();
            System.out.println("Enclosure " + enclosure.getEnclosureName() + ": " + animalCount + " animals");
        }

        // Number of sick animals or animals needing medical treatment
        int sickAnimalCount = countSickAnimals(zoo);
        System.out.println("Number of sick animals: " + sickAnimalCount);
    }
	// Calculate and returning the average age of the animals at the zoo.
    private static double calculateAverageAge(Zoo zoo) {
        if (zoo.getAnimals().isEmpty()) {
            return 0.0;
        }

        int totalAge = 0;
        for (Animal animal : zoo.getAnimals()) {
            totalAge += animal.getAgeMonths();
        }

        return (double) totalAge / zoo.getAnimals().size();
    }
	// Calculacte and returning the average weight of the animals at the zoo.
    private static double calculateAverageWeight(Zoo zoo) {
        if (zoo.getAnimals().isEmpty()) {
            return 0.0;
        }

        double totalWeight = 0.0;
        for (Animal animal : zoo.getAnimals()) {
            totalWeight += animal.getWeight();
        }

        return totalWeight / zoo.getAnimals().size();
    }
    // finding out how many animals are sick right now.
    private static int countSickAnimals(Zoo zoo) {
        int sickAnimalCount = 0;
        for (Animal animal : zoo.getAnimals()) {
            if (!animal.isHealthy()) {
                sickAnimalCount++;
            }
        }
        return sickAnimalCount;
    }
}
