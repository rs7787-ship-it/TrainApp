import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * UC8: Filter Passenger Bogies Using Streams
 * Demonstrates functional-style filtering to find bogies meeting specific criteria.
 */
class Bogie {
    String name;
    int capacity;

    public Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return name + " (" + capacity + " seats)";
    }
}

public class TrainConsistApp {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App: UC8 ===");

        // 1. Initialize the list (as done in UC7)
        List<Bogie> passengerBogies = new ArrayList<>();
        passengerBogies.add(new Bogie("Sleeper", 72));
        passengerBogies.add(new Bogie("AC Chair Car", 56));
        passengerBogies.add(new Bogie("First Class", 24));
        passengerBogies.add(new Bogie("General", 90));

        System.out.println("All available bogies: " + passengerBogies);

        // 2. Apply Stream Filtering
        // Goal: Find high-capacity bogies (Capacity > 60)
        int threshold = 60;
        System.out.println("\nFiltering bogies with capacity > " + threshold + "...");

        List<Bogie> highCapacityBogies = passengerBogies.stream() // Convert list to Stream
                .filter(b -> b.capacity > threshold)            // Apply filtering logic
                .collect(Collectors.toList());                  // Collect results into a new list

        // 3. Display the results
        if (highCapacityBogies.isEmpty()) {
            System.out.println("No bogies match the criteria.");
        } else {
            System.out.println("High Capacity Bogies: " + highCapacityBogies);
        }

        // 4. Verify Integrity (Original list should be unchanged)
        System.out.println("\nVerification - Original list size: " + passengerBogies.size());
    }
}
