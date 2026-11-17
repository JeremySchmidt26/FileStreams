import java.util.Scanner;

public class SafeInputObj {

    private Scanner pipe;

    /**
     * Default constructor — uses System.in
     */
    public SafeInputObj() {
        pipe = new Scanner(System.in);
    }

    /**
     * Constructor that accepts an external Scanner
     */
    public SafeInputObj(Scanner scanner) {
        pipe = scanner;
    }

    /**
     * Get a non-zero length string from the user.
     */
    public String getNonZeroLenString(String prompt) {
        String retString = "";
        boolean done = false;

        do {
            System.out.print(prompt + ": ");
            retString = pipe.nextLine().trim();

            if (retString.length() > 0) {
                done = true;
            } else {
                System.out.println("Input cannot be empty.");
            }
        } while (!done);

        return retString;
    }

    /**
     * Get an integer from the user.
     */
    public int getInt(String prompt) {
        int retVal = 0;
        boolean done = false;

        do {
            System.out.print(prompt + ": ");
            if (pipe.hasNextInt()) {
                retVal = pipe.nextInt();
                pipe.nextLine();
                done = true;
            } else {
                System.out.println("Invalid integer.");
                pipe.nextLine();
            }
        } while (!done);

        return retVal;
    }

    /**
     * Get a double from the user.
     */
    public double getDouble(String prompt) {
        double retVal = 0;
        boolean done = false;

        do {
            System.out.print(prompt + ": ");
            if (pipe.hasNextDouble()) {
                retVal = pipe.nextDouble();
                pipe.nextLine();
                done = true;
            } else {
                System.out.println("Invalid double.");
                pipe.nextLine();
            }
        } while (!done);

        return retVal;
    }

    /**
     * Get an integer within a range.
     */
    public int getRangedInt(String prompt, int low, int high) {
        int retVal = 0;
        boolean done = false;

        do {
            System.out.print(prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextInt()) {
                retVal = pipe.nextInt();
                pipe.nextLine();

                if (retVal >= low && retVal <= high) {
                    done = true;
                } else {
                    System.out.println("Input out of range.");
                }
            } else {
                System.out.println("Invalid integer.");
                pipe.nextLine();
            }
        } while (!done);

        return retVal;
    }

    /**
     * Get a double within a range.
     */
    public double getRangedDouble(String prompt, double low, double high) {
        double retVal = 0;
        boolean done = false;

        do {
            System.out.print(prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextDouble()) {
                retVal = pipe.nextDouble();
                pipe.nextLine();

                if (retVal >= low && retVal <= high) {
                    done = true;
                } else {
                    System.out.println("Input out of range.");
                }
            } else {
                System.out.println("Invalid double.");
                pipe.nextLine();
            }
        } while (!done);

        return retVal;
    }

    /**
     * Get a Y/N confirmation from the user.
     */
    public boolean getYNConfirm(String prompt) {
        String resp = "";
        boolean done = false;

        do {
            System.out.print(prompt + " [Y/N]: ");
            resp = pipe.nextLine().trim().toUpperCase();

            if (resp.equals("Y") || resp.equals("N")) {
                done = true;
            } else {
                System.out.println("Please enter Y or N.");
            }
        } while (!done);

        return resp.equals("Y");
    }
}
