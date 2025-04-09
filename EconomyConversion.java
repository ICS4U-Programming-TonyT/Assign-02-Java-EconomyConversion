import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**.
 * This class converts currency amounts from one currency to another.*
 * @author Tony Tran
 * @version 1.0
 * @since 2025-04-07
 */

final class EconomyConversion {
    /**
     * This is a private constructor to satisfy style checker.
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */
    private EconomyConversion() {
        throw new IllegalStateException("Utility class");
    }
    /**
     * This is the main method to run the program.
     * @param args
     * @throws Exception
     */
    public static void main(final String[] args) throws Exception {
        // Create a Scanner object to read from the input file
        Scanner scanner = new Scanner(new File(args[0]));
        // Create a FileWriter object to write to the output file
        FileWriter writer = new FileWriter("output.txt");
        // Read the exchange rate from the first line of the input file
        double exchangeRate = Double.parseDouble(scanner.nextLine());
        // Read the amounts from the input file and convert them to an array
        ArrayList<Double> amounts = new ArrayList<>();
        while (scanner.hasNextLine()) {
            amounts.add(Double.parseDouble(scanner.nextLine()));
        }
        // Convert the amounts to the new currency using the exchange rate
        for (double amount : amounts) {
            double convertedAmount = amount * exchangeRate;
            writer.write(String.format("%.2f\n", convertedAmount));
        }
        // Close the scanner and writer
        scanner.close();
        writer.close();
        System.out.println("Check output.txt for results.");
    }
}
