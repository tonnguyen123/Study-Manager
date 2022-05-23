package comp3350.studymanager.logic;

import java.util.List;
import java.util.Map;

import comp3350.studymanager.Object.Task;
import comp3350.studymanager.Persistence.TodoListPersistence;


public class TodoListBusiness {

    private TodoListPersistence todoListPersistence;

    public TodoListBusiness() {
        todoListPersistence = AccessServices.getTodoListPersistence();
    }

    public TodoListBusiness(final TodoListPersistence todoListPersistence) {
        this();
        this.todoListPersistence = todoListPersistence;
    }

    public boolean deleteList(String id){
        return todoListPersistence.deleteList(id);
    }
    public boolean altStatue(String s, String id) {
        return todoListPersistence.altStatue(s,id);
    }
    public boolean addList(Task note){
        return todoListPersistence.addList(note);
    }

    public List<Map<String, String>> getData(List<Map<String, String>> list) {
        return todoListPersistence.getData( list);
    }
}
