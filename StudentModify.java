import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class StudentModify {
    private static final Scanner sc = new Scanner(System.in);
    private static final String FILE_PATH_STUDENTS = "Students.txt";

    static void onCreate(String section, String course) {
        try {
            QualityOfLife.title();

            System.out.println("Students | Press [0] to go back.");
            System.out.println();

            System.out.println("[1] Add Student");
            System.out.println("[2] Edit Student");
            System.out.println("[3] Delete Student");
            System.out.println();

            System.out.print("Press a number to proceed: ");
            String input = sc.nextLine();
            switch (input) {
                case "0":
                    String[] combine = new String[2];
                    combine[0] = section;
                    combine[1] = course;

                    SAMS.onCreate(combine);
                case "1":
                    addStudent(section, course);
                case "2":
                    editStudent(section, course);
                case "3":
                    deleteStudent(section, course);
                default:
                    onCreate(section, course);
            }
            onCreate(section, course);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.print("Error! Press any [key] to continue...");
            sc.nextLine();
            onCreate(section, course);
        }
    }

    static void addStudent(String section, String course) throws IOException {
        QualityOfLife.title();

        System.out.println("Add Student | Press [0] to go back");
        System.out.println();

        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        if (name.equals(0)) {
            String[] combine = new String[2];
            combine[0] = section;
            combine[1] = course;

            SAMS.onCreate(combine);
        }

        Information.Students.addStudents(name, section, course);
        storeToDatabase();
    }

    static void editStudent(String section, String course) throws IOException {
        QualityOfLife.title();

        System.out.println("Edit Student | Press [0] to go back");
        System.out.println();

        Information.Students.getAllStudents();
        System.out.println();

        System.out.print("Enter a number to proceed: ");
        String input = sc.nextLine();

        if (input.equals("0")) {
            String[] combine = new String[2];
            combine[0] = section;
            combine[1] = course;

            SAMS.onCreate(combine);
        }

        String[] separate = Information.Students.getStudents(Integer.parseInt(input)).split("=");

        // Phase 2
        QualityOfLife.title();

        System.out.println(separate[0]);
        System.out.println();
        
        System.out.print("Enter new student name: ");
        String name = sc.nextLine();

        Information.Students.setStudents(Integer.parseInt(input) - 1, name, section, course);
        storeToDatabase();
    }

    static void deleteStudent(String section, String course) throws IOException {
        QualityOfLife.title();

        System.out.println("Delete Student | Press [0] to go back");
        System.out.println();

        Information.Students.getAllStudents();
        System.out.println();

        System.out.print("Enter a number to proceed: ");
       String input = sc.nextLine();

        if (input.equals("0")) {
            String[] combine = new String[2];
            combine[0] = section;
            combine[1] = course;

            SAMS.onCreate(combine);
        }

        String[] separate = Information.Students.getStudents(Integer.parseInt(input)).split("=");

        // Phase 2
        QualityOfLife.title();

        System.out.println(separate[0]);
        System.out.println();

        System.out.println("Are you sure to delete this class [Y/N]?");
        String confirm = sc.nextLine().toLowerCase();
        switch (confirm) {
            case "y":
                Information.Classes.deleteClasses(Integer.parseInt(input) - 1);
                storeToDatabase();
            default:
                break;
        }
    }
    static void storeToDatabase() throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH_STUDENTS))) {
            writer.print("");
            writer.flush();
            writer.close();
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH_STUDENTS))) {
            for (int i = 0; i < Information.Students.listSize(); i++) {
                writer.println(Information.Students.getStudents(i));
            }
            writer.flush();
            writer.close();
        }
    }
}
