package comp3350.studymanager.persistenceLayer;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import comp3350.studymanager.Object.Course;
import comp3350.studymanager.Object.Event;
import comp3350.studymanager.Object.User;
import comp3350.studymanager.Persistence.AddedCoursePersistence;
import comp3350.studymanager.Persistence.CoursePersistence;
import comp3350.studymanager.Persistence.EventPersistence;
import comp3350.studymanager.Persistence.hsqldb.AddedCourseHSQLDB;
import comp3350.studymanager.Persistence.hsqldb.CourseHSQLDB;
import comp3350.studymanager.Persistence.hsqldb.EventHSQLDB;
import comp3350.studymanager.Persistence.hsqldb.userHSQLDB;
import comp3350.studymanager.Persistence.userPersistence;
import comp3350.studymanager.utils.TestUtils;

public class intergrationTests {

    File tempFile;


    private userPersistence fetchDB;
    private EventPersistence fetchEventDB;
    private CoursePersistence fetchCourseDB;
    private AddedCoursePersistence fetchAddedCourseDB;
    private final Event testEvent = new Event("Hi","2022","4","1");
    private final Event testEvent2 = new Event("Hello","2022","4","1");
    private final Course testCourse = new Course("1010", "Intro Computer Science","Heather Matheson","A01");
    private final Course testCourse2 = new Course("1012", "Computer Programming for Scientists and Engineers","Kathryn L. Marcynuk","A01");


    @Before
    public void setup() throws IOException {
        System.out.println("Starting integration testing for RegisterHandler!");

        this.tempFile = TestUtils.copyDB();
        final userHSQLDB db;
        final EventHSQLDB eventdb;
        final CoursePersistence courseDb;
        final AddedCoursePersistence addedCoursePersistence;
        db = new userHSQLDB(this.tempFile.getAbsolutePath().replace(".script", ""));
        eventdb = new EventHSQLDB(this.tempFile.getAbsolutePath().replace(".script", ""));
        courseDb = new CourseHSQLDB(this.tempFile.getAbsolutePath().replace(".script", ""));
        addedCoursePersistence = new AddedCourseHSQLDB(this.tempFile.getAbsolutePath().replace(".script", ""));

        fetchDB=db;
        fetchEventDB = eventdb;
        fetchCourseDB = courseDb;
        fetchAddedCourseDB = addedCoursePersistence;
    }

    @Test
    public void testEventHSQLDB(){
        //Test AddEvent method
        boolean result = fetchEventDB.addEvent(testEvent);
        boolean result2 = fetchEventDB.addEvent(testEvent2);
        assertTrue(result);
        assertTrue(result2);
        /////////////////////////////////

        //Test getEvent method
        boolean check = false;
        ArrayList<Event> eventsOnTestEvent = fetchEventDB.getEvent("2022","4","1");
        for(Event a : eventsOnTestEvent){
            if(a.NoteCreated.equals(testEvent.NoteCreated) && a.year.equals(testEvent.year) && a.month.equals(testEvent.month) && a.date.equals(testEvent.date)){
                check = true;
            }
            if(a.NoteCreated.equals(testEvent2.NoteCreated) && a.year.equals(testEvent2.year) && a.month.equals(testEvent2.month) && a.date.equals(testEvent2.date)){
                check = true;
            }
            assertTrue(check);
            check = false;
            System.out.println("Event is " + a.NoteCreated + " " + a.date + " " + a.month + " "+ a.year);
        }
        assertEquals(2,eventsOnTestEvent.size());
        /////////////////////////////////


        //Test deleteEvent method
        boolean delete1 = fetchEventDB.deleteEvent(testEvent);
        boolean delete2 = fetchEventDB.deleteEvent(testEvent2);
        assertTrue(delete1);
        assertTrue(delete2);
        //////////////////////////////////
    }

