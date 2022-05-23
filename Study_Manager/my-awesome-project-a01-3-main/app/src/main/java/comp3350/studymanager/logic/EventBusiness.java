package comp3350.studymanager.logic;

import java.util.ArrayList;

import comp3350.studymanager.Object.Event;
import comp3350.studymanager.Persistence.EventPersistence;

public class EventBusiness {


    private EventPersistence eventCheck;

    public EventBusiness() {
        eventCheck = AccessServices.getEventInterface();
    }

    public EventBusiness(final EventPersistence eventCheck) {
        this();
        this.eventCheck = eventCheck;
    }


    public boolean addEvent(Event newEvent) {
        return eventCheck.addEvent(newEvent);
    }

    public ArrayList<Event> listAllEvents() {
        return eventCheck.listAllEvents();
    }

    public void deleteEvent(Event removedEvent) {
        eventCheck.deleteEvent(removedEvent);
    }
}
