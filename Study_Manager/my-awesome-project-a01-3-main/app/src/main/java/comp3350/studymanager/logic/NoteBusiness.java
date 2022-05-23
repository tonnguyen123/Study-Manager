package comp3350.studymanager.logic;

import java.util.List;

import comp3350.studymanager.Object.NotepadBean;
import comp3350.studymanager.Persistence.NotePersistence;

public class NoteBusiness {
    private NotePersistence notePersistence;

    public NoteBusiness() {
        notePersistence = AccessServices.getNotePersistence();
    }

    public NoteBusiness(final NotePersistence notePersistence) {
        this();
        this.notePersistence = notePersistence;
    }

    public List<NotepadBean> query() {
        return notePersistence.query();
    }

    public boolean deleteData(int id) {
        return notePersistence.deleteData(id);
    }

    public boolean updateData(int id, String noteContent, String time) {
        return notePersistence.updateData(id, noteContent, time);
    }

    public NotepadBean insertData(String noteContent, String time) {
        return notePersistence.insertData(noteContent, time);
    }
}
