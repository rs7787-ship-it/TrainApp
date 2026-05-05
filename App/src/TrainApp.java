import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * UC13: Performance Comparison (Loops vs Streams)
 * Benchmarks the execution time of imperative vs declarative filtering.
 */
class Bogie {
    String type;
    int capacity;

    public Bogie(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
    }
}

public class TrainConsistApp {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App: UC13 ===");

        // 1. Setup a large dataset to make measurements meaningful
        List<Bogie> largeConsist = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            largeConsist.add(new Bogie("Sleeper", 72));
            largeConsist.add(new Bogie("AC Chair", 56));
        }

        // 2. Benchmark Loop-Based Filtering
        long startTimeLoop = System.nanoTime();
        List<Bogie> loopFiltered = new ArrayList<>();
        for (Bogie b : largeConsist) {
            if (b.capacity > 60) {
                loopFiltered.add(b);
            }
        }
        long endTimeLoop = System.nanoTime();
        long durationLoop = endTimeLoop - startTimeLoop;

        // 3. Benchmark Stream-Based Filtering
        long startTimeStream = System.nanoTime();
        List<Bogie> streamFiltered = largeConsist.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
        long endTimeStream = System.nanoTime();
        long durationStream = endTimeStream - startTimeStream;

        // 4. Performance Summary
        System.out.println("Processing " + largeConsist.size() + " bogies...");
        System.out.println("\n--- Benchmark Results ---");
        System.out.println("Loop Execution Time   : " + durationLoop + " ns");
        System.out.println("Stream Execution Time : " + durationStream + " ns");
        
        // 5. Verification
        System.out.println("\nLogic Check: " + 
            (loopFiltered.size() == streamFiltered.size() ? "PASSED (Results match)" : "FAILED"));
    }
}
