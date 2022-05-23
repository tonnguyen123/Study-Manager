package comp3350.studymanager.Persistence.hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import comp3350.studymanager.Object.NotepadBean;
import comp3350.studymanager.Persistence.NotePersistence;

public class NotePersistenceHSQLDB implements NotePersistence {

    private final String dbPath;

    public NotePersistenceHSQLDB(String dbPath) {
        this.dbPath = dbPath;
    }

    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "SA", "");
    }

    @Override
    public List<NotepadBean> query() {
//        Log.i("xhh", "query: ");
        List<NotepadBean> list = new ArrayList<>();
        try (final Connection c = connection()) {
            PreparedStatement preparedStatement = c.prepareStatement("select * from note");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String content = resultSet.getString(2);
                String time = resultSet.getString(3);
                NotepadBean notepadBean = new NotepadBean(id, content, time);
                list.add(notepadBean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public boolean updateData(int id, String content, String userYear) {
        try (final Connection c = connection()) {
            PreparedStatement preparedStatement = c.prepareStatement("UPDATE note SET content = ?, time = ? WHERE id = ? ");
            preparedStatement.setString(1, content);
            preparedStatement.setString(2, userYear);
            preparedStatement.setInt(3, id);
            int i = preparedStatement.executeUpdate();
            return i >= 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteData(int id) {
        try (final Connection c = connection()) {
            PreparedStatement preparedStatement = c.prepareStatement("DELETE FROM note WHERE id = ?");
            preparedStatement.setInt(1, id);
            int i = preparedStatement.executeUpdate();
            return i >= 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public NotepadBean insertData(String userContent, String userTime) {


        try (final Connection c = connection()) {
            PreparedStatement preparedStatement = c.prepareStatement("INSERT INTO note (content, time) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, userContent);
            preparedStatement.setString(2, userTime);
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            generatedKeys.next();
            return new NotepadBean(generatedKeys.getInt(1),userContent,userTime);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new NotepadBean(-1,"null","null");
    }
}
