import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    // public static char[] stickArray;

    public static void main(String[] args) {
        // get number of pencils
        System.out.println("How many pencils would you like to use:");
        int numPencils = scanner.nextInt();

        // get first player
        String name0 = "John";
        String name1 = "Jack";
        System.out.printf("Who will be the first (%s, %s):%n", name0, name1);
        String player = scanner.next();

        // create array by player order
        String[] turnOrder = new String[2];
        if (name0.equalsIgnoreCase(player)) {
            turnOrder[0] = name0;
            turnOrder[1] = name1;
        }
        else {
            turnOrder[0] = name1;
            turnOrder[1] = name0;
        }
        System.out.printf("This is order of the players: %s%n", Arrays.toString(turnOrder));

        // display information
        char[] stickArray = new char[numPencils];
        int numSticks = stickArray.length;
        Arrays.fill(stickArray, '|');
        System.out.println(stickArray);

        // play the game
        int turn = 0;
        while (numSticks > 0) {
            if (turn % 2 == 0) {
                System.out.printf("%s's turn:%n", turnOrder[0]);
            }
            else {
                System.out.printf("%s's turn:%n", turnOrder[1]);
            }
            numSticks--;
            turn++;
        }
    }

    /*
    public static int getPencilCount() {
        System.out.println("How many pencils would you like to use:");
        return scanner.nextInt();
    }

    public static String createPencilString(int n) {
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

    public static void displayStartingState() {
        System.out.printf("%s%n%s's turn", createPencilString(getPencilCount()), getWhoGoesFirst());
    }
     */

}
