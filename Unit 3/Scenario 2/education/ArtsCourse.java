package education;

public class ArtsCourse extends Course {
    public ArtsCourse(String courseName, String courseCode) {
        super(courseName, courseCode);
    }

    @Override
    public void startCourse() {
        System.out.println("Starting Arts course: " + getCourseName() + " with creative workshops.");
    }
}
