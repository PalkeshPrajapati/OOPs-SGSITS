import java.util.*;

// Syllabus class (Composition: A Course has a Syllabus)
class Syllabus {
    private String topicsCovered;

    Syllabus(String topicsCovered) {
        this.topicsCovered = topicsCovered;
    }

    String getTopicsCovered() {
        return topicsCovered;
    }

    void updateSyllabus(String topicsCovered) {
        this.topicsCovered = topicsCovered;
    }
}

// Course class (Aggregation: A Course contains multiple Students)
class Course {
    public String courseName;
    private String courseCode;
    private List<Student> enrolledStudents = new ArrayList<>();
    private Syllabus syllabus;

    Course(String courseName, String courseCode, String topicsCovered) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.syllabus = new Syllabus(topicsCovered);
    }

    // Overloaded methods to enroll students
    void enrollStudent(Student student) {
        enrolledStudents.add(student);
    }

    void enrollStudentById(Student student, String studentId) {
        if (student.getId().equals(studentId)) {
            enrolledStudents.add(student);
        } else {
            System.out.println("Student ID mismatch.");
        }
    }

    void displayCourseDetails() {
        System.out.println("Course: " + courseName + " (" + courseCode + ")");
        System.out.println("Syllabus: " + syllabus.getTopicsCovered());
        System.out.println("Enrolled Students: ");
        for (Student student : enrolledStudents) {
            System.out.println("- " + student.getName());
        }
    }
}

// Specialized UndergraduateCourse class inheriting Course
class UndergraduateCourse extends Course {
    UndergraduateCourse(String courseName, String courseCode, String topicsCovered) {
        super(courseName, courseCode, topicsCovered);
    }
}

// Specialized GraduateCourse class inheriting Course
class GraduateCourse extends Course {
    GraduateCourse(String courseName, String courseCode, String topicsCovered) {
        super(courseName, courseCode, topicsCovered);
    }
}

// Student class (Association: A Student is associated with multiple Courses)
class Student {
    private String name;
    private String id;
    private List<Course> enrolledCourses = new ArrayList<>();

    Student(String name, String id) {
        this.name = name;
        this.id = id;
    }

    String getName() {
        return name;
    }

    String getId() {
        return id;
    }

    void enrollInCourse(Course course) {
        enrolledCourses.add(course);
    }

    void displayEnrolledCourses() {
        System.out.println(name + "'s Enrolled Courses:");
        for (Course course : enrolledCourses) {
            System.out.println("- " + course.courseName);
        }
    }
}

// Faculty class (used for managing courses)
class Faculty {
    private String name;
    private String department;

    Faculty(String name, String department) {
        this.name = name;
        this.department = department;
    }

    void manageCourse(Course course) {
        System.out.println(name + " from " + department + " department is managing the course: " + course.courseName);
    }
}

public class UniversityEnrollmentSystem {
    public static void main(String[] args) {
        // Create Faculty member
        Faculty faculty1 = new Faculty("Dr. Sharma", "Computer Science");

        // Create Courses
        Course course1 = new UndergraduateCourse("Data Structures", "CS101", "Arrays, Linked Lists, Trees");
        Course course2 = new GraduateCourse("Advanced Algorithms", "CS201", "Graph Theory, Dynamic Programming");

        // Create Students
        Student student1 = new Student("Palkesh Prajapati", "S001");
        Student student2 = new Student("Simran Kaur", "S002");

        // Faculty managing the courses
        faculty1.manageCourse(course1);
        faculty1.manageCourse(course2);

        // Enroll students in courses (Method Overloading)
        course1.enrollStudent(student1);
        course2.enrollStudentById(student2, "S002");

        // Display course details
        course1.displayCourseDetails();
        course2.displayCourseDetails();

        // Display enrolled courses for students
        student1.displayEnrolledCourses();
        student2.displayEnrolledCourses();
    }
}