import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ProductGenerator {

    public static void main(String[] args) {

        ArrayList<Product> products = new ArrayList<>();
        boolean done = false;

        System.out.println("=== Product Data Generator ===");

        while (!done) {

            String name = SafeInput.getNonZeroLenString("Enter product name");
            String description = SafeInput.getNonZeroLenString("Enter product description");
            String ID = SafeInput.getNonZeroLenString("Enter product ID");
            double cost = SafeInput.getDouble("Enter product cost");

            // Create Product object
            Product p = new Product(name, description, ID, cost);

            // Add to ArrayList
            products.add(p);

            done = !SafeInput.getYNConfirm("Add another product?");
        }

        // Write CSV file
        try {
            FileWriter fw = new FileWriter("ProductData.csv");
            PrintWriter pw = new PrintWriter(fw);

            for (Product p : products) {
                pw.println(p.toCSV());
            }

            pw.close();
            fw.close();

            System.out.println("\nData saved to ProductData.csv");

        } catch (Exception e) {
            System.out.println("Error writing file: " + e.getMessage());
        }

        System.out.println("=== Generator Complete ===");
    }
}
