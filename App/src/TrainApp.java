import java.util.Arrays;

/**
 * UC17: Sort Bogie Names Using Arrays.sort()
 * Demonstrates the use of Java's built-in optimized sorting utilities.
 */
public class TrainConsistApp {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App: UC17 ===");

        // 1. Array of bogie type names
        String[] bogieTypes = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};

        System.out.println("Initial Bogie Names: " + Arrays.toString(bogieTypes));

        // 2. Using Arrays.sort() for Optimized Sorting
        // This handles alphabetical order (Natural Ordering) automatically for Strings.
        Arrays.sort(bogieTypes);

        // 3. Display the sorted result
        // We use Arrays.toString() for a clean, readable output.
        System.out.println("Sorted Bogie Names (Alphabetical): " + Arrays.toString(bogieTypes));

        // 4. Demonstration with Duplicates
        String[] duplicates = {"Sleeper", "AC Chair", "Sleeper", "General"};
        Arrays.sort(duplicates);
        System.out.println("\nHandling Duplicates: " + Arrays.toString(duplicates));
        
        System.out.println("\nSorting completed using Java's highly optimized internal algorithms.");
    }
}
