import java.util.HashSet;
import java.util.Set;

/**
 * UC3: Track Unique Bogie IDs
 * Demonstrates the use of HashSet to prevent duplicate bogie registrations.
 */
public class TrainConsistApp {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App: UC3 ===");

        // 1. Initialize a HashSet to store unique Bogie IDs
        // Set is the interface; HashSet is the concrete implementation.
        Set<String> bogieIds = new HashSet<>();

        // 2. Adding Bogie IDs
        System.out.println("Registering bogies in the system...");
        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG103");

        // 3. Attempting to add a duplicate Bogie ID
        // The system should automatically reject this.
        System.out.println("Attempting to add duplicate ID: BG101");
        boolean isAdded = bogieIds.add("BG101"); 

        if (!isAdded) {
            System.out.println("Registration Failed: Bogie ID 'BG101' already exists!");
        }

        // 4. Display the unique IDs
        // Note: HashSet does not guarantee the order of elements.
        System.out.println("\nFinal List of Unique Registered Bogie IDs:");
        System.out.println(bogieIds);
        
        System.out.println("Total Unique Bogies: " + bogieIds.size());
    }
}
