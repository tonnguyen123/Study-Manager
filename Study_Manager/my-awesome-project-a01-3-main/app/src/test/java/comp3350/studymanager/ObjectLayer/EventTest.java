package comp3350.studymanager.ObjectLayer;

import org.junit.Assert;
import org.junit.Test;

import comp3350.studymanager.Object.Event;


public class EventTest {

    @Test
    public void checkObject(){
        Event test = new Event("abcd","2022","04","05");

        Assert.assertEquals("abcd",test.NoteCreated);
        Assert.assertEquals("2022",test.year);
        Assert.assertEquals("04",test.month);
        Assert.assertEquals("05",test.date);

        Event test2 = new Event("cdef", "2022", "06", "15");
        Assert.assertNotEquals(test2,test);

        test.setYear("2030");
        test.setDate("10");
        test.setMth("5");

        Assert.assertEquals("2030",test.year);
        Assert.assertEquals("10",test.date);
        Assert.assertEquals("5",test.month);

    }
}
