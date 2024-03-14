import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static char[] stickArray;

    public static void main(String[] args) {
        int n = getPencilNumber();
        System.out.println(createString(n));
    }

    public static int getPencilNumber() {
        System.out.println("How many pencils would you like to use:");
        return scanner.nextInt();
    }

    public static String createString(int n) {
        stickArray = new char[n];
        Arrays.fill(stickArray, '|');
        return String.valueOf(stickArray);
    }

    public static String getWhoGoesFirst() {
        String name1 = "John";
        String name2 = "Niko";
        System.out.printf("Who will be the first (%s, %s):%n", name1, name2);

        String userChoice = scanner.next();
        if (userChoice.equalsIgnoreCase(name1)) {
            return name1;
        }
        else if (userChoice.equalsIgnoreCase(name2)) {
            return name2;
        }
        else {
            return "\"ERROR: No valid name was chosen\"";
        }
    }

}
