import java.util.Scanner;

class CourseFullException extends Exception {}
class PrerequisiteNotMetException extends Exception {}

class UniversitySystem {
    static final int MAX_ENROLLMENT = 30;
    static int currentEnrollment = 0;
    static boolean prerequisiteCompleted = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enroll in Course: ");
        String courseName = scanner.nextLine();
        System.out.print("Prerequisite: ");
        String prerequisite = scanner.nextLine();
        
        try {
            if (currentEnrollment >= MAX_ENROLLMENT) {
                throw new CourseFullException();
            }
            
            if (!prerequisiteCompleted && prerequisite.equals("Core Java")) {
                throw new PrerequisiteNotMetException();
            }
            
            currentEnrollment++;
            System.out.println("Successfully enrolled in " + courseName);
        } catch (CourseFullException e) {
            System.out.println("Error: CourseFullException - " + courseName + " is full.");
        } catch (PrerequisiteNotMetException e) {
            System.out.println("Error: PrerequisiteNotMetException - Complete Core Java before enrolling in " + courseName + ".");
        }
    }
}
