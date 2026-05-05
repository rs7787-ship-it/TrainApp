import java.util.LinkedList;

/**
 * UC4: Maintain Ordered Train Consist
 * Demonstrates how LinkedList models the physical chaining of a train.
 */
public class TrainConsistApp {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App: UC4 ===");

        // 1. Initialize a LinkedList
        // LinkedList is ideal for frequently adding/removing from the ends or middle.
        LinkedList<String> trainConsist = new LinkedList<>();

        // 2. Add Bogies to form the initial sequence
        trainConsist.add("Engine");
        trainConsist.add("Sleeper");
        trainConsist.add("AC Coach");
        trainConsist.add("Cargo");
        trainConsist.add("Guard");

        System.out.println("Initial Consist: " + trainConsist);

        // 3. Middle Insertion (Adding a Pantry Car)
        // We insert at index 2 (between Sleeper and AC Coach)
        System.out.println("\nAdding Pantry Car at position 2...");
        trainConsist.add(2, "Pantry Car");
        System.out.println("Updated Consist: " + trainConsist);

        // 4. Detaching from ends (removeFirst and removeLast)
        // Simulate removing the Engine and the Guard coach for maintenance
        System.out.println("\nRemoving the Engine (Head) and Guard (Tail)...");
        trainConsist.removeFirst();
        trainConsist.removeLast();

        // 5. Final ordered display
        System.out.println("Final Physical Consist: " + trainConsist);
        System.out.println("Total Bogies remaining: " + trainConsist.size());
    }
}
