import java.util.ArrayList;
import java.util.List;

/**
 * UC10: Count Total Seats in Train
 * Demonstrates Stream map-reduce pattern to aggregate numeric data.
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
        return name + " (" + capacity + ")";
    }
}

public class TrainConsistApp {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App: UC10 ===");

        // 1. Initialize the train consist
        List<Bogie> trainConsist = new ArrayList<>();
        trainConsist.add(new Bogie("Sleeper", 72));
        trainConsist.add(new Bogie("AC Chair", 56));
        trainConsist.add(new Bogie("Sleeper", 72));
        trainConsist.add(new Bogie("First Class", 24));
        trainConsist.add(new Bogie("General", 90));

        System.out.println("Current Consist: " + trainConsist);

        // 2. Map-Reduce Pipeline
        // Step 1: stream() - Put bogies on the conveyor
        // Step 2: map() - Extract only the capacity (Integer) from the Bogie object
        // Step 3: reduce() - Sum them up starting from 0 (Identity)
        int totalSeats = trainConsist.stream()
                .map(b -> b.capacity)           // Transformation
                .reduce(0, Integer::sum);      // Aggregation

        // 3. Display the total numeric insight
        System.out.println("\n--- Operational Summary ---");
        System.out.println("Total Passenger Bogies: " + trainConsist.size());
        System.out.println("Total Seating Capacity: " + totalSeats + " seats");

        // 4. Verify original list integrity
        System.out.println("\nVerification: Original list size is still " + trainConsist.size());
    }
}
