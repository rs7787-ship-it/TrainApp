/**
 * UC18: Linear Search for Bogie ID
 * Demonstrates sequential searching through an unsorted array.
 */
public class TrainConsistApp {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App: UC18 ===");

        // 1. Array of registered Bogie IDs (Unsorted)
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        
        // 2. Define search keys (Target IDs)
        String target1 = "BG309"; // Existing ID
        String target2 = "BG999"; // Non-existent ID

        // 3. Perform Linear Search
        performLinearSearch(bogieIds, target1);
        performLinearSearch(bogieIds, target2);
    }

    /**
     * Linear Search Logic
     * Time Complexity: O(n)
     */
    public static void performLinearSearch(String[] arr, String key) {
        System.out.println("\nSearching for Bogie ID: " + key + "...");
        boolean found = false;

        // Traverse the array sequentially
        for (int i = 0; i < arr.length; i++) {
            // Check if current element matches the key
            if (arr[i].equals(key)) {
                System.out.println("Match Found! Bogie " + key + " located at position " + (i + 1));
                found = true;
                break; // Early Termination: Stop searching once found
            }
        }

        if (!found) {
            System.out.println("Search Result: Bogie ID " + key + " not found in the consist.");
        }
    }
}
