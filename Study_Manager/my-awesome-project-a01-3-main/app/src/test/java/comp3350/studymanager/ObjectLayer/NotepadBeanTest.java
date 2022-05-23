package comp3350.studymanager.ObjectLayer;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import comp3350.studymanager.Object.NotepadBean;


public class NotepadBeanTest
{
    @Test
    public void testNotepadBean(){
        NotepadBean notepadBean;

        System.out.println("\nStarting NoteBean");
        notepadBean = new NotepadBean(1, "123", "2022");
        assertNotNull(notepadBean);
        notepadBean.setId(2);
        assertTrue((notepadBean.getId()) == 2);
        notepadBean.setNotepadContent("abc");
        assertTrue("abc".equals(notepadBean.getNotepadContent()));
        notepadBean.setNotepadTime("2022");
        assertTrue("2022".equals(notepadBean.getNotepadTime()));


        System.out.println("Finished");

    }


}
