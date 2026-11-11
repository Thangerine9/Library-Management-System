public class QualityOfLife {
    static void title() {
        clearScreen();
        System.out.println("--------------------------------------------");
        System.out.println("--- Student Attendance Monitoring System ---");
        System.out.println("--------------------------------------------");
    }
    
    static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  
}