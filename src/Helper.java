// Helper.java
import java.util.Scanner;

public class Helper {
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void pressEnterKeyToContinue(){
        System.out.print("\nTekan Enter untuk melanjutkan...");
        Scanner s = new Scanner(System.in);
        s.nextLine();
    }
}
