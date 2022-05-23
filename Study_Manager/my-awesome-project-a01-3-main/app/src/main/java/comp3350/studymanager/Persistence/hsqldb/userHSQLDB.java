
package comp3350.studymanager.Persistence.hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import comp3350.studymanager.Object.User;
import comp3350.studymanager.Persistence.userPersistence;


public class userHSQLDB implements userPersistence {

    private final String databasePath;

    public userHSQLDB(final String dbPath) {
        this.databasePath = dbPath;
    }

    public Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + databasePath + ";shutdown=true", "SA", "");
    }

    @Override
    public boolean addUser(final User user) {
        if(user != null) {
            try (final Connection c = connection()) {
                final PreparedStatement st = c.prepareStatement("INSERT INTO user VALUES(?, ?)");
                st.setString(1, user.getUsername());
                st.setString(2, user.getPassword());


                st.executeUpdate();
                return true;
            } catch (final SQLException e) {
                throw new persistenceException(e);
            }
        }
        return false;
    }

    @Override
    public User getUser(final User user) {
        String userID=user.getUsername();
        String pwd=user.getPassword();
        if(!userID.isEmpty() || pwd.length() == 0){
            try (final Connection c = connection()) {

                final PreparedStatement st = c.prepareStatement("SELECT * FROM user WHERE USERNAME=? AND PASSWORD=?");
                st.setString(1,userID);
                st.setString(2,pwd);

                final ResultSet rs = st.executeQuery();
                User temp = null;
                while (rs.next()){
                    temp = fromResult(rs);

                }
                return temp;
            } catch (final SQLException e) {
                throw new persistenceException(e);
            }
        }
        return null;
    }

    @Override
    public boolean searchUser( final User user) {
        String userID=user.getUsername();
        String pwd=user.getPassword();
        if(!userID.isEmpty() || pwd.length() == 0){
            try (final Connection c = connection()) {
                final PreparedStatement st = c.prepareStatement("SELECT * FROM user WHERE username=? AND PASSWORD=?");
                st.setString(1,userID);
                st.setString(2,pwd);

                final ResultSet rs = st.executeQuery();
                User temp = null;
                while(rs.next()){
                    temp = fromResult(rs);
                }
                rs.close();
                st.close();
                if (temp != null && temp.getUsername().equalsIgnoreCase(userID)){
                    return true;
                }
                if (temp != null && temp.getUsername().equalsIgnoreCase(pwd)){
                    return true;
                }
            } catch (final SQLException e) {
                throw new persistenceException(e);
            }
        }
        return false;
    }

    @Override
    public void deleteUser(final User user) {
        String userID=user.getUsername();
        String pwd=user.getPassword();
        if(!userID.isEmpty() || pwd.length() == 0){
            try (final Connection c = connection()) {
                final PreparedStatement st = c.prepareStatement("DELETE FROM user WHERE USERNAME=? AND PASSWORD=?");
                st.setString(1,userID);
                st.setString(2,pwd);
                st.executeUpdate();
            } catch (final SQLException e) {
                throw new persistenceException(e);
            }
        }
    }




    private User fromResult(final ResultSet rs) throws SQLException{
        final String email = rs.getString("username");
        final String password = rs.getString("password");


        return new User(email,password);

    }


}


