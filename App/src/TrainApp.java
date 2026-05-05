import java.util.ArrayList;
import java.util.List;

/**
 * UC2: Add Passenger Bogies to Train
 * Demonstrates CRUD operations: Adding, removing, and searching within an ArrayList.
 */
public class TrainConsistApp {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App: UC2 ===");

        // 1. Initialize the list
        List<String> passengerBogies = new ArrayList<>();

        // 2. Add Bogies (Create)
        // ArrayList maintains "Insertion Order" - the order we add them is the order they appear.
        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        System.out.println("After adding bogies: " + passengerBogies);
        System.out.println("Total Bogie Count: " + passengerBogies.size());

        // 3. Remove a Bogie (Delete)
        // We simulate uncoupling the "AC Chair" bogie.
        System.out.println("\nRemoving AC Chair bogie...");
        passengerBogies.remove("AC Chair");

        // 4. Check Existence (Search)
        // We verify if the "Sleeper" bogie is still part of the consist.
        System.out.println("Is Sleeper bogie present? " + passengerBogies.contains("Sleeper"));
        System.out.println("Is AC Chair bogie present? " + passengerBogies.contains("AC Chair"));

        // 5. Final Consist Summary (Read)
        System.out.println("\nFinal Train Consist: " + passengerBogies);
        System.out.println("Final Bogie Count: " + passengerBogies.size());
    }
}
