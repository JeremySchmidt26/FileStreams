import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class ProductReader {

    public static void main(String[] args) {

        ArrayList<Product> products = new ArrayList<>();

        System.out.println("=== Reading ProductData.csv ===");

        try {
            BufferedReader br = new BufferedReader(new FileReader("ProductData.csv"));
            String line;

            while ((line = br.readLine()) != null) {

                // Split CSV line
                String[] fields = line.split(",");

                // Extract fields
                String name = fields[0];
                String description = fields[1];
                String ID = fields[2];
                double cost = Double.parseDouble(fields[3]);

                // Create Product object
                Product p = new Product(name, description, ID, cost);

                // Add to ArrayList
                products.add(p);
            }

            br.close();

        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        // Display table of Product data
        System.out.println("\n=== Product Data Table ===");
        System.out.printf("%-15s %-20s %-10s %-10s%n",
                "Name", "Description", "ID", "Cost");
        System.out.println("--------------------------------------------------------------");

        for (Product p : products) {
            System.out.printf("%-15s %-20s %-10s %-10.2f%n",
                    p.getName(),
                    p.getDescription(),
                    p.getID(),
                    p.getCost());
        }

        System.out.println("\n=== Reader Complete ===");
    }
}
