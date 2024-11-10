import java.util.*;

class Student {
    String name;
    int studentId;
    List<Double> grades = new ArrayList<>();

    Student(String name, int studentId) {
        this.name = name;
        this.studentId = studentId;
    }

    void addGrade(double grade) {
        grades.add(grade);
        System.out.println("Grade " + grade + " added.");
    }

    double calculateAverage() {
        double total = 0;
        for (double grade : grades) {
            total += grade;
        }
        return (grades.isEmpty()) ? 0 : total / grades.size();
    }

    char calculateOverallGrade() {
        double avg = calculateAverage();
        if (avg >= GradeThresholds.A) return 'A';
        else if (avg >= GradeThresholds.B) return 'B';
        else if (avg >= GradeThresholds.C) return 'C';
        else if (avg >= GradeThresholds.D) return 'D';
        else return 'F';
    }

    void displayPerformance() {
        System.out.println("\nPerformance for " + name + " (ID: " + studentId + ")");
        System.out.println("Grades: " + grades);
        System.out.println("Average Grade: " + calculateAverage());
        System.out.println("Overall Grade: " + calculateOverallGrade());
        System.out.println("-------------------------");
    }
}

class GradeThresholds {
    static final double A = 90;
    static final double B = 80;
    static final double C = 70;
    static final double D = 60;
}

public class StudentGradingSystem {
    static HashMap<Integer, Student> students = new HashMap<>();
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n1. Add Student");
            System.out.println("2. Add Grade to Student");
            System.out.println("3. Display Student Performance");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter student id and name: ");
                    int studentId = sc.nextInt();
                    students.put(studentId, new Student(sc.next(), studentId));
                    System.out.println("Student added.");
                    break;
                case 2:
                    System.out.print("Enter student ID and grade: ");
                    int id = sc.nextInt();
                    double grade = sc.nextDouble();
                    if (students.containsKey(id)) {
                        students.get(id).addGrade(grade);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter student ID: ");
                    id = sc.nextInt();
                    if (students.containsKey(id)) {
                        students.get(id).displayPerformance();
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 0:
                    System.out.println("Exiting Student Grading System.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);
    }
}
