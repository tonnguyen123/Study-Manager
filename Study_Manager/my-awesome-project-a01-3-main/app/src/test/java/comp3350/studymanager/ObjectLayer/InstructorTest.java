package comp3350.studymanager.ObjectLayer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

import comp3350.studymanager.Object.Instructor;

public class InstructorTest {
    @Test
    public void constructorTest() {
        Instructor newInstructor = new Instructor("Heather", "Matheson");
        assertNotNull(newInstructor);
        assertEquals("Heather", newInstructor.getFirstName());
        assertEquals("Matheson", newInstructor.getLastName());
        System.out.println("Passed InstructorTest's Constructor Test");
    }

    @Test
    public void testEquals() {
        Instructor newInstructor1 = new Instructor("Heather", "Matheson");
        Instructor newInstructor2 = new Instructor("Heather", "Matheson");
        Instructor newInstructor3 = new Instructor("Jon", "Boisvert");
        Instructor newInstructor4 = new Instructor("Heather", "Matheson");

        assertNotNull(newInstructor1);
        assertNotNull(newInstructor2);
        assertNotNull(newInstructor3);
        assertNotNull(newInstructor4);
        assertTrue((newInstructor1.equals(newInstructor1)));
        assertFalse(newInstructor1.equals(newInstructor2));
        assertFalse(newInstructor1.equals(newInstructor3));
        assertFalse(newInstructor1.equals(newInstructor4));
        assertTrue(newInstructor1.getFirstName().equals(newInstructor2.getFirstName()));
        assertFalse(newInstructor1.getFirstName().equals(newInstructor3.getFirstName()));
        assertTrue(newInstructor1.getFirstName().equals(newInstructor4.getFirstName()));
        System.out.println("Passed InstructorTest's testEquals method");
    }
}
