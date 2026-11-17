import java.util.Calendar;
import java.util.Objects;

public class Person {

    private String firstName;
    private String lastName;
    private String ID;        // should never change
    private String title;
    private int YOB;          // 1940–2010

    /**
     * Full constructor for Person.
     */
    public Person(String firstName, String lastName, String ID, String title, int YOB) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
        this.title = title;
        this.YOB = YOB;
    }

    /**
     * Overloaded constructor without title.
     */
    public Person(String firstName, String lastName, String ID, int YOB) {
        this(firstName, lastName, ID, "", YOB);
    }

    // Getters
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getID() { return ID; }
    public String getTitle() { return title; }
    public int getYOB() { return YOB; }

    // Setters (ID and YOB should NOT change)
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setTitle(String title) { this.title = title; }

    /**
     * Returns firstName + " " + lastName
     */
    public String fullName() {
        return firstName + " " + lastName;
    }

    /**
     * Returns title + " " + fullName()
     */
    public String formalName() {
        return title + " " + fullName();
    }

    /**
     * Returns age based on current year.
     */
    public String getAge() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        return String.valueOf(currentYear - YOB);
    }

    /**
     * Returns age based on a specified year.
     */
    public String getAge(int year) {
        return String.valueOf(year - YOB);
    }

    /**
     * Returns CSV representation.
     */
    public String toCSV() {
        return firstName + "," + lastName + "," + ID + "," + title + "," + YOB;
    }

    /**
     * Returns JSON representation.
     */
    public String toJSON() {
        return "{\n" +
                "  \"firstName\": \"" + firstName + "\",\n" +
                "  \"lastName\": \"" + lastName + "\",\n" +
                "  \"ID\": \"" + ID + "\",\n" +
                "  \"title\": \"" + title + "\",\n" +
                "  \"YOB\": " + YOB + "\n" +
                "}";
    }

    /**
     * Returns XML representation.
     */
    public String toXML() {
        return "<Person>\n" +
                "  <FirstName>" + firstName + "</FirstName>\n" +
                "  <LastName>" + lastName + "</LastName>\n" +
                "  <ID>" + ID + "</ID>\n" +
                "  <Title>" + title + "</Title>\n" +
                "  <YOB>" + YOB + "</YOB>\n" +
                "</Person>";
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", ID='" + ID + '\'' +
                ", title='" + title + '\'' +
                ", YOB=" + YOB +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return YOB == person.YOB &&
                Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(ID, person.ID) &&
                Objects.equals(title, person.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, ID, title, YOB);
    }
}
