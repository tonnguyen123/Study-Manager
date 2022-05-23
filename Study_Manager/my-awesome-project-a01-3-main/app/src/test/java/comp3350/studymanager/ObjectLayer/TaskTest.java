package comp3350.studymanager.ObjectLayer;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import comp3350.studymanager.Object.Task;


public class TaskTest
{
    @Test
    public void testNotepadBean(){
        Task task;

        System.out.println("\nStarting NoteBean");
        task = new Task();
        task = new Task(1,"a","b");
        assertNotNull(task);
        task.setId(2);
        assertTrue((task.getId()) == 2);
        task.setName("abc");
        assertTrue("abc".equals(task.getName()));
        task.setStatue("213");
        assertTrue("213".equals(task.getStatue()));


        System.out.println("Finished");

    }


}
