package comp3350.studymanager.Persistence.hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import comp3350.studymanager.Object.Course;
import comp3350.studymanager.Persistence.AddedCoursePersistence;

public class AddedCourseHSQLDB implements AddedCoursePersistence {
    private final String databasePath;

    public AddedCourseHSQLDB(String databasePath) {
        this.databasePath = databasePath;
    }

    public Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + databasePath + ";shutdown=true", "SA", "");
    }
    @Override
    public void addCourse(Course currentCourse) {
        if(currentCourse != null) {
            try (final Connection c = connection()) {
                final PreparedStatement st = c.prepareStatement("INSERT INTO addedcourse VALUES (?, ?, ?, ?)");
                st.setString(1, currentCourse.getCourseCode());
                st.setString(2, currentCourse.getCourseName());
                st.setString(3, currentCourse.getInstructorName());
                st.setString(4, currentCourse.getSection());

                st.executeUpdate();
            } catch (final SQLException e) {
                throw new persistenceException(e);
            }
        }
    }

    @Override
    public ArrayList<Course> getAddedCourseList() {
        final ArrayList<Course> EventsOfDay = new ArrayList<>();
        try(final Connection c = connection()){
            final Statement st = c.createStatement();


            final ResultSet rs = st.executeQuery("SELECT * FROM ADDEDCOURSE");

            while(rs.next()){
                final Course eventFromTable = fromResult(rs);
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

    private Course fromResult(final ResultSet rs) throws SQLException{
        final String coursecode = rs.getString("coursecode");
        final String coursename = rs.getString("coursename");
        final String instructorname = rs.getString("instructorname");
        final String section = rs.getString("section");


        return new Course(coursecode,coursename,instructorname,section);

    }

    @Override
    public boolean deleteCourse(Course remove) {
        try (final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("DELETE FROM course WHERE  coursecode= ? AND coursename = ? AND instructorname = ? AND section = ?");
            st.setString(1, remove.getCourseCode());
            st.setString(2, remove.getCourseName());
            st.setString(3, remove.getInstructorName());
            st.setString(4, remove.getSection());
            st.executeUpdate();

        } catch (final SQLException e) {
            throw new persistenceException(e);
        }
        return true;
    }

}
