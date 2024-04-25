import java.lang.reflect.Array;
import java.util.ArrayList;

public class Course {
    private String courseCode;
    private String courseName;
    private String courseLevel;
    private int credits;
    private ArrayList<Transcript> transcripts;

    // Constructor
    public Course(String courseCode, String courseName,String courseLevel, int credits) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.courseLevel = courseLevel;
        this.credits = credits;
        this.transcripts = new ArrayList<>();
    }

    // Getters and setters
    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseLevel() {
        return courseLevel;
    }

    public int getCredits() {
        return credits;
    }

    public ArrayList<Transcript> getTranscripts() {
        return transcripts;
    }

    public void addTranscript(Transcript transcript) {
        transcripts.add(transcript);
    }

    public void removeTranscript(Course course) {
        for (Transcript transcript : transcripts) {
            if (transcript.getCourse().equals(course)) {
                transcripts.remove(transcript);
                break;
            }
        }
    }

    public Transcript getTranscript(Student student) {
        for (Transcript transcript : transcripts) {
            if (transcript.getStudent().equals(student)) {
                return transcript;
            }
        }
        return null;
    }
}
