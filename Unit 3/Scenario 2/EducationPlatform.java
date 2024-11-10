import education.*;

public class EducationPlatform {

    public static void main(String[] args) {
        ScienceCourse science = new ScienceCourse("Physics", "SCI101");
        science.startCourse();
        System.err.println("\n--------------------------------");
        science.showCourseDetails();
        System.err.println("--------------------------------\n");
        
        ArtsCourse arts = new ArtsCourse("Painting", "ART201");
        arts.startCourse();
        System.err.println("\n--------------------------------");
        arts.showCourseDetails();
        System.err.println("--------------------------------\n");

        ProgrammingCourse programming = new ProgrammingCourse("Java Programming", "TECH301", "Java");
        programming.startCourse();
        programming.startLiveSession();
        programming.takeQuiz();
    }
}
