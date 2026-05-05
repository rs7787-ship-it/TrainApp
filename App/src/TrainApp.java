/**
 * UC16: Sort Passenger Bogies by Capacity
 * Demonstrates the Bubble Sort algorithm without using built-in library methods.
 */
public class TrainConsistApp {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App: UC16 ===");

        // 1. Array of passenger bogie capacities
        int[] capacities = {72, 56, 24, 70, 60};

        System.out.print("Initial Capacities: ");
        printArray(capacities);

        // 2. Bubble Sort Algorithm
        // Outer loop handles the number of passes
        int n = capacities.length;
        for (int i = 0; i < n - 1; i++) {
            // Inner loop compares adjacent elements
            for (int j = 0; j < n - i - 1; j++) {
                // If the left element is greater than the right, swap them
                if (capacities[j] > capacities[j + 1]) {
                    // Swapping Logic using a temporary variable
                    int temp = capacities[j];
                    capacities[j] = capacities[j + 1];
                    capacities[j + 1] = temp;
                }
            }
        }

        // 3. Display the sorted result
        System.out.print("Sorted Capacities (Bubble Sort): ");
        printArray(capacities);
        
        System.out.println("\nAlgorithm completed using manual adjacent swapping.");
    }

    /**
     * Helper method to display array contents
     */
    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i == arr.length - 1 ? "" : ", "));
        }
        System.out.println("]");
    }
}
