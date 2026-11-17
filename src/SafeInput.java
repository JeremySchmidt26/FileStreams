import java.util.Scanner;

public class SafeInput {

    /**
     * Get a non-zero length string from the user.
     */
    public static String getNonZeroLenString(String prompt) {
        Scanner pipe = new Scanner(System.in);
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
    public static int getInt(String prompt) {
        Scanner pipe = new Scanner(System.in);
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
    public static double getDouble(String prompt) {
        Scanner pipe = new Scanner(System.in);
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
    public static int getRangedInt(String prompt, int low, int high) {
        Scanner pipe = new Scanner(System.in);
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
    public static double getRangedDouble(String prompt, double low, double high) {
        Scanner pipe = new Scanner(System.in);
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
    public static boolean getYNConfirm(String prompt) {
        Scanner pipe = new Scanner(System.in);
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
