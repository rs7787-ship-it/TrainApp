import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * UC9: Group Bogies by Type
 * Demonstrates the use of Collectors.groupingBy to transform a flat list into a categorized Map.
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
        return "[Capacity: " + capacity + "]";
    }
}

public class TrainConsistApp {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App: UC9 ===");

        // 1. Create a list with multiple bogies of the same type
        List<Bogie> trainConsist = new ArrayList<>();
        trainConsist.add(new Bogie("Sleeper", 72));
        trainConsist.add(new Bogie("AC Chair", 56));
        trainConsist.add(new Bogie("Sleeper", 72));
        trainConsist.add(new Bogie("First Class", 24));
        trainConsist.add(new Bogie("AC Chair", 56));

        System.out.println("Total bogies in yard: " + trainConsist.size());

        // 2. Apply Grouping logic using Streams
        // We group by the 'name' field of the Bogie object
        Map<String, List<Bogie>> groupedBogies = trainConsist.stream()
                .collect(Collectors.groupingBy(b -> b.name));

        // 3. Display the Grouped Results
        System.out.println("\n--- Categorized Train Report ---");
        groupedBogies.forEach((type, list) -> {
            System.out.println("Type: " + type + " | Count: " + list.size() + " | Details: " + list);
        });

        // 4. Integrity Check
        System.out.println("\nOriginal list remains untouched. Size: " + trainConsist.size());
    }
}
