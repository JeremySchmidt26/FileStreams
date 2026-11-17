import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class PersonGenerator {

    public static void main(String[] args) {

        ArrayList<Person> people = new ArrayList<>();
        boolean done = false;

        System.out.println("=== Person Data Generator ===");

        while (!done) {

            String firstName = SafeInput.getNonZeroLenString("Enter first name");
            String lastName = SafeInput.getNonZeroLenString("Enter last name");
            String ID = SafeInput.getNonZeroLenString("Enter ID");
            String title = SafeInput.getNonZeroLenString("Enter title (Mr., Mrs., Dr., etc.)");
            int YOB = SafeInput.getRangedInt("Enter year of birth (1940–2010)", 1940, 2010);

            // Create Person object
            Person p = new Person(firstName, lastName, ID, title, YOB);

            // Add to ArrayList
            people.add(p);

            done = !SafeInput.getYNConfirm("Add another person?");
        }

        // Write CSV file
        try {
            FileWriter fw = new FileWriter("PersonData.csv");
            PrintWriter pw = new PrintWriter(fw);

            for (Person p : people) {
                pw.println(p.toCSV());
            }

            pw.close();
            fw.close();

            System.out.println("\nData saved to PersonData.csv");

        } catch (Exception e) {
            System.out.println("Error writing file: " + e.getMessage());
        }

        System.out.println("=== Generator Complete ===");
    }
}
