package comp3350.studymanager.logicLayer;

import org.junit.Assert;
import org.junit.Test;

import comp3350.studymanager.logic.Main;

public class MainTest {

    @Test
    public void Test(){
        Main.setDBPathName("database");
        Assert.assertEquals("database",Main.getDBPathName());
    }

}