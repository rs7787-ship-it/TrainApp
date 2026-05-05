import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * UC11: Validate Train ID & Cargo Codes
 * Demonstrates the use of Regex (Pattern & Matcher) for input validation.
 */
public class TrainConsistApp {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App: UC11 ===");

        // 1. Define Regex Patterns
        // TRN- followed by exactly 4 digits (\\d{4})
        String trainIdRegex = "TRN-\\d{4}"; 
        // PET- followed by exactly 2 uppercase letters ([A-Z]{2})
        String cargoCodeRegex = "PET-[A-Z]{2}";

        // 2. Compile the patterns for efficiency
        Pattern trainIdPattern = Pattern.compile(trainIdRegex);
        Pattern cargoPattern = Pattern.compile(cargoCodeRegex);

        // 3. Test Inputs
        String[] testTrainIds = {"TRN-1234", "TRAIN12", "TRN-123", "TRN-56789"};
        String[] testCargoCodes = {"PET-AB", "PET-ab", "PET12", "PET-XYZ"};

        System.out.println("\n--- Validating Train IDs ---");
        for (String id : testTrainIds) {
            Matcher matcher = trainIdPattern.matcher(id);
            if (matcher.matches()) {
                System.out.println("[VALID]   " + id);
            } else {
                System.out.println("[INVALID] " + id + " (Expected format: TRN-XXXX)");
            }
        }

        System.out.println("\n--- Validating Cargo Codes ---");
        for (String code : testCargoCodes) {
            Matcher matcher = cargoPattern.matcher(code);
            if (matcher.matches()) {
                System.out.println("[VALID]   " + code);
            } else {
                System.out.println("[INVALID] " + code + " (Expected format: PET-XX)");
            }
        }
    }
}
