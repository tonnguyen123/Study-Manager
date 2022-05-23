
package comp3350.studymanager.persistenceLayer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import comp3350.studymanager.Object.NotepadBean;
import comp3350.studymanager.Persistence.NotePersistence;

public class NotePersistenceStub implements NotePersistence {
    private List<NotepadBean> notepadBeans;

    public NotePersistenceStub(){
        this.notepadBeans = new ArrayList<>();
        notepadBeans.add(new NotepadBean(1,"note1","2022"));
        notepadBeans.add(new NotepadBean(2,"note2","2022"));
        notepadBeans.add(new NotepadBean(3,"note3","2022"));
        notepadBeans.add(new NotepadBean(4,"note4","2022"));
    }


    @Override
    public List<NotepadBean> query() {

        return Collections.unmodifiableList(notepadBeans);
    }

    @Override
    public boolean updateData(int id, String content, String userYear) {
        int index = -1;

        for(int i = 0; i < notepadBeans.size();i++){
            if(notepadBeans.get(i).getId() == id){
                index = i;
                break;
            }
        }

        if(index >=0 ){
            notepadBeans.set(index, new NotepadBean(id, content,userYear));
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteData(int id) {
        int index = -1;

        for(int i = 0; i < notepadBeans.size();i++){
            if(notepadBeans.get(i).getId() == id){
                index = i;
                break;
            }
        }
        if(index >=0){
            notepadBeans.remove(index);
            return true;
        }
        return false;
    }

    @Override
    public NotepadBean insertData(String userContent, String userTime) {
        NotepadBean notepadBean = new NotepadBean(notepadBeans.get(notepadBeans.size() - 1).getId(), userContent, userTime);
        notepadBeans.add(notepadBean);
        return notepadBean;
    }
}