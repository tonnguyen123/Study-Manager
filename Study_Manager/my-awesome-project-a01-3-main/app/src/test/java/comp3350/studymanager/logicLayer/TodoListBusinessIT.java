package comp3350.studymanager.logicLayer;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import comp3350.studymanager.Object.Task;
import comp3350.studymanager.Persistence.TodoListPersistence;
import comp3350.studymanager.Persistence.hsqldb.TodoListPersistenceHSQLDB;
import comp3350.studymanager.logic.TodoListBusiness;
import comp3350.studymanager.utils.TestUtils;

public class TodoListBusinessIT {
    private TodoListBusiness todoBusiness;
    private File tempDB;
    private List<Map<String, String>> list = new ArrayList<>();

    @Before
    public void setUp() throws IOException {
        this.tempDB = TestUtils.copyDB();
        final TodoListPersistence persistence = new TodoListPersistenceHSQLDB(this.tempDB.getAbsolutePath().replace(".script", ""));
        this.todoBusiness = new TodoListBusiness(persistence);
    }
    @Test
    public void testInsert() {

        todoBusiness.addList(new Task(1,"abc","abc"));
        todoBusiness.addList(new Task(2,"abc","abc"));
        todoBusiness.addList(new Task(3,"abc","abc"));
        list = todoBusiness.getData(list);
        assertEquals(3, list.size());
    }

    @Test
    public void testDelete() {
        todoBusiness.deleteList("1");
        list = todoBusiness.getData(list);
        assertEquals(0, list.size());
    }


    @Test
    public void testUpdate(){
        todoBusiness.altStatue("1","1");
        list = todoBusiness.getData(list);
        assertEquals(0, list.size());
    }

}
