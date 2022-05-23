package comp3350.studymanager;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import comp3350.studymanager.logicLayer.NoteBusinessIT;
import comp3350.studymanager.logicLayer.TodoListBusinessIT;
import comp3350.studymanager.persistenceLayer.intergrationTests;


@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                intergrationTests.class,
                NoteBusinessIT.class,
                TodoListBusinessIT.class

        }
)
public class AllIntegrationTests {


}
