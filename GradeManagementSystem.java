import java.util.Scanner;

public class GradeManagementSystem {
    private static String[] studentNames;
    private static double[][] studentMarks;
    private static final int MAX_STUDENTS = 100;
    private static final int SUBJECT_COUNT = 5;
    private static int studentCount = 0;
    private static Scanner scanner = new Scanner(System.in);

    private static String[] subjects = {
        "Mathematics", "Science", "English", "Hindi", "Computer"
    };

    public static void main(String[] args) {
        initializeArrays();

        while(true) {
            System.out.println("\n=== GRADE MANAGEMENT SYSTEM ===");
            System.out.println("1. Add Student Marks");
            System.out.println("2. View All Students");
            System.out.println("3. Calculate Averages");
            System.out.println("4. Find Top Performer");
            System.out.println("5. Search Student");
            System.out.println("6. Generate Report");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = getValidInt(1, 7);

            switch(choice) {
                case 1: addStudentMarks(); break;
                case 2: viewAllStudents(); break;
                case 3: calculateAverages(); break;
                case 4: findTopPerformer(); break;
                case 5: searchStudent(); break;
                case 6: generateReport(); break;
                case 7:
                    System.out.println("Exiting...");
                    return;
            }
        }
    }

    private static void initializeArrays() {
        studentNames = new String[MAX_STUDENTS];
        studentMarks = new double[MAX_STUDENTS][SUBJECT_COUNT];
    }

    private static void addStudentMarks() {
        if(studentCount >= MAX_STUDENTS) {
            System.out.println("Limit reached!");
            return;
        }

        System.out.print("Enter Name: ");
        studentNames[studentCount] = scanner.nextLine();

        System.out.println("\nEnter marks for 5 subjects (out of 100):");
        for(int i = 0; i < SUBJECT_COUNT; i++) {
            System.out.print(subjects[i] + ": ");
            studentMarks[studentCount][i] = getValidMark();
        }

        studentCount++;
        System.out.println("Student added successfully!");
    }

   private static void viewAllStudents() {
        System.out.println("\n=== ALL STUDENTS ===");
        if(studentCount == 0) {
            System.out.println("No students found!");
            return;
        }
        
        System.out.printf("%-20s %-12s %-12s %-12s %-12s %-12s %-12s\n", 
                         "Student Name", "Math", "Science", "English", "Hindi", "Computer", "Average");
        System.out.println("-".repeat(100));
        
        for(int i = 0; i < studentCount; i++) {
            double average = calculateStudentAverage(i);
            System.out.printf("%-20s %-12.2f %-12.2f %-12.2f %-12.2f %-12.2f %-12.2f\n", 
                            studentNames[i],
                            studentMarks[i][0], studentMarks[i][1], studentMarks[i][2],
                            studentMarks[i][3], studentMarks[i][4],
                            average);
        }
    }

    private static double calculateStudentAverage(int index) {
        double sum = 0;
        for(int i = 0; i < SUBJECT_COUNT; i++) {
            sum += studentMarks[index][i];
        }
        return sum / SUBJECT_COUNT;
    }

    private static void calculateAverages() {
        System.out.println("\n=== STUDENT AVERAGES ===");
        for(int i = 0; i < studentCount; i++) {
            double average = calculateStudentAverage(i);
            String grade = getGrade(average);
            System.out.printf("%-20s: Average = %.2f, Grade = %s\n", 
                            studentNames[i], average, grade);
        }
    }

    private static String getGrade(double avg) {
        if(avg >= 90) return "A";
        else if(avg >= 80) return "B";
        else if(avg >= 70) return "C";
        else if(avg >= 60) return "D";
        else return "F";
    }

    private static void findTopPerformer() {
        if(studentCount == 0) {
            System.out.println("No data.");
            return;
        }

        int topIndex = 0;
        double highest = calculateStudentAverage(0);

        for(int i = 1; i < studentCount; i++) {
            double avg = calculateStudentAverage(i);
            if(avg > highest) {
                highest = avg;
                topIndex = i;
            }
        }

        System.out.println("\nTop Performer: " + studentNames[topIndex] + " → " + highest);
    }

    private static void searchStudent() {
        System.out.print("Enter name to search: ");
        String name = scanner.nextLine();

        for(int i = 0; i < studentCount; i++) {
            if(studentNames[i].equalsIgnoreCase(name)) {
                System.out.println("\nStudent Found:");
                System.out.println("Name: " + studentNames[i]);

                for(int j = 0; j < SUBJECT_COUNT; j++) {
                    System.out.println(subjects[j] + ": " + studentMarks[i][j]);
                }

                double avg = calculateStudentAverage(i);
                System.out.println("Average: " + avg);
                System.out.println("Grade: " + getGrade(avg));
                return;
            }
        }
        System.out.println("Student not found.");
    }

    private static void generateReport() {
        if(studentCount == 0) {
            System.out.println("No data.");
            return;
        }

        double highest = -1, lowest = 101, total = 0;

        for(int i = 0; i < studentCount; i++) {
            double avg = calculateStudentAverage(i);
            total += avg;

            if(avg > highest) highest = avg;
            if(avg < lowest) lowest = avg;
        }

        double overallAvg = total / studentCount;

        System.out.println("\n=== PERFORMANCE REPORT ===");
        System.out.println("Total Students: " + studentCount);
        System.out.println("Highest Average: " + highest);
        System.out.println("Lowest Average: " + lowest);
        System.out.println("Overall Average: " + overallAvg);
    }

    private static int getValidInt(int min, int max) {
        while(true) {
            try {
                int val = scanner.nextInt();
                scanner.nextLine();
                if(val >= min && val <= max) return val;
                else System.out.print("Enter valid choice: ");
            } catch(Exception e) {
                System.out.print("Invalid input: ");
                scanner.nextLine();
            }
        }
    }

    private static double getValidMark() {
        while(true) {
            try {
                double m = scanner.nextDouble();
                scanner.nextLine();
                if(m >= 0 && m <= 100) return m;
                else System.out.print("Enter marks between 0-100: ");
            } catch(Exception e) {
                System.out.print("Invalid input: ");
                scanner.nextLine();
            }
        }
    }
}