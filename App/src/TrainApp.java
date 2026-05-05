import java.util.LinkedHashSet;
import java.util.Set;

/**
 * UC5: Preserve Insertion Order while ensuring Uniqueness
 * Demonstrates LinkedHashSet to maintain a unique, ordered train formation.
 */
public class TrainConsistApp {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App: UC5 ===");

        // 1. Initialize a LinkedHashSet
        // This ensures every bogie is unique AND stays in the order it was added.
        Set<String> trainFormation = new LinkedHashSet<>();

        // 2. Attach bogies in a specific sequence
        System.out.println("Attaching bogies to the engine...");
        trainFormation.add("Engine");
        trainFormation.add("Sleeper");
        trainFormation.add("Cargo");
        trainFormation.add("Guard");

        // 3. Attempt to add a duplicate bogie
        // In a real yard, you can't attach the same physical bogie twice.
        System.out.println("Attempting to attach duplicate: Sleeper");
        boolean isAdded = trainFormation.add("Sleeper");

        if (!isAdded) {
            System.out.println("Alert: Bogie 'Sleeper' is already part of the formation. Duplicate ignored.");
        }

        // 4. Display the formation
        // Notice that unlike HashSet, the order here is guaranteed to be:
        // Engine -> Sleeper -> Cargo -> Guard
        System.out.println("\nFinal Train Formation (Ordered & Unique):");
        System.out.println(trainFormation);

        // 5. Verification of count
        System.out.println("Total Bogies in Formation: " + trainFormation.size());
    }
}
