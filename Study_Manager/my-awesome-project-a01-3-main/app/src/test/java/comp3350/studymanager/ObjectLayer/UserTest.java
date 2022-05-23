package comp3350.studymanager.ObjectLayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import comp3350.studymanager.Object.User;


public class UserTest {

    @Before
    public void setup(){
        System.out.println("Starting unit tests for User object");
    }

    @Test
    public void test1() {


        System.out.println("Starting Instructor Test");

        User newUser = new User("abcdef","abcdef123456");
        assertEquals("abcdef",newUser.getUsername());
        assertEquals("abcdef123456", newUser.getPassword());


        System.out.println("Finish Instructor Test");
    }

    @Test
    public void test2(){
        User newUser = new User("abcdef","abcdef123456");
        assert(newUser.getUsername()!=null);
        assert(newUser.getPassword()!=null);

        System.out.println("Username should be atleast 6 character ");
        assert(newUser.isValidusername("111111"));

        System.out.println("fullfilling all valid password requirements");
        assert(newUser.isValidpassword("aA1234"));


    }

    @Test
    public void test3(){
        ArrayList<User> newlist=new ArrayList<>();


        User newUser=new User("abcdef","abcdef123456");
        newlist.add(newUser);
        assert(newlist.contains(newUser));
    }

    @Test
    public void test4(){

        System.out.println("User's equal method check to see if they are equal objects by entering equal username and password");
        User newUser=new User("abcdef","abcdef123456");
        User newUser1=new User("abcdef","abcdef123456");
        assert(newUser.equals(newUser1));
    }




}
