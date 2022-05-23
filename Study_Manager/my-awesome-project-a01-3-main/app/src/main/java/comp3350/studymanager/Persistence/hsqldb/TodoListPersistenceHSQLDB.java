package comp3350.studymanager.Persistence.hsqldb;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import comp3350.studymanager.Object.Task;
import comp3350.studymanager.Persistence.TodoListPersistence;

public class TodoListPersistenceHSQLDB implements TodoListPersistence {

    private final String dbPath;

    public TodoListPersistenceHSQLDB(String dbPath) {
        this.dbPath = dbPath;
    }

    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "SA", "");
    }

    public boolean deleteList(String id){
        try (final Connection c = connection()) {
            PreparedStatement preparedStatement = c.prepareStatement("DELETE FROM task WHERE id = ?");
            preparedStatement.setInt(1, Integer.parseInt(id));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
    public boolean altStatue(String s, String id) {
        try (final Connection c = connection()) {
            PreparedStatement preparedStatement = c.prepareStatement("UPDATE task SET statue = ? WHERE id = ?");
            preparedStatement.setString(1, s);
            preparedStatement.setInt(2, Integer.parseInt(id));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }



    public boolean addList(Task note){

        try (final Connection c = connection()) {
            PreparedStatement preparedStatement = c.prepareStatement("insert into task (name,statue) values(?,?)");
            preparedStatement.setString(1, note.getName());
            preparedStatement.setString(2, note.getStatue());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public List<Map<String,String>> getData(List<Map<String, String>> list){

        try (final Connection c = connection()) {
            PreparedStatement preparedStatement = c.prepareStatement("select * from task order by id desc");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Map<String,String> map = new HashMap<>();
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String statue = resultSet.getString(3);
                map.put("name",name);
                map.put("statue",statue);
                map.put("id",id+"");
                list.add(map);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
