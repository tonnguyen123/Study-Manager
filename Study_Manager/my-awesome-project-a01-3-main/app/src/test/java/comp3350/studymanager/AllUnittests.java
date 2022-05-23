package comp3350.studymanager;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import comp3350.studymanager.ObjectLayer.EventTest;
import comp3350.studymanager.ObjectLayer.InstructorTest;
import comp3350.studymanager.ObjectLayer.NotepadBeanTest;
import comp3350.studymanager.ObjectLayer.TaskTest;
import comp3350.studymanager.ObjectLayer.UserTest;
import comp3350.studymanager.logicLayer.AccessServicesTest;
import comp3350.studymanager.logicLayer.MainTest;
import comp3350.studymanager.persistenceLayer.intergrationTests;


@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                UserTest.class,
                InstructorTest.class,
                EventTest.class,
                intergrationTests.class,
                AccessServicesTest.class,
                MainTest.class,
                NotepadBeanTest.class,
                TaskTest.class,

        }
)

public class  AllUnittests
{

}
