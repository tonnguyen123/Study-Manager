package comp3350.studymanager.Persistence;

import java.util.List;
import java.util.Map;

import comp3350.studymanager.Object.Task;

public interface TodoListPersistence {

    public boolean deleteList(String id);
    public boolean altStatue(String s, String id);
    public boolean addList(Task note);

    public List<Map<String,String>> getData(List<Map<String, String>> list);

}
