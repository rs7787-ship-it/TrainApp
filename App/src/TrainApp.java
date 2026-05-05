import java.util.ArrayList;
import java.util.List;

/**
 * UC12: Safety Compliance Check for Goods Bogies
 * Demonstrates business rule enforcement using Stream.allMatch().
 */
class GoodsBogie {
    String type;
    String cargo;

    public GoodsBogie(String type, String cargo) {
        this.type = type;
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return type + " [" + cargo + "]";
    }
}

public class TrainConsistApp {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App: UC12 ===");

        // 1. Prepare the Goods Consist
        List<GoodsBogie> goodsConsist = new ArrayList<>();
        goodsConsist.add(new GoodsBogie("Rectangular", "Coal"));
        goodsConsist.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsConsist.add(new GoodsBogie("Rectangular", "Iron Ore"));
        // This next line would trigger a safety failure if changed to something other than Petroleum
        goodsConsist.add(new GoodsBogie("Cylindrical", "Petroleum")); 

        System.out.println("Inspecting goods consist: " + goodsConsist);

        // 2. Apply Safety Compliance Check using allMatch()
        // Rule: IF type is Cylindrical, THEN cargo MUST be Petroleum.
        // Logic: For every bogie 'b', (it's not cylindrical) OR (it's carrying petroleum).
        boolean isSafe = goodsConsist.stream().allMatch(b -> {
            if (b.type.equalsIgnoreCase("Cylindrical")) {
                return b.cargo.equalsIgnoreCase("Petroleum");
            }
            return true; // Non-cylindrical bogies pass this specific check
        });

        // 3. Display the Compliance Result
        System.out.println("\n--- Safety Inspection Report ---");
        if (isSafe) {
            System.out.println("STATUS: [PASSED]");
            System.out.println("MESSAGE: All bogies comply with cargo safety standards.");
        } else {
            System.out.println("STATUS: [FAILED]");
            System.out.println("ALERT: Safety violation detected! Cylindrical bogies can only carry Petroleum.");
        }
    }
}
