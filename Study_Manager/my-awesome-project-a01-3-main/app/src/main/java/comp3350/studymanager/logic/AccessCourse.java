package comp3350.studymanager.logic;

import java.util.ArrayList;
import java.util.List;

import comp3350.studymanager.Object.Course;
import comp3350.studymanager.Persistence.CoursePersistence;


public class AccessCourse {
    private final CoursePersistence coursePersistence;

    public AccessCourse() {
        coursePersistence = AccessServices.getCoursePersistence();
    }

    public List<Course> getCourseList() {
        return coursePersistence.listAllCourses();
    }


    public void insertCourse(ArrayList<Course> course) {
        coursePersistence.addCourse(course);
    }
}
