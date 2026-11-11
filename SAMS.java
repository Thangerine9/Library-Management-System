import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SAMS {
    private static final Scanner sc = new Scanner(System.in);
    private static final String FILE_PATH_STUDENTS = "Students.txt";
    private static boolean checker = true;

    static void onCreate(String[] className) throws FileNotFoundException, IOException {
        try {
            QualityOfLife.title();

            System.out.println("Press [0] to modify Students | [000] to go back.");
            System.out.println();

            String section = className[0];
            System.out.println(section);
            String course = className[1];
            System.out.println(course);
            System.out.println();

            try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH_STUDENTS))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] separate = line.split("=");
                    if (separate[2].equals(section) && separate[3].equals(course)) {
                        if (checker == true) {
                            Information.Students.addStudents(separate[0], separate[1], separate[2]);
                        }
                        System.out.println(separate[0] + " | " + separate[1]);
                    }
                    
                }
                checker = false;
            }
            System.out.println();

            System.out.println("What do you want to do?");
            System.out.println("*present,absent,late,excused");
            String input = sc.nextLine();

            if (input.equals("0")) {
                StudentModify.onCreate(section, course);
            } else if (input.equals("000")) {
                HomePage.onCreate();
            } else {
                System.out.println("Who is/are " + input + "?");
                System.out.println("*alex,marcus");
                String name = sc.nextLine();

                String[] names = name.split(",");

                for (int i = 0; i < Information.Students.listSize(); i++) {
                    for (int j = 0; j < Information.Students.listSize(); j++) {
                        if (names[i].contains(Information.Students.getStudents(j).split("=")[0])) {
                            Information.Students.setStudents(i, names[i], section, course);
                        }
                    }
                }
                StudentModify.storeToDatabase();
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.print("Error! Press any [key] to continue...");
            sc.nextLine();
            onCreate(className);
        }
    }
}