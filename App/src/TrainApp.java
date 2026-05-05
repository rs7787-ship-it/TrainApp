/**
 * UC15: Safe Cargo Assignment
 * Demonstrates structured error handling with try-catch-finally.
 */

// Custom Runtime Exception: Used for operational errors that don't 
// necessarily need to be declared everywhere (Unchecked).
class CargoSafetyException extends RuntimeException {
    public CargoSafetyException(String message) {
        super(message);
    }
}

class GoodsBogie {
    private String shape;
    private String currentCargo = "Empty";

    public GoodsBogie(String shape) {
        this.shape = shape;
    }

    public void assignCargo(String cargo) {
        System.out.println("\n>>> Attempting to load: " + cargo + " into " + shape + " bogie.");
        
        try {
            // Safety Rule: Petroleum MUST be in Cylindrical bogies.
            if (cargo.equalsIgnoreCase("Petroleum") && !shape.equalsIgnoreCase("Cylindrical")) {
                throw new CargoSafetyException("SAFETY ALERT: Petroleum cannot be loaded into " + shape + " bogies!");
            }
            
            this.currentCargo = cargo;
            System.out.println("SUCCESS: " + cargo + " loaded successfully.");
            
        } catch (CargoSafetyException e) {
            // Handle the error gracefully
            System.out.println("CAUGHT EXCEPTION: " + e.getMessage());
            System.out.println("ACTION: Cargo assignment aborted to prevent hazards.");
            
        } finally {
            // This block runs no matter what (Success or Failure)
            System.out.println("LOG: Inspection completed for " + shape + " bogie.");
        }
    }

    @Override
    public String toString() {
        return shape + " Bogie [Cargo: " + currentCargo + "]";
    }
}

public class TrainConsistApp {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App: UC15 ===");

        GoodsBogie g1 = new GoodsBogie("Cylindrical");
        GoodsBogie g2 = new GoodsBogie("Rectangular");

        // 1. Safe Assignment
        g1.assignCargo("Petroleum");

        // 2. Unsafe Assignment (Handled)
        g2.assignCargo("Petroleum");

        // 3. System Continuation
        System.out.println("\n--- Final Cargo Status ---");
        System.out.println(g1);
        System.out.println(g2);
        System.out.println("\nSystem health: STABLE. No crashes recorded.");
    }
}
