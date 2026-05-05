import java.util.HashMap;
import java.util.Map;

/**
 * UC6: Map Bogie to Capacity
 * Demonstrates the use of HashMap to associate bogies with their seat/load capacities.
 */
public class TrainConsistApp {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App: UC6 ===");

        // 1. Initialize a HashMap
        // Key: String (Bogie Type), Value: Integer (Capacity)
        Map<String, Integer> bogieCapacities = new HashMap<>();

        // 2. Map bogies to their respective capacities (Key-Value Association)
        // This is the "Put" operation
        bogieCapacities.put("Sleeper", 72);
        bogieCapacities.put("AC Chair Car", 56);
        bogieCapacities.put("First Class", 24);
        bogieCapacities.put("General", 90);

        System.out.println("Bogie-Capacity mapping successfully created.\n");

        // 3. Display individual lookup
        // HashMap provides near-instant retrieval using the key
        String searchBogie = "Sleeper";
        System.out.println("Capacity lookup for " + searchBogie + ": " + bogieCapacities.get(searchBogie) + " seats");

        // 4. Iterate over the entire mapping
        // We use entrySet() to access both the Key and the Value simultaneously
        System.out.println("\n--- Full Consist Capacity Report ---");
        for (Map.Entry<String, Integer> entry : bogieCapacities.entrySet()) {
            System.out.println("Bogie Type: " + entry.getKey() + " | Capacity: " + entry.getValue() + " units");
        }

        // 5. Demonstrating how a HashMap handles updates
        // Adding the same key again updates the existing value
        bogieCapacities.put("First Class", 22); // Updated capacity
        System.out.println("\nUpdated First Class Capacity: " + bogieCapacities.get("First Class"));
    }
}
