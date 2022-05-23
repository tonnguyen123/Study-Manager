package comp3350.studymanager.Persistence.hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import comp3350.studymanager.Object.Event;
import comp3350.studymanager.Persistence.EventPersistence;

public class EventHSQLDB implements EventPersistence
{
    private final String databasePath;

    public EventHSQLDB(final String dbPath) {
        this.databasePath = dbPath;
    }

    public Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + databasePath + ";shutdown=true", "SA", "");
    }

    public boolean addEvent(Event currentEvent){
        boolean result = false;
        if(currentEvent != null){
            try(final Connection c = connection()){
                PreparedStatement preparedStatement = c.prepareStatement("INSERT INTO event VALUES (?, ?, ?, ?)");
               preparedStatement.setString(1, currentEvent.NoteCreated);
               preparedStatement.setString(2, currentEvent.date);
               preparedStatement.setString(3, currentEvent.month);
               preparedStatement.setString(4, currentEvent.year);

                preparedStatement.executeUpdate();
                result = true;


            }
            catch (final SQLException e) {
                throw new persistenceException(e);
            }
        }
        return result;

    }

    @Override
    public ArrayList<Event> getEvent(String year, String month, String day) {
        final ArrayList<Event> EventsOfDay = new ArrayList<>();
        try(final Connection c = connection()){
            final PreparedStatement st = c.prepareStatement("SELECT * FROM event WHERE day = ? AND mont = ? AND year = ?");
            st.setString(1, day);
            st.setString(2,month);
            st.setString(3,year);

            final ResultSet rs = st.executeQuery();

            while(rs.next()){
                final Event eventFromTable = fromResult(rs);
                EventsOfDay.add(eventFromTable);
            }
            rs.close();
            st.close();
            return EventsOfDay;

        }

        catch (final SQLException e) {
            throw new persistenceException(e);
        }

    }

    @Override
    public ArrayList<Event> listAllEvents(){
        final ArrayList<Event> EventsOfDay = new ArrayList<>();
        try(final Connection c = connection()){
            final Statement st = c.createStatement();


            final ResultSet rs = st.executeQuery("SELECT * FROM EVENT");

            while(rs.next()){
                final Event eventFromTable = fromResult(rs);
                EventsOfDay.add(eventFromTable);
            }
            rs.close();
            st.close();
            return EventsOfDay;

        }

        catch (final SQLException e) {
            throw new persistenceException(e);
        }

    }

    @Override
    public boolean deleteEvent(Event remove) {

        //Log.d("remove event day is ", remove.date);
        try (final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("DELETE FROM event WHERE note = ? AND day = ? AND mont = ? AND year = ?");
            st.setString(1, remove.NoteCreated);
            st.setString(2, remove.date);
            st.setString(3, remove.month);
            st.setString(4, remove.year);
            st.executeUpdate();

        } catch (final SQLException e) {
            throw new persistenceException(e);
        }
        return true;
    }

    private Event fromResult(final ResultSet rs) throws SQLException{
        final String NOTE = rs.getString("note");
        final String DAY = rs.getString("day");
        final String MONTH = rs.getString("mont");
        final String YEAR = rs.getString("year");


        return new Event(NOTE,YEAR,MONTH,DAY);

    }

}
