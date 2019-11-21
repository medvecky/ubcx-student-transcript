package test;

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
    public void testAddOneGrade() {
        String courseName = "TEST_1";
        Double courseGrade = 3.0;
        testTranscript.addGrade(courseName, courseGrade);
        assertEquals(1, testTranscript.getGrades().size());
        assertEquals(1, testTranscript.getCourses().size());
        assertEquals(courseName, testTranscript.getCourses().get(0));
        assertEquals(courseGrade, testTranscript.getGrades().get(0));
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

    @Test
    public void testGetCourseAndGrade() {
        addThreeGrades();

        String expectedResult = expectedCourses.get(1) + ": " + expectedGrades.get(1);

        assertEquals(expectedResult, testTranscript.getCourseAndGrade(expectedCourses.get(1)));
    }

    @Test
    public void testGetGpaWithOneRecord() {
        String courseName = "TEST_1";
        Double courseGrade = 3.0;
        testTranscript.addGrade(courseName, courseGrade);

        assertEquals(3.0, testTranscript.getGPA());
    }

    @Test
    public void testGetGpaWithFewRecords() {
        addThreeGrades();

        double expectedResult =
                Math.round(
                        (expectedGrades.stream().mapToDouble(a -> a).sum() / expectedGrades.size()) * 1000.0)
                        / 1000.0;

        assertEquals(expectedResult, testTranscript.getGPA());
    }

    @Test
    public void testGetGradeByCourse() {
        addThreeGrades();
        assertEquals(expectedGrades.get(1), testTranscript.getGradeByCourse(expectedCourses.get(1)));
    }

    @Test
    public void testGetAverageOverSelectedCoursesForFewArgs() {
        addThreeGrades();

        double expectedResult =
                Math.round(
                        (expectedGrades.stream().mapToDouble(a -> a).sum() / expectedGrades.size()) * 1000.0)
                        / 1000.0;

       List<String> args = new ArrayList<>();
       args.add(expectedCourses.get(0));
       args.add(expectedCourses.get(1));
       args.add(expectedCourses.get(2));

       assertEquals(expectedResult, testTranscript.getAverageOverSelectedCourses(args));
    }

    @Test
    public void testGetAverageOverSelectedCoursesForOneArg() {
        String courseName = "TEST_1";
        Double courseGrade = 3.0;
        testTranscript.addGrade(courseName, courseGrade);
        List<String> args = new ArrayList<>();
        args.add(courseName);

        assertEquals(courseGrade, testTranscript.getAverageOverSelectedCourses(args));
    }
}