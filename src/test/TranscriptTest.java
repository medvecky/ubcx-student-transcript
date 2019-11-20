package test;

import junit.framework.TestCase;
import model.Transcript;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class TranscriptTest {

    private Transcript testTranscript;
    private String testName = "John Dow";
    private int testStudentId = 1;


    @Before
    public void setUp() {
        testTranscript = new Transcript(testName, testStudentId);
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

}