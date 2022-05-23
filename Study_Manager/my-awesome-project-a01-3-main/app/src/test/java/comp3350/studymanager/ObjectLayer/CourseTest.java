package comp3350.studymanager.ObjectLayer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import comp3350.studymanager.Object.Course;


public class CourseTest {
    @Test
    public void constructorTest() {
        Course newCourse = new Course("1010", "Intro Computer Science", "Heather Matheson", "A01");

        assertNotNull(newCourse);
        assertTrue("Intro Computer Science".equals(newCourse.getCourseName()));
        assertEquals("1010", newCourse.getCourseCode());
        assertTrue("Heather Matheson".equals(newCourse.getInstructorName()));
        assertTrue("A01".equals(newCourse.getSection()));
        System.out.println("Passed CourseTest's Constructor Test");
    }
    @Test
    public void testEquals() {
        Course newCourse1 = new Course("1010", "INTRO TO COMP SCI", "Heather Matheson", "A01");
        Course newCourse2 = new Course("1010", "INTRO TO COMP SCI", "Heather Matheson", "A01");
        Course newCourse3 = new Course("1020", "INTRO TO COMP SCI", "Heather Matheson", "A01");

        assertNotNull(newCourse1);
        assertNotNull(newCourse2);
        assertFalse(newCourse1.equals(newCourse3));
        assertTrue(newCourse1.getCourseName().equals(newCourse2.getCourseName()));
        assertEquals(newCourse1.getCourseCode(),(newCourse2.getCourseCode()));
        assertTrue(newCourse1.getInstructorName().equals(newCourse2.getInstructorName()));
        assertNotEquals(newCourse1.getCourseCode(),(newCourse3.getCourseCode()));
        System.out.println("Passed CourseTest's testEquals method");
    }
}
