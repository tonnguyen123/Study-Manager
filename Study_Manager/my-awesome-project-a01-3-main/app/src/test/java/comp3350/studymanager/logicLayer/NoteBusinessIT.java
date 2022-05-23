package comp3350.studymanager.logicLayer;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import comp3350.studymanager.Object.NotepadBean;
import comp3350.studymanager.Persistence.NotePersistence;
import comp3350.studymanager.Persistence.hsqldb.NotePersistenceHSQLDB;
import comp3350.studymanager.logic.NoteBusiness;
import comp3350.studymanager.utils.TestUtils;

public class NoteBusinessIT {
    private NoteBusiness noteBusiness;
    private File tempDB;

    @Before
    public void setUp() throws IOException{
        this.tempDB = TestUtils.copyDB();
        final NotePersistence persistence = new NotePersistenceHSQLDB(this.tempDB.getAbsolutePath().replace(".script", ""));
        this.noteBusiness = new NoteBusiness(persistence);
    }

    @Test
    public void testQuery(){
        final List<NotepadBean> notepadBeans = noteBusiness.query();
        assertEquals(0, notepadBeans.size());
    }

    @Test
    public void testDelete() {
        noteBusiness.deleteData(1);
        final List<NotepadBean> notepadBeans = noteBusiness.query();
        assertEquals(0, notepadBeans.size());
    }

    @Test
    public void testInsert() {
        noteBusiness.insertData("aaaa","2222");
        final List<NotepadBean> notepadBeans = noteBusiness.query();
        assertEquals(1, notepadBeans.size());
    }

    @Test
    public void testUpdate() {
        noteBusiness.updateData(1,"abc","2022");
        final List<NotepadBean> notepadBeans = noteBusiness.query();
        assertEquals(0, notepadBeans.size());
    }

}