    @Test
    public void testCourseHSQLDB(){
        //Test AddCourse method
        ArrayList<Course> test1 = new ArrayList<>();
        test1.add(testCourse);
        test1.add(testCourse2);
        fetchCourseDB.addCourse(test1);

        //Test getCourse method
        boolean check = false;
        ArrayList<Course> courseOnTestCourse = fetchCourseDB.listAllCourses();
        for(Course a : courseOnTestCourse){
            if(a.getCourseCode().equals(testCourse.getCourseCode()) && a.getCourseName().equals(testCourse.getCourseName()) &&
                    a.getInstructorName().equals(testCourse.getInstructorName()) && a.getSection().equals(testCourse.getSection())){
                check = true;
            }
            if(a.getCourseCode().equals(testCourse2.getCourseCode()) && a.getCourseName().equals(testCourse2.getCourseName()) &&
                    a.getInstructorName().equals(testCourse2.getInstructorName()) && a.getSection().equals(testCourse2.getSection())){
                check = true;
            }
            assertTrue(check);
            check = false;
            System.out.println("Course is " + a.getCourseCode() + " " + a.getCourseName() + " " + a.getInstructorName() + " "+ a.getSection());
        }
        assertEquals(2,courseOnTestCourse.size());
        /////////////////////////////////


        //Test deleteCourse method
        boolean delete1 = fetchCourseDB.deleteCourse(testCourse);
        boolean delete2 = fetchCourseDB.deleteCourse(testCourse2);
        assertTrue(delete1);
        assertTrue(delete2);
        //////////////////////////////////
    }

    @Test
    public void testAddedCourseHSQLDB(){
        //Test AddCourse method
        fetchAddedCourseDB.addCourse(testCourse);
        fetchAddedCourseDB.addCourse(testCourse2);

        //Test getAddedCourseList method
        boolean check = false;
        ArrayList<Course> courseOnTestCourse = fetchAddedCourseDB.getAddedCourseList();
        for(Course a : courseOnTestCourse){
            if(a.getCourseCode().equals(testCourse.getCourseCode()) && a.getCourseName().equals(testCourse.getCourseName()) &&
                    a.getInstructorName().equals(testCourse.getInstructorName()) && a.getSection().equals(testCourse.getSection())){
                check = true;
            }
            if(a.getCourseCode().equals(testCourse2.getCourseCode()) && a.getCourseName().equals(testCourse2.getCourseName()) &&
                    a.getInstructorName().equals(testCourse2.getInstructorName()) && a.getSection().equals(testCourse2.getSection())){
                check = true;
            }
            assertTrue(check);
            check = false;
            System.out.println("Course is " + a.getCourseCode() + " " + a.getCourseName() + " " + a.getInstructorName() + " "+ a.getSection());
        }
        assertEquals(2,courseOnTestCourse.size());
        /////////////////////////////////


        //Test deleteAddedCourse method
        boolean delete1 = fetchAddedCourseDB.deleteCourse(testCourse);
        boolean delete2 = fetchAddedCourseDB.deleteCourse(testCourse2);
        assertTrue(delete1);
        assertTrue(delete2);
        //////////////////////////////////
    }

    @Test
    public void test2() {


        System.out.println("This test will add user into database successfully");
        User newUser=new User("Akashghelani","Akash@3722");

        assert (fetchDB.addUser(newUser));
        assertTrue(fetchDB.searchUser(newUser));
    }

    @Test
    public void test1() {

        System.out.println("This test will get user from database successfully");

        User newUser1=new User("abcdefgh","abcd@1234");
        fetchDB.addUser(newUser1);
        User u1=fetchDB.getUser(newUser1);
        assert(u1.equals(newUser1));
        assertEquals(u1.getUsername(),"abcdefgh");
        assertEquals(u1.getPassword(),"abcd@1234");

    }

    @Test
    public void test3() {

        System.out.println("This test will delete user from database successfully");

        User newUser1=new User("abcdefgh","abcd@1234");
        User newUser2=new User("akkiakki","abcd@3456");
        User newUser3=new User("akashakash","abcd@5678");

        fetchDB.addUser(newUser1);
        fetchDB.addUser(newUser2);
        fetchDB.addUser(newUser3);

        System.out.println("This test will delete newUser2 oebject from database successfully");
        fetchDB.deleteUser(newUser2);

        boolean flag1=fetchDB.searchUser(newUser2);

        assertFalse(flag1);


    }
}

