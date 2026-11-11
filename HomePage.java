import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class HomePage {
    private static final Scanner sc = new Scanner(System.in);
    private static final String FILE_PATH_CLASSES = "Classes.txt";
    private static boolean checker = true;

    static void onCreate() throws FileNotFoundException, IOException {
        try {
             QualityOfLife.title();

            System.out.println("Press [0] to modify Classes");
            System.out.println();

            try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH_CLASSES))) {
                String line;
                int count = 0;
                while ((line = reader.readLine()) != null) {
                    count++;
                    String[] separate = line.split("=");
                    if (checker == true) {
                        Information.Classes.addClasses(separate[0], separate[1]);
                    }
                    System.out.println("[" + count + "] " + separate[0] + " | " + separate[1]);
                }
                checker = false;
            }
            System.out.println();

            System.out.print("Enter a number to proceed: ");
            String input = sc.nextLine();

            if (input.equals("0")) {
                ClassModify.onCreate();
            } else {
                SAMS.onCreate(Information.Classes.getClasses(Integer.parseInt(input) - 1).split("="));;
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.print("Error! Press any [key] to continue...");
            sc.nextLine();
            onCreate();
        }
       
    }
}