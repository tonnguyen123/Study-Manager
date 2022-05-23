package comp3350.studymanager.logic;

public class Main {

    private static String dbName = "database";


    public static void main(String [] args){
        System.out.println("Testing my database connection!");
    }
    public static void setDBPathName(final String name) {
        try {
            Class.forName("org.hsqldb.jdbcDriver").newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        dbName = name;

    }

    public static String getDBPathName() {
        return dbName;
    }



}
