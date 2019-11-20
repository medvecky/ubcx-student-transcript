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
        courses.add(course);
        grades.add(grade);
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
    // REQUIRES: A name of the existing course
    // MODIFIES: this

    // EFFECTS: Remove course with consumed name
    public void removeGrade(String courseName) {
    }
}
