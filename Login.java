import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Login {
    private static final Scanner sc = new Scanner(System.in);
    private static final String FILE_PATH_PASSWORD = "Password.txt";

    static boolean onCreate() throws FileNotFoundException, IOException {
        QualityOfLife.title();

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH_PASSWORD))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.equals(password)) {
                    return true;
                }
            }
        }
        return false;
    }
}