package comp3350.studymanager.Persistence;
import java.util.ArrayList;

import comp3350.studymanager.Object.Event;

public interface EventPersistence {
    boolean addEvent(Event currentEvent);
    ArrayList<Event> getEvent(final String year, String month, String day);
    ArrayList<Event> listAllEvents();
    boolean deleteEvent(Event remove);
}
