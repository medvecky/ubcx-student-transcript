package model;

import java.util.ArrayList;
import java.util.List;

public class Transcript {
    private String studentName;
    private int studentId;

    private List<Double> grades;

    private List<String> courses;

    public Transcript(String studentName, int studentId) {
        this.studentName = studentName;
        this.studentId = studentId;
        grades = new ArrayList<>();
        courses = new ArrayList<>();
    }

    public List<Double> getGrades() {
        return grades;
    }

    public List<String> getCourses() {
        return courses;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    // REQUIRES: the grade should be between 0.0 and 4.0, and/or the course should not be null
    // MODIFIES: this
    // EFFECTS: Adds course and grade to List if course not exist
    //          If course exist does nothing

    //          If course exist updates grade for existing course
    public void addGrade(String course, double grade) {
        if(!courses.contains(course)) {
            courses.add(course);
            grades.add(grade);
        } else {
            grades.set(courses.indexOf(course), grade);
        }
    }

    // REQUIRES: Consumed course exits in list
    // EFFECTS: returns course name and grade in format CourseName: Grade
    public String getCourseAndGrade(String course) {
        int index = courses.indexOf(course);
        return courses.get(index) + ": " + grades.get(index);
    }

    // EFFECTS:  prints course names with grades earned
    public void printTranscript() {
        courses.forEach(course -> System.out.print(getCourseAndGrade(course) + ", "));
        System.out.println();
    }

    // REQUIRES: List of student and grades not empty

    // EFFECTS: Returns average grade for students in list
    public double getGPA() {
        double rawAverage = grades.stream().mapToDouble(a -> a).sum() / grades.size();
        return Math.round(rawAverage * 1000) / 1000.0;
    }

    // REQUIRES: A name of the existing course
    // MODIFIES: this
    // EFFECTS: Remove course with consumed name
    public void removeGrade(String courseName) {
        int indexForRemove = courses.indexOf(courseName);
        courses.remove(indexForRemove);
        grades.remove(indexForRemove);
    }

    // REQUIRES: A name of the existing course
    // EFFECTS: Returns grade for consumed course
    public double getGradeByCourse(String course){
       return grades.get(courses.indexOf(course));
    }

    // REQUIRES: A List of existing courses
    // EFFECTS: Returns average grade for consumed courses
    public double getAverageOverSelectedCourses(List<String> selectedCourses){
       double rawResult = selectedCourses.stream().mapToDouble(this::getGradeByCourse).sum() / selectedCourses.size();
       return Math.round(rawResult * 1000) / 1000.0;
    }
}
