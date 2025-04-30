import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> grades = new ArrayList<>();

        System.out.println("Welcome to the Student Grade Tracker!");
        System.out.println("You can enter student grades, and the program will calculate the average, highest, and lowest grades.");
        System.out.println("---------------------------------------------------------------");

        String continueInput = "y";

        while (continueInput.equalsIgnoreCase("y")) {
            double grade = 0;
            boolean validGrade = false;

            while (!validGrade) {
                System.out.print("Enter the grade for a student (between 0 and 100): ");
                if (scanner.hasNextDouble()) {
                    grade = scanner.nextDouble();
                    if (grade >= 0 && grade <= 100) {
                        validGrade = true;
                    } else {
                        System.out.println("Error: Grade must be between 0 and 100. Please try again.");
                    }
                } else {
                    System.out.println("Error: Please enter a valid number for the grade.");
                    scanner.next();
                }
            }

            grades.add(grade);

            System.out.print("Do you want to enter another grade? (y/n): ");
            continueInput = scanner.next();

            while (!continueInput.equalsIgnoreCase("y") && !continueInput.equalsIgnoreCase("n")) {
                System.out.print("Invalid input. Please enter 'y' to continue or 'n' to stop: ");
                continueInput = scanner.next();
            }
        }

        if (grades.size() > 0) {
            double sum = 0;
            double highest = grades.get(0);
            double lowest = grades.get(0);

            for (double grade : grades) {
                sum += grade;
                if (grade > highest) {
                    highest = grade;
                }
                if (grade < lowest) {
                    lowest = grade;
                }
            }

            double average = sum / grades.size();

            System.out.println("\n================== Grade Report ==================");
            System.out.println("Total number of students: " + grades.size());
            System.out.printf("Average grade: %.2f\n", average);
            System.out.println("Highest grade: " + highest);
            System.out.println("Lowest grade: " + lowest);
            System.out.println("==================================================");
        } else {
            System.out.println("No grades were entered. Exiting program.");
        }

        scanner.close();
    }
}
