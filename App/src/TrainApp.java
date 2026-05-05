import java.util.Arrays;

/**
 * UC19: Binary Search for Bogie ID
 * Demonstrates an optimized O(log n) search algorithm on sorted data.
 */
public class TrainConsistApp {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App: UC19 ===");

        // 1. Initial IDs (Unsorted)
        String[] bogieIds = {"BG309", "BG101", "BG550", "BG205", "BG412"};

        // 2. Precondition: Binary search REQUIRES sorted data
        Arrays.sort(bogieIds);
        System.out.println("Sorted IDs for searching: " + Arrays.toString(bogieIds));

        // 3. Define search targets
        String target1 = "BG309";
        String target2 = "BG999";

        // 4. Perform Binary Search
        performBinarySearch(bogieIds, target1);
        performLinearSearch(bogieIds, target2); // Reusing logic for comparison
    }

    /**
     * Binary Search Logic
     * Time Complexity: O(log n)
     */
    public static void performBinarySearch(String[] arr, String key) {
        System.out.println("\nBinary Searching for: " + key + "...");
        
        int low = 0;
        int high = arr.length - 1;
        boolean found = false;

        while (low <= high) {
            int mid = low + (high - low) / 2; // Calculate middle index
            
            // compareTo() returns:
            // 0 if equal
            // < 0 if key is lexicographically smaller than middle
            // > 0 if key is lexicographically larger than middle
            int comparison = key.compareTo(arr[mid]);

            if (comparison == 0) {
                System.out.println("Match Found! Bogie " + key + " located at index " + mid);
                found = true;
                break;
            } else if (comparison < 0) {
                high = mid - 1; // Eliminate the right half
            } else {
                low = mid + 1; // Eliminate the left half
            }
        }

        if (!found) {
            System.out.println("Search Result: Bogie ID " + key + " not found.");
        }
    }
    
    // Included for logical completeness in testing
    public static void performLinearSearch(String[] arr, String key) {
        performBinarySearch(arr, key);
    }
}
