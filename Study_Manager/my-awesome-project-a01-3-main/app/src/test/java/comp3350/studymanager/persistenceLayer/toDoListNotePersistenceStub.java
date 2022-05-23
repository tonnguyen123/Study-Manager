package comp3350.studymanager.persistenceLayer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import comp3350.studymanager.Object.Task;
import comp3350.studymanager.Persistence.TodoListPersistence;

public class toDoListNotePersistenceStub implements TodoListPersistence{
    private List<Task> tasks;

    public toDoListNotePersistenceStub(){
        this.tasks = new ArrayList<>();
        tasks.add(new Task(1,"2","1"));
        tasks.add(new Task(2,"2","2"));
        tasks.add(new Task(3,"2","3"));
        tasks.add(new Task(4,"2","4"));
    }
    @Override
    public boolean deleteList(String id) {
        int index = -1;

        for(int i = 0; i < tasks.size();i++){
            if(tasks.get(i).getId() == Integer.parseInt(id)){
                index = i;
                break;
            }
        }
        if(index >=0){
            tasks.remove(index);
            return true;
        }
        return false;
    }

    @Override
    public boolean altStatue(String s, String id) {
        int index = -1;

        for(int i = 0; i < tasks.size();i++){
            if(tasks.get(i).getId() == Integer.parseInt(id)){
                index = i;
                break;
            }
        }

        if(index >=0 ){
            tasks.set(index, new Task(index,"2",s));
            return true;
        }
        return false;
    }

    @Override
    public boolean addList(Task note) {
        return tasks.add(note);
    }

    @Override
    public List<Map<String, String>> getData(List<Map<String, String>> list) {
        list.clear();
        for (int i = 0; i < tasks.size();i++) {
            Map<String,String> map = new HashMap<>();
            int id = tasks.get(i).getId();
            String name = tasks.get(i).getName();
            String statue = tasks.get(i).getStatue();
            map.put("name",name);
            map.put("statue",statue);
            map.put("id",id+"");
            list.add(map);
        }
        return list;
    }

}
