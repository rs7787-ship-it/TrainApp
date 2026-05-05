import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * UC7: Sort Bogies by Capacity
 * Demonstrates the use of custom Objects and the Comparator interface.
 */

// 1. Create a Bogie class to hold complex data
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
        System.out.println("=== Train Consist Management App: UC7 ===");

        // 2. Create a List of Bogie objects
        List<Bogie> passengerBogies = new ArrayList<>();
        
        // 3. Add bogies with different capacities
        passengerBogies.add(new Bogie("Sleeper", 72));
        passengerBogies.add(new Bogie("AC Chair Car", 56));
        passengerBogies.add(new Bogie("First Class", 24));
        passengerBogies.add(new Bogie("General", 90));

        System.out.println("Initial Consist (Unsorted): " + passengerBogies);

        // 4. Use a Comparator to sort by capacity (Ascending)
        // We use a Lambda expression to tell Java how to compare two Bogie objects
        passengerBogies.sort(Comparator.comparingInt(b -> b.capacity));
        System.out.println("\nSorted by Capacity (Lowest to Highest):");
        passengerBogies.forEach(System.out::println);

        // 5. Sorting by capacity (Descending)
        // Useful for finding the highest capacity bogies first
        passengerBogies.sort(Comparator.comparingInt((Bogie b) -> b.capacity).reversed());
        System.out.println("\nSorted by Capacity (Highest to Lowest):");
        passengerBogies.forEach(System.out::println);
    }
}
