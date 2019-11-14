public class Transcript {
    // REQUIRES: the grade should be between 0.0 and 4.0, and/or the course should not be null
    // MODIFIES: this
    // EFFECTS: Adds course and grade to List if course not exist
    //          If course exist does nothing
    //          If course exist updates grade for existing course
    public void addGrade(String course, double grade) {
    }

    // REQUIRES: Consumed course exits in list
    // EFFECTS: returns course name and grade in format CourseName: Grade
    public String getCourseAndGrade(String course) {
        return null;
    }

    // EFFECTS:  prints course names with grades earned
    public void printTranscript() {
    }

    // REQUIRES: List of students and grades not empty
    // EFFECTS: Returns average grade for students in list
    public double getGPA() {
        return 0.0;
    }
}
