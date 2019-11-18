package test;
import model.Transcript;
import org.junit.Before;
import org.junit.Test;

public class TranscriptTest {

    private Transcript testTranscript;

    @Before
    public void setUp(){
        testTranscript = new Transcript("Student Name", 1000);
        //TODO: write new values in testTranscript constructor
    }

    @Test
    public void testTemplate(){
        //TODO: write tests for Transcript methods
    }
}