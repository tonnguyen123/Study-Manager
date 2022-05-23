package comp3350.studymanager.logic;

import java.util.List;

import comp3350.studymanager.Object.Course;
import comp3350.studymanager.Persistence.AddedCoursePersistence;

public class AccessAddedCourse {
    private final AddedCoursePersistence addedCoursePersistence;

    public AccessAddedCourse() {
        addedCoursePersistence = AccessServices.getAddedCoursePersistence();
    }



    public List<Course> getCourseList() {
        return addedCoursePersistence.getAddedCourseList();
    }


    public void insertCourse(Course course) {
        addedCoursePersistence.addCourse(course);
    }
}
