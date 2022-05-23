package comp3350.studymanager.Persistence;


import java.util.List;

import comp3350.studymanager.Object.NotepadBean;

public interface NotePersistence {
    List<NotepadBean> query();

    boolean updateData(int id, String content, String userYear);
    boolean deleteData(int id);
    NotepadBean insertData(String userContent, String userTime);
}
