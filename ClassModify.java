import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ClassModify {
    private static final Scanner sc = new Scanner(System.in);
    private static final String FILE_PATH_CLASSES = "Classes.txt";

    static void onCreate() {
        try {
            QualityOfLife.title();

            System.out.println("Classes | Press [0] to go back.");
            System.out.println();

            System.out.println("[1] Add Class");
            System.out.println("[2] Edit Class");
            System.out.println("[3] Delete Class");
            System.out.println();

            System.out.print("Enter a number to proceed: ");
            String input = sc.nextLine();
            switch (input) {
                case "0":
                    HomePage.onCreate();
                case "1":
                    addClass();
                case "2":
                    editClass();
                case "3":
                    deleteClass();
                default:
                    throw new IndexOutOfBoundsException();
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.print("Error! Press any [key] to continue...");
            sc.nextLine();
            onCreate();
        }
    }

    static void addClass() throws IOException {
        QualityOfLife.title();

        System.out.println("Add Class | Press [0] to go back.");
        System.out.println();

        System.out.print("Enter section name: ");
        String section = sc.nextLine().trim();

        System.out.print("Enter course name: ");
        String course = sc.nextLine().trim();

        if (section.equals("0") || course.equals("0")) {
            onCreate();
        }

        Information.Classes.addClasses(section, course);
        storeToDatabase();
    }

    static void editClass() throws IOException {
        QualityOfLife.title();

        System.out.println("Edit Class | Press [0] to go back.");
        System.out.println();

        Information.Classes.getAllClasses();
        System.out.println();

        System.out.print("Enter a number to proceed: ");
        String input = sc.nextLine();

        if (input.equals("0")) {
            onCreate();
        }

        String[] separate = Information.Classes.getClasses(Integer.parseInt(input) - 1).split("=");

        // Phase 2
        QualityOfLife.title();

        System.out.println(separate[0] + " | " + separate[1]);
        System.out.println();
        
        System.out.print("Enter new section name: ");
        String section = sc.nextLine().trim();

        System.out.print("Enter new course name: ");
        String course = sc.nextLine().trim();

        Information.Classes.setClasses(Integer.parseInt(input) - 1, section, course);
        storeToDatabase();
    }

    static void deleteClass() throws IOException {
        QualityOfLife.title();

        System.out.println("Delete Class | Press [0] to go back.");
        System.out.println();

        Information.Classes.getAllClasses();
        System.out.println();

        System.out.print("Enter a number to proceed: ");
        String input = sc.nextLine();

        if (input.equals("0")) {
            onCreate();
        }

        String[] separate = Information.Classes.getClasses(Integer.parseInt(input) - 1).split("=");

        // Phase 2
        QualityOfLife.title();

        System.out.println(separate[0] + " | " + separate[1]);
        System.out.println();

        System.out.print("Are you sure to delete this class [Y/N]?");
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
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH_CLASSES))) {
            writer.print("");
            writer.flush();
            writer.close();
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH_CLASSES))) {
            for (int i = 0; i < Information.Classes.listSize(); i++) {
                writer.println(Information.Classes.getClasses(i));
            }
            writer.flush();
            writer.close();
        }
        onCreate();
    }
}
