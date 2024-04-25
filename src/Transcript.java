public class Transcript {
    private Student student;
    private Course course;
    private String grade;

    // Constructor
    public Transcript(Student student, Course course, String grade) {
        this.student = student;
        this.course = course;
        this.grade = grade;
    }

    // Getters
    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public String getGrade() {
        return grade;
    }

    public void printTranscript() {
        String[] arr = new String[]{"|", course.getCourseName(), "|", course.getCourseCode(), "|", course.getCourseLevel(), "|", String.valueOf(course.getCredits()), "|", grade, "|"};
        System.out.println(String.join(" ", arr));
    }


}
