package comp3350.studymanager;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import comp3350.studymanager.presentation.CLASS_SCHEDULE_ACCEPTACE_TEST;
import comp3350.studymanager.presentation.CourseSelectionTest;
import comp3350.studymanager.presentation.GPA_ACCEPTANCE_TEST;
import comp3350.studymanager.presentation.newNotePageTest;
import comp3350.studymanager.presentation.signInPageTest2;
import comp3350.studymanager.presentation.toDoTest;


@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                GPA_ACCEPTANCE_TEST.class,

                CLASS_SCHEDULE_ACCEPTACE_TEST.class,

                newNotePageTest.class,
                toDoTest.class,
                CourseSelectionTest.class,
                signInPageTest2.class


        }
)
public class Allacceptancetest {


}
