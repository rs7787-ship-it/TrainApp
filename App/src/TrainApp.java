/**
 * Custom Exception class for Railway Domain.
 * We extend Exception to make it a 'Checked Exception', meaning the compiler 
 * will force the developer to handle this error.
 */
class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

/**
 * PassengerBogie class with built-in validation.
 * This follows the "Fail-Fast" principle.
 */
class PassengerBogie {
    private String type;
    private int capacity;

    public PassengerBogie(String type, int capacity) throws InvalidCapacityException {
        // Enforce the business rule: Capacity MUST be > 0
        if (capacity <= 0) {
            throw new InvalidCapacityException("Capacity must be greater than zero. Provided: " + capacity);
        }
        this.type = type;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return type + " (" + capacity + " seats)";
    }
}

public class TrainConsistApp {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App: UC14 ===");

        // Scenario 1: Creating a valid bogie
        try {
            System.out.println("Attempting to create a valid bogie...");
            PassengerBogie sleeper = new PassengerBogie("Sleeper", 72);
            System.out.println("SUCCESS: Created " + sleeper);
        } catch (InvalidCapacityException e) {
            System.err.println("ERROR: " + e.getMessage());
        }

        // Scenario 2: Creating an invalid bogie (Zero capacity)
        try {
            System.out.println("\nAttempting to create an invalid bogie (Zero capacity)...");
            PassengerBogie brokenBogie = new PassengerBogie("Economy", 0);
        } catch (InvalidCapacityException e) {
            System.out.println("CAUGHT EXCEPTION: " + e.getMessage());
        }

        // Scenario 3: Creating an invalid bogie (Negative capacity)
        try {
            System.out.println("\nAttempting to create an invalid bogie (Negative capacity)...");
            PassengerBogie ghostBogie = new PassengerBogie("First Class", -10);
        } catch (InvalidCapacityException e) {
            System.out.println("CAUGHT EXCEPTION: " + e.getMessage());
        }
        
        System.out.println("\nSystem remains stable. Invalid data was blocked.");
    }
}
