package comp3350.studymanager.Persistence.hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import comp3350.studymanager.Object.Grade;
import comp3350.studymanager.Persistence.GradePersistence;

public class GradeHSQLDB implements GradePersistence {
    private final String databasePath;

    public GradeHSQLDB(final String dbPath) {
        this.databasePath = dbPath;
    }

    public Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + databasePath + ";shutdown=true", "SA", "");
    }

    @Override
    public void addGrade(Grade grade) {
        boolean result = false;
        if(grade != null){
            try(final Connection c = connection()){
                PreparedStatement preparedStatement = c.prepareStatement("INSERT INTO grade VALUES (?, ?, ?, ?)");
                preparedStatement.setString(1, grade.courseName);
                preparedStatement.setString(2, grade.GName);
                preparedStatement.setInt(3, grade.ActGrade);
                preparedStatement.setInt(4, grade.gradePercent);


                preparedStatement.executeUpdate();
                result = true;
                c.close();
                preparedStatement.close();


            }
            catch (final SQLException e) {
                throw new persistenceException(e);
            }
        }
    }

    @Override
    public ArrayList<Grade> getGradeList(String course) {
        ArrayList<Grade> GradesOfCourse = new ArrayList<>();
        try(final Connection c = connection()){
            final PreparedStatement st = c.prepareStatement("SELECT * FROM grade WHERE course = ?");
            st.setString(1, course);


            final ResultSet rs = st.executeQuery();

            while(rs.next()){
                final Grade GradeFromTable = fromResult(rs);
                GradesOfCourse.add(GradeFromTable);
            }
            rs.close();
            st.close();
            return GradesOfCourse;

        }

        catch (final SQLException e) {
            throw new persistenceException(e);
        }
    }

    @Override
    public void deleteGradesofCourse(String removeedCourse) {

        try (final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("DELETE FROM grade WHERE course = ?");
            st.setString(1, removeedCourse);

            st.executeUpdate();

            c.close();
            st.close();

        } catch (final SQLException e) {
            throw new persistenceException(e);
        }
    }

    private Grade fromResult(final ResultSet rs) throws SQLException{
        final String Course = rs.getString("course");
        final String GradeName = rs.getString("grenade");
        final int EarnedGrade = rs.getInt("earned");
        final int GradePercentage = rs.getInt("percentage");


        return new Grade(Course,GradeName,EarnedGrade,GradePercentage);

    }
}
