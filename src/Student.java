import java.util.ArrayList;

public class Student {
    private int studentId;
    private String name;
    private ArrayList<Course> courses;

    // Constructor
    public Student(int studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int studentId() {
        return studentId;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }


    public void addCourse(Course course) {
        courses.add(course);
    }


    public void removeCourse(Course course) {
        for (Course c : courses) {
            if (c.equals(course)) {
                courses.remove(c);
                break;
            }
        }
    }

    public double calculateGPA() {
        double totalGradePoints = 0;
        double totalCreditHours = 0;
        for (Course course : this.getCourses()) {
            for (Transcript transcript : course.getTranscripts()) {
                if (transcript.getStudent().equals(this)) {
                    totalGradePoints += StudentRecordSystem.letterGradeToPoint(transcript.getGrade()) * transcript.getCourse().getCredits();
                    totalCreditHours += transcript.getCourse().getCredits();
                }
            }
        }
        return Math.round(totalGradePoints / totalCreditHours * 100) / 100.0;
    }
}