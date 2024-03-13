import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int numPencils = getNumPencils();
        String whoGoesFirst = getWhoGoesFirst();
        System.out.println(numPencils);
        System.out.println(whoGoesFirst);
    }

    public static int getNumPencils() {
        System.out.println("How many pencils would you like to use:");
        return scanner.nextInt();
    }

    public static String getWhoGoesFirst() {
        String name1 = "John";
        String name2 = "Niko";
        System.out.printf("Who will be first (%s, %s):%n", name1, name2);

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
