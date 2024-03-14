import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    // public static char[] stickArray;

    public static void main(String[] args) {

        // Create stick array
        int numPencils = getNumPencils();
        char[] stickArray = createStickArray(numPencils);
        int numSticks = stickArray.length;

        // Create player turn array
        String player = getFirstPlayer("John", "Jack");
        String[] turnOrder = createTurnArray(player, "John", "Jack");

        // Play the game
        System.out.println(stickArray);
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
        String n = "";

        boolean isValid = false;
        while (!isValid) {
            n = scanner.nextLine();
            try {
                int i = Integer.parseInt(n);
                if (i == 0) {
                    System.out.println("ERROR: The number of pencils should be positive");
                }
                else if (i < 0) {
                    System.out.println("ERROR: Not a numeric input (negative)");
                }
                else {
                    System.out.println("SUCCESS: Numeric input");
                    isValid = true;
                }
            } catch (Exception e) {
                System.out.println("ERROR: Not a numeric input.");
            }
        }
        return Integer.parseInt(n);
    }

    public static String getFirstPlayer(String name0, String name1) {
        System.out.printf("Who will be the first (%s, %s):%n", name0, name1);
        return scanner.next();
    }

    public static String[] createTurnArray(String player, String name0, String name1) {
        String[] turnOrder = new String[2];
        if (name0.equalsIgnoreCase(player)) {
            turnOrder[0] = name0;
            turnOrder[1] = name1;
        }
        else {
            turnOrder[0] = name1;
            turnOrder[1] = name0;
        }
        return turnOrder;
    }

    public static char[] createStickArray(int numPencils) {
        char[] stickArray = new char[numPencils];
        Arrays.fill(stickArray, '|');
        return stickArray;
    }

}
