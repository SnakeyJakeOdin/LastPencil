import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    // public static char[] stickArray;

    public static void main(String[] args) {
        int numPencils = getNumPencils();

        String player = getFirstPlayer("John", "Jack");

        // create array by player order
        String[] turnOrder = new String[2];
        if ("John".equalsIgnoreCase(player)) {
            turnOrder[0] = "John";
            turnOrder[1] = "Jack";
        }
        else {
            turnOrder[0] = "Jack";
            turnOrder[1] = "John";
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
            numSticks -= scanner.nextInt();
            for (int i = 0; i < numSticks; i++) {
                System.out.print(stickArray[i]);
            }
            System.out.println();
            turn++;
        }
    }

    public static int getNumPencils() {
        System.out.println("How many pencils would you like to use:");
        return scanner.nextInt();
    }

    public static String getFirstPlayer(String name0, String name1) {
        System.out.printf("Who will be the first (%s, %s):%n", name0, name1);
        return scanner.next();
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
