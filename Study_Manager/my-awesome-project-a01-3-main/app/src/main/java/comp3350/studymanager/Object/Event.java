package comp3350.studymanager.Object;

public class Event {
    public String year;
    public String month;
    public String date;
    public String NoteCreated;


    public Event (String note,String yr, String mo, String day){
        year = yr;
        month = mo;
        date = day;
        NoteCreated = note;
    }

    public void setYear(String Y){
        year = Y;
    }

    public void setMth(String M){
        month = M;
    }

    public void setDate(String D){
        date = D;
    }
}
