package comp3350.studymanager.Persistence;
import comp3350.studymanager.Object.User;

public interface userPersistence {

        boolean addUser(User currentUser);
        User getUser(final User user);
        boolean searchUser(final User user);
        void deleteUser(final User user);


}
