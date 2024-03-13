import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int numPencils = getNumPencils();
        System.out.println(numPencils);
    }

    public static int getNumPencils() {
        System.out.println("How many pencils would you like to use:");
        return scanner.nextInt();
    }
}
