package education;

public final class ProgrammingCourse extends TechnologyCourse implements Interactive {
    private String programmingLanguage;

    public ProgrammingCourse(String courseName, String courseCode, String programmingLanguage) {
        super(courseName, courseCode);
        this.programmingLanguage = programmingLanguage;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    @Override
    public void startCourse() {
        System.out.println("Starting Programming course: " + getCourseName() + " in " + programmingLanguage + ".");
    }

    @Override
    public void startLiveSession() {
        System.out.println("Starting live session for Programming course in " + programmingLanguage + ".");
    }

    @Override
    public void takeQuiz() {
        System.out.println("Taking quiz for Programming course in " + programmingLanguage + ".");
    }
}
