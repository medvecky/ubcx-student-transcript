package test;

import junit.framework.TestCase;
import model.Transcript;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;


public class TranscriptTest {
    private Transcript testTranscript;
    private String testName = "John Dow";
    private int testStudentId = 1;
    private List<String> expectedCourses;
    private List<Double> expectedGrades;

    private void addThreeGrades() {
        for (int i = 0; i < 3; i++) {
            testTranscript.addGrade(expectedCourses.get(i), expectedGrades.get(i));
        }
    }


    @Before
    public void setUp() {
        testTranscript = new Transcript(testName, testStudentId);
        expectedCourses = new ArrayList<>();
        expectedGrades = new ArrayList<>();
        expectedCourses.add("TEST_1");
        expectedCourses.add("TEST_2");
        expectedCourses.add("TEST_3");
        expectedGrades.add(3.1);
        expectedGrades.add(3.2);
        expectedGrades.add(3.3);
    }

    @Test
    public void constructorTest() {
        assertEquals("Wrong  student's name", testName, testTranscript.getStudentName());
        assertEquals("Wrong student's id", testStudentId, testTranscript.getStudentId());
    }

    @Test
    public void addOneGrade() {
        String courseName = "TEST_1";
        Double courseGrade = 3.0;
        testTranscript.addGrade(courseName, courseGrade);
        assertEquals(1, testTranscript.getGrades().size());
        assertEquals(1, testTranscript.getCourses().size());
        assertEquals(courseName, testTranscript.getCourses().get(0));
        assertEquals(3.0, testTranscript.getGrades().get(0));
    }

    @Test
    public void addThreeGradesTest() {

        addThreeGrades();

        assertEquals(3, testTranscript.getCourses().size());
        assertEquals(3, testTranscript.getGrades().size());

        for (int i = 0; i < 3; i++) {
            assertEquals(expectedCourses.get(i), testTranscript.getCourses().get(i));
            assertEquals(expectedGrades.get(i), testTranscript.getGrades().get(i));
        }
    }

    @Test
    public void updateExistingGrade() {

        addThreeGrades();

        expectedGrades.set(1, 4.2);
        testTranscript.addGrade(expectedCourses.get(1), expectedGrades.get(1));

        assertEquals(3, testTranscript.getCourses().size());
        assertEquals(3, testTranscript.getGrades().size());

        for (int i = 0; i < 3; i++) {
            assertEquals(expectedCourses.get(i), testTranscript.getCourses().get(i));
            assertEquals(expectedGrades.get(i), testTranscript.getGrades().get(i));
        }
    }

    @Test
    public void addExistingGrade() {

        addThreeGrades();

        testTranscript.addGrade(expectedCourses.get(1), expectedGrades.get(1));

        assertEquals(3, testTranscript.getCourses().size());
        assertEquals(3, testTranscript.getGrades().size());

        for (int i = 0; i < 3; i++) {
            assertEquals(expectedCourses.get(i), testTranscript.getCourses().get(i));
            assertEquals(expectedGrades.get(i), testTranscript.getGrades().get(i));
        }
    }

    @Test
    public void removeGrade() {
        addThreeGrades();

        testTranscript.removeGrade(expectedCourses.get(1));

        expectedGrades.remove(1);
        expectedCourses.remove(1);

        assertEquals(2, testTranscript.getCourses().size());
        assertEquals(2, testTranscript.getGrades().size());

        for (int i = 0; i < 2; i++) {
            assertEquals(expectedCourses.get(i), testTranscript.getCourses().get(i));
            assertEquals(expectedGrades.get(i), testTranscript.getGrades().get(i));
        }
    }
}