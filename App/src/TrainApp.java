import java.util.Arrays;

/**
 * UC20: Exception Handling During Search Operations
 * Demonstrates defensive programming by validating system state before execution.
 */
public class TrainConsistApp {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App: UC20 ===");

        // Scenario 1: Searching an empty train consist
        String[] emptyConsist = {};
        try {
            System.out.println("Attempting to search in an empty consist...");
            searchBogie(emptyConsist, "BG101");
        } catch (IllegalStateException e) {
            System.out.println("CAUGHT EXCEPTION: " + e.getMessage());
        }

        // Scenario 2: Searching a valid train consist
        String[] validConsist = {"BG101", "BG205", "BG309"};
        try {
            System.out.println("\nAttempting to search in a valid consist...");
            searchBogie(validConsist, "BG205");
        } catch (IllegalStateException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    /**
     * Validates state and searches for a Bogie ID.
     * @throws IllegalStateException if the consist is empty.
     */
    public static void searchBogie(String[] consist, String targetId) {
        // 1. State Validation (Defensive Check)
        if (consist == null || consist.length == 0) {
            throw new IllegalStateException("Search Operation Failed: No bogies are currently in the train consist.");
        }

        // 2. Search Logic (Binary Search as per UC19)
        Arrays.sort(consist); // Ensure sorted for Binary Search
        int index = Arrays.binarySearch(consist, targetId);

        if (index >= 0) {
            System.out.println("SUCCESS: Bogie " + targetId + " found at position " + (index + 1));
        } else {
            System.out.println("RESULT: Bogie " + targetId + " not found in the consist.");
        }
    }
}
