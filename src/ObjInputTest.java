public class ObjInputTest {

    public static void main(String[] args) {

        SafeInputObj in = new SafeInputObj();

        System.out.println("=== SafeInputObj Test Program ===");

        // Test non-zero length string
        String name = in.getNonZeroLenString("Enter your name");
        System.out.println("You entered: " + name);

        // Test integer input
        int age = in.getInt("Enter your age");
        System.out.println("Age: " + age);

        // Test ranged integer
        int yob = in.getRangedInt("Enter your year of birth", 1940, 2010);
        System.out.println("YOB: " + yob);

        // Test double input
        double salary = in.getDouble("Enter your salary");
        System.out.println("Salary: " + salary);

        // Test ranged double
        double gpa = in.getRangedDouble("Enter your GPA", 0.0, 4.0);
        System.out.println("GPA: " + gpa);

        // Test Y/N confirm
        boolean confirm = in.getYNConfirm("Do you want to continue");
        System.out.println("Confirmation: " + confirm);

        System.out.println("=== Test Complete ===");
    }
}
