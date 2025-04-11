import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> grades = new ArrayList<>(collectGrades());

        String gradesStr = "";
        for (int i = 1; i <= grades.size(); i++) {
            gradesStr += (i + ". " + grades.get(i - 1) + "   ");
        }

        System.out.println("Grades: " + gradesStr);
        System.out.printf("Average grade: %.2f%%%n", calcAverageGrade(grades));
        System.out.println("Average grade (letter): " + getLetterGrade(calcAverageGrade(grades)));
    }

    // Collect grade inputs from console and return as an ArrayList
    public static ArrayList<Integer> collectGrades() {
        Scanner scnr = new Scanner(System.in);
        ArrayList<Integer> grades = new ArrayList<>();
        int input = -1;

        System.out.println("Please enter up to ten quiz grades (0-100).");
        System.out.println("Enter '999' to quit if you have fewer than 10 grades to enter.");

        while (true) {
            System.out.print("Enter grade: ");
            input = scnr.nextInt();


            if ((input < 0 || input > 100) && input != 999) {
                System.out.println("Please enter a grade between 0 and 100.");
            } else if (input == 999) {
                break;
            } else {
                grades.add(input);
            }

            if (grades.size() == 10) {
                break;
            }
        }

        return grades;
    }

    // Calculates average given an ArrayList of Integers and returns it as a float
    public static float calcAverageGrade (ArrayList<Integer> grades) {
        int counter = 0;
        int sum = 0;

        for (Integer grade : grades) {
            counter++;
            sum += grade;
        }

        return (float)sum/counter;
    }

    // Returns letter grade based on input numerical grade
    public static char getLetterGrade (float gradeAvg) {
        if (gradeAvg < 60) {
            return 'F';
        } else if (gradeAvg < 70) {
            return 'D';
        } else if (gradeAvg < 80) {
            return 'C';
        } else if (gradeAvg < 90) {
            return 'B';
        } else if (gradeAvg <= 100) {
            return 'A';
        } else {
            System.out.println("ERROR: getLetterGrade malfunction");
        }

        return 'Z';
    }
}