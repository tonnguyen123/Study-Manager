package comp3350.studymanager.logicLayer;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import comp3350.studymanager.Object.NotepadBean;
import comp3350.studymanager.Persistence.NotePersistence;
import comp3350.studymanager.logic.NoteBusiness;


public class NoteBusinessTest {
    private NoteBusiness noteBusiness;
    private NotePersistence notePersistence;

    @Before
    public void setUp() {
        notePersistence = mock(NotePersistence.class);
        noteBusiness = new NoteBusiness(notePersistence);
    }

    @Test
    public void test1(){
        final NotepadBean notepadBean;

        System.out.println("\nStarting test NoteBusiness");
           final List<NotepadBean> notepadBeans = new ArrayList<>();
           notepadBeans.add(new NotepadBean(1,"testNote","2022"));
           when(notePersistence.query()).thenReturn(notepadBeans);
           assertNotNull(notepadBeans);

        System.out.println("Finished test NoteBusiness");

    }

}
