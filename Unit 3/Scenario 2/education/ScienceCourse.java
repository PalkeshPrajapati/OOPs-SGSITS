package education;

public class ScienceCourse extends Course {
    public ScienceCourse(String courseName, String courseCode) {
        super(courseName, courseCode);
    }

    @Override
    public void startCourse() {
        System.out.println("Starting Science course: " + getCourseName() + " with lab sessions.");
    }
}
