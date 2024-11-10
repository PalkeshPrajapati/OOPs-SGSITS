package education;

public class Course {
    private String courseName;
    private String courseCode;

    public Course(String courseName, String courseCode) {
        this.courseName = courseName;
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void startCourse() {
        System.out.println("Starting the course: " + courseName);
    }

    public void showCourseDetails() {
        System.out.println("Course: " + courseName + " | Code: " + courseCode);
    }
}
