package education;

public class TechnologyCourse extends Course {
    public TechnologyCourse(String courseName, String courseCode) {
        super(courseName, courseCode);
    }

    @Override
    public void startCourse() {
        System.out.println("Starting Technology course: " + getCourseName() + " with hands-on coding.");
    }
}
