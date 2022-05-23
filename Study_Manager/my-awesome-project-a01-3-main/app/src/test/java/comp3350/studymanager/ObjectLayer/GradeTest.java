package comp3350.studymanager.ObjectLayer;

import org.junit.Assert;
import org.junit.Test;

import comp3350.studymanager.Object.Grade;

public class GradeTest {
    Grade testGrade = new Grade("COMP3350", "Midterm", 80, 40);
    @Test
    public void testConstructor(){


        Assert.assertNotNull(testGrade);
        Assert.assertEquals("COMP3350",testGrade.getGradeCourse());
        Assert.assertEquals("Midterm",testGrade.getGName());
        Assert.assertEquals(80,testGrade.getActGrade());
        Assert.assertEquals(40,testGrade.getGradePercent());
    }

    @Test
    public void testSetMethod(){
        testGrade.setActGrade(90);
        Assert.assertEquals(90,testGrade.getActGrade());

        testGrade.setGName("quiz");
        Assert.assertEquals("quiz",testGrade.getGName());

        testGrade.setGradePercent(80);
        Assert.assertEquals(80,testGrade.getGradePercent());

        testGrade.setCourseName("COMP1020");
        Assert.assertNotEquals("COMP3350",testGrade.getGradeCourse());

    }
}
