package comp3350.studymanager.logic;

import comp3350.studymanager.Persistence.AddedCoursePersistence;
import comp3350.studymanager.Persistence.CoursePersistence;
import comp3350.studymanager.Persistence.EventPersistence;
import comp3350.studymanager.Persistence.GradePersistence;
import comp3350.studymanager.Persistence.NotePersistence;
import comp3350.studymanager.Persistence.TodoListPersistence;
import comp3350.studymanager.Persistence.hsqldb.AddedCourseHSQLDB;
import comp3350.studymanager.Persistence.hsqldb.CourseHSQLDB;
import comp3350.studymanager.Persistence.hsqldb.EventHSQLDB;
import comp3350.studymanager.Persistence.hsqldb.GradeHSQLDB;
import comp3350.studymanager.Persistence.hsqldb.NotePersistenceHSQLDB;
import comp3350.studymanager.Persistence.hsqldb.TodoListPersistenceHSQLDB;
import comp3350.studymanager.Persistence.hsqldb.userHSQLDB;
import comp3350.studymanager.Persistence.userPersistence;


public class AccessServices {


    private static userPersistence registerInterface = null;
    private static EventPersistence noteInterface = null;
    private static NotePersistence notePersistence = null;
    private static CoursePersistence coursePersistence = null;
    private static AddedCoursePersistence addedCoursePersistence = null;
    private static GradePersistence gradePersistence = null;
    private static TodoListPersistence todoListPersistence = null;


    public static synchronized userPersistence getRegisterInterface() {
        if (registerInterface == null) {

            registerInterface = new userHSQLDB(Main.getDBPathName());

        }
        return registerInterface;
    }

    public static synchronized GradePersistence getGradePersistence(){
        if(gradePersistence == null){
            gradePersistence = new GradeHSQLDB(Main.getDBPathName());
        }
        return gradePersistence;
    }

    public static synchronized EventPersistence getEventInterface() {
        if (noteInterface == null) {

            noteInterface = new EventHSQLDB(Main.getDBPathName());

        }
        return noteInterface;
    }


    public static synchronized NotePersistence getNotePersistence() {
        if (notePersistence == null) {
            notePersistence = new NotePersistenceHSQLDB(Main.getDBPathName());
        }
        return notePersistence;
    }

    public static synchronized CoursePersistence getCoursePersistence() {
        if (coursePersistence == null) {

            coursePersistence = new CourseHSQLDB(Main.getDBPathName());

        }
        return coursePersistence;
    }

    public static synchronized AddedCoursePersistence getAddedCoursePersistence() {
        if (addedCoursePersistence == null)
            addedCoursePersistence = new AddedCourseHSQLDB(Main.getDBPathName());
        return addedCoursePersistence;
    }

    public static synchronized TodoListPersistence getTodoListPersistence() {
        if (todoListPersistence == null) {
            todoListPersistence = new TodoListPersistenceHSQLDB(Main.getDBPathName());
        }
        return todoListPersistence;
    }

}
