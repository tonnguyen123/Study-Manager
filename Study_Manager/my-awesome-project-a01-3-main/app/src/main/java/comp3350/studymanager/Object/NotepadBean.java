package comp3350.studymanager.Object;

import androidx.annotation.NonNull;

public class NotepadBean {
    private int id;
    private String notepadContent;
    private String notepadTime;

    public NotepadBean(int id, String notepadContent, String notepadTime) {
        this.id = id;
        this.notepadContent = notepadContent;
        this.notepadTime = notepadTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNotepadContent() {

        return notepadContent;
    }

    public void setNotepadContent(String notepadContent) {

        this.notepadContent = notepadContent;
    }

    public String getNotepadTime() {

        return notepadTime;
    }

    public void setNotepadTime(String notepadTime) {

        this.notepadTime = notepadTime;
    }

    @NonNull
    @Override
    public String toString() {
        return "NotepadBean{" +
                "id=" + id +
                ", notepadContent='" + notepadContent + '\'' +
                ", notepadTime='" + notepadTime + '\'' +
                '}';
    }
}
