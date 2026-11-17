import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class PersonReader {

    public static void main(String[] args) {

        ArrayList<Person> people = new ArrayList<>();

        System.out.println("=== Reading PersonData.csv ===");

        try {
            BufferedReader br = new BufferedReader(new FileReader("PersonData.csv"));
            String line;

            while ((line = br.readLine()) != null) {
                // Split CSV line
                String[] fields = line.split(",");

                // Create Person object
                String firstName = fields[0];
                String lastName = fields[1];
                String ID = fields[2];
                String title = fields[3];
                int YOB = Integer.parseInt(fields[4]);

                Person p = new Person(firstName, lastName, ID, title, YOB);

                // Add to ArrayList
                people.add(p);
            }

            br.close();

        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        // Display table of Person data
        System.out.println("\n=== Person Data Table ===");
        System.out.printf("%-10s %-10s %-10s %-10s %-5s%n",
                "FirstName", "LastName", "ID", "Title", "YOB");
        System.out.println("--------------------------------------------------");

        for (Person p : people) {
            System.out.printf("%-10s %-10s %-10s %-10s %-5d%n",
                    p.getFirstName(),
                    p.getLastName(),
                    p.getID(),
                    p.getTitle(),
                    p.getYOB());
        }

        System.out.println("\n=== Reader Complete ===");
    }
}
