package comp3350.studymanager.Persistence.hsqldb;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import comp3350.studymanager.Object.Course;
import comp3350.studymanager.Object.Event;
import comp3350.studymanager.Persistence.CoursePersistence;

public class CourseHSQLDB implements CoursePersistence {
    private final String databasePath;

    public CourseHSQLDB(final String dbPath) {
        this.databasePath = dbPath;
    }

    public Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + databasePath + ";shutdown=true", "SA", "");
    }
    @Override
    public void addCourse(ArrayList<Course> currentCourse) {
        if(currentCourse != null) {
            try (final Connection c = connection()) {
                for (int i = 0; i < currentCourse.size(); i++) {
                    final PreparedStatement st = c.prepareStatement("INSERT INTO course VALUES (?, ?, ?, ?)");
                    st.setString(1, currentCourse.get(i).getCourseCode());
                    st.setString(2, currentCourse.get(i).getCourseName());
                    st.setString(3, currentCourse.get(i).getInstructorName());
                    st.setString(4, currentCourse.get(i).getSection());

                    st.executeUpdate();
                }
            } catch (final SQLException e) {
                throw new persistenceException(e);
            }
        }
    }

    @Override
    public ArrayList<Course> listAllCourses() {

        final ArrayList<Course> EventsOfDay = new ArrayList<>();
        try(final Connection c = connection()){
            final Statement st = c.createStatement();


            final ResultSet rs = st.executeQuery("SELECT * FROM COURSE");

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

        //Log.d("remove event day is ", remove.date);
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