import java.util.ArrayList;
import java.util.List;

/**
 * UC1: Initialize Train and Display Consist Summary
 * This class serves as the entry point for the Train Consist Management App.
 */
public class TrainConsistApp {

    public static void main(String[] args) {
        // 1. Print Welcome Message
        System.out.println("=== Train Consist Management App ===");

        // 2. Initialize an empty List to store Bogies
        // We use the List interface for abstraction and ArrayList for the implementation.
        List<String> trainConsist = new ArrayList<>();

        // 3. Display the initial state of the train
        // Using .size() allows us to see how many elements are currently in our dynamic list.
        System.out.println("Initializing train consist...");
        System.out.println("Initial Bogie Count: " + trainConsist.size());

        // 4. Confirmation of setup
        System.out.println("System ready. Foundation for train composition established.");
    }
}