package comp3350.studymanager.logicLayer;


import static org.junit.Assert.assertTrue;

import org.junit.Test;

import comp3350.studymanager.Persistence.hsqldb.userHSQLDB;
import comp3350.studymanager.logic.AccessServices;


public class AccessServicesTest {





    @Test
    public void Test(){

        assertTrue(AccessServices.getRegisterInterface() instanceof userHSQLDB);

    }

}

