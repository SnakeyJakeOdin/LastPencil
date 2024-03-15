import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    // public static char[] stickArray;

    public static void main(String[] args) {

        // create stick array
        char[] stickArray = createStickArray(getNumPencils());

        // create player turn array
        String[] players = new String[]{"John", "Jack"};
        String[] turnOrder = createTurnArray(getFirstPlayer(players), players);

        // play the game
        int sticks = stickArray.length;
        int turn = 0;

        while (sticks > 0) {
            printSticks(sticks, stickArray);  // display sticks
            printPlayerTurn(turn, turnOrder); // display current player's turn
            sticks -= updateSticks(sticks);   // update total stick counter
            turn++;                           // move to next turn
        }

        printWinner(turn, turnOrder);
    }

    public static int getNumPencils() {
        System.out.println("How many pencils would you like to use:");

        String s;
        int i;

        while (true) {
            s = scanner.nextLine();

            try {
                i = Integer.parseInt(s);
            } catch (Exception e) {
                System.out.println("The number of pencils should be numeric");
                continue;
            }
            if (i == 0) {
                System.out.println("The number of pencils should be positive");
            }
            else if (i < 0) {
                System.out.println("The number of pencils should be numeric");
            }
            else {
                break;
            }
        }
        return Integer.parseInt(s);
    }

    public static int updateSticks(int remainingSticks) {
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

    public static String getFirstPlayer(String[] players) {
        System.out.printf("Who will be the first (%s, %s):%n", players[0], players[1]);

        String s;

        while (true) {
            s = scanner.nextLine();
            if (players[0].equals(s) || players[1].equals(s)) {
                break;
            }
            else {
                System.out.printf("Choose between '%s' and '%s'%n", players[0], players[1]);
            }
        }
        return s;
    }

    public static String[] createTurnArray(String whoPlaysFirst, String[] players) {
        String[] turnOrder = new String[2];

        if (players[0].equals(whoPlaysFirst)) {
            turnOrder[0] = players[0];
            turnOrder[1] = players[1];
        }
        else {
            turnOrder[0] = players[1];
            turnOrder[1] = players[0];
        }
        return turnOrder;
    }

    public static char[] createStickArray(int numPencils) {
        char[] stickArray = new char[numPencils];
        Arrays.fill(stickArray, '|');
        return stickArray;
    }

    public static void printPlayerTurn(int turn, String[] turnOrder) {
        if (turn % 2 == 0) {
            System.out.printf("%s's turn!%n", turnOrder[0]);
        }
        else {
            System.out.printf("%s's turn!%n", turnOrder[1]);
        }
    }

    public static void printWinner(int turn, String[] turnOrder) {
        if (turn % 2 == 0) {
            System.out.printf("%s won!%n", turnOrder[0]);
        }
        else {
            System.out.printf("%s won!%n", turnOrder[1]);
        }
    }

    public static void printSticks(int sticks, char[] stickArray) {
        for (int i = 0; i < sticks; i++) {
            System.out.print(stickArray[i]);
        }
        System.out.println();
    }
}