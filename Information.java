import java.util.ArrayList;

public class Information {
    static class Classes {
        static ArrayList<String> classes = new ArrayList<String>();

        static void addClasses(String section, String course) {
            classes.add(section + "=" + course);
        }

        static void setClasses(int index, String section, String course) {
            classes.set(index, section + "=" + course);
        }

        static void deleteClasses(int index) {
            classes.remove(index);
        }

        static void removeAllClasses() {
            classes.removeAll(classes);
        }

        static String getClasses(int index) {
            return classes.get(index);
        }

        static void getAllClasses() {
            int count = 0;
            for (int i = 0; i < listSize(); i++) {
                count++;
                String[] separate = Information.Classes.getClasses(i).split("=");
                System.out.println("[" + count + "] " + separate[0] + " | " + separate[1]);
            }
        }

        static int listSize() {
            return classes.size();
        }
    }

    static class Students {
        static ArrayList<String> students = new ArrayList<String>();

        static void addStudents(String name, String section, String course) {
            students.add(name + "=" + section + "=" + course);
        }

        static void setStudents(int index, String name, String section, String course) {
            students.set(index, name + "=" + section + "=" + course);
        }

        static void deleteStudents(int index) {
            students.remove(index);
        }

        static String getStudents(int index) {
            return students.get(index);
        }

        static void getAllStudents() {
            int count = 0;
            for (int i = 0; i < listSize(); i++) {
                count++;
                String[] separate = getStudents(i).split("=");
                System.out.println("[" + count + "] " + separate[0] + " | " + separate[1]);
            }
        }

        static int listSize() {
            return students.size();
        }
    }
}
