import java.util.Scanner;

public class Program {
    private static final Scanner sc = new Scanner(System.in);

    static void onCreate() {
        try {
            if (Login.onCreate() == true) {
                HomePage.onCreate();
            } else {
                throw new IndexOutOfBoundsException();
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.print("Error! Press any [key] to continue...");
            sc.nextLine();
            onCreate();
        }
    }
}
