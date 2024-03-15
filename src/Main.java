import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    // public static char[] stickArray;

    public static void main(String[] args) {

        // Create stick array
        int numPencils = getNumPencils();
        char[] stickArray = createStickArray(numPencils);
        int remainingSticks = stickArray.length;

        // Create player turn array
        String player = getFirstPlayer("John", "Jack");
        String[] turnOrder = createTurnArray(player, "John", "Jack");

        // Play the game
        System.out.println(stickArray);
        int turn = 0;
        while (remainingSticks > 0) {
            if (turn % 2 == 0) {
                System.out.printf("%s's turn!%n", turnOrder[0]);
            }
            else {
                System.out.printf("%s's turn!%n", turnOrder[1]);
            }

            remainingSticks -= getNumSticks(remainingSticks);
            for (int i = 0; i < remainingSticks; i++) {
                System.out.print(stickArray[i]);
            }

            turn++;
            if (remainingSticks == 0) {  // avoid whitespace for winner's screen
                break;
            }
            System.out.println();
        }

        // Display winner
        if (turn % 2 == 0) {
            System.out.printf("%s won!%n", turnOrder[0]);
        }
        else {
            System.out.printf("%s won!%n", turnOrder[1]);
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
                    System.out.println("The number of pencils should be positive");
                }
                else if (i < 0) {
                    System.out.println("The number of pencils should be numeric");
                }
                else {
                    isValid = true;
                }
            } catch (Exception e) {
                System.out.println("The number of pencils should be numeric");
            }
        }
        return Integer.parseInt(n);
    }

    public static int getNumSticks(int remainingSticks) {
        String n = "";
        boolean isValid = false;
        while (!isValid) {
            n = scanner.nextLine();
            try {
                int i = Integer.parseInt(n);
                if (i > 3 || i < 1) {
                    System.out.println("Possible values: '1', '2' or '3'");
                }
                else if (i > remainingSticks) {
                    System.out.println("Too many pencils were taken");
                }
                else {
                    isValid = true;
                }
            } catch (Exception e) {
                System.out.println("Possible values: '1', '2' or '3'");
            }
        }
        return Integer.parseInt(n);
    }

    public static String getFirstPlayer(String name0, String name1) {
        System.out.printf("Who will be the first (%s, %s):%n", name0, name1);
        String s = "";
        boolean isValid = false;
        while (!isValid) {
            s = scanner.nextLine();
            if (name0.equals(s) || name1.equals(s)) {
                isValid = true;
            }
            else {
                System.out.printf("Choose between '%s' and '%s'%n", name0, name1);
            }
        }
        return s;
    }

    public static String[] createTurnArray(String player, String name0, String name1) {
        String[] turnOrder = new String[2];
        if (name0.equals(player)) {
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
