import java.util.ArrayList;

public class StudentRecordSystem {
    public static void main(String[] args) {
        Student studentMaryam = new Student(1, "Maryam");
        Student studentFurkan = new Student(2, "Furkan");

        Course courseMath = new Course("MATH101", "Math", "BS", 3);
        Course courseEnglish = new Course("ENG101", "English", "BS", 3);
        Course courseComputerScience = new Course("CS201", "Computer Science", "BS", 4);
        Course courseHistory = new Course("HIST201", "History", "BS", 3);

        ArrayList<Course> courses = new ArrayList<>();
        courses.add(courseMath);
        courses.add(courseEnglish);
        courses.add(courseComputerScience);
        courses.add(courseHistory);

        StudentRecordSystem studentRecordSystem = new StudentRecordSystem();

        // Add Maryam to courses
        studentRecordSystem.enrollStudent(studentMaryam, courseMath);
        studentRecordSystem.enrollStudent(studentMaryam, courseEnglish);
        studentRecordSystem.enrollStudent(studentMaryam, courseHistory);

        // Add Furkan to courses
        studentRecordSystem.enrollStudent(studentFurkan, courseMath);
        studentRecordSystem.enrollStudent(studentFurkan, courseComputerScience);
        studentRecordSystem.enrollStudent(studentFurkan, courseHistory);

        // Grade Maryam
        studentRecordSystem.gradeStudent(studentMaryam, courseMath, "A");
        studentRecordSystem.gradeStudent(studentMaryam, courseEnglish, "B");
        studentRecordSystem.gradeStudent(studentMaryam, courseHistory, "B");

        // Grade Furkan
        studentRecordSystem.gradeStudent(studentFurkan, courseMath, "C");
        studentRecordSystem.gradeStudent(studentFurkan, courseComputerScience, "B");
        studentRecordSystem.gradeStudent(studentFurkan, courseHistory, "A");

        // Print transcripts
        studentRecordSystem.printTranscripts(studentMaryam, courses);
        studentRecordSystem.printTranscripts(studentFurkan, courses);

        // Drop math course for Furkan
        studentRecordSystem.dropCourse(studentFurkan, courseMath);

        // Print transcripts
        studentRecordSystem.printTranscripts(studentFurkan, courses);

        System.out.println("Updated GPA for Furkan: " + studentFurkan.calculateGPA());
    }

    public void enrollStudent(Student student, Course course) {
        student.addCourse(course);
    }

    public void gradeStudent(Student student, Course course, String grade) {
        Transcript transcript = new Transcript(student, course, grade);
        course.addTranscript(transcript);
    }

    public void dropCourse(Student student, Course course) {
        student.removeCourse(course);
        course.removeTranscript(course);
    }

    public void printTranscripts(Student student, ArrayList<Course> courses) {
        System.out.println("Transcript for " + student.getName() + " (ID: " + student.studentId() + ")");
        System.out.println("-------------------------------------------------------------");
        System.out.println("| Course Name | Course Code | Level | Credit Hours | Grade |");
        System.out.println("-------------------------------------------------------------");
        for (Course course : courses) {
            for (Transcript transcript : course.getTranscripts()) {
                if (transcript.getStudent().equals(student)) {
                    transcript.printTranscript();
                    System.out.println("-------------------------------------------------------------");
                }
            }
        }
        System.out.println("GPA: " + student.calculateGPA() + "\n");

    }

    public static double letterGradeToPoint(String letter) {
        switch (letter) {
            case "A":
                return 4.0;
            case "B":
                return 3.0;
            case "C":
                return 2.0;
            case "D":
                return 1.0;
            case "F":
                return 0.0;
            default:
                throw new IllegalArgumentException("Invalid letter grade");
        }
    }
}
