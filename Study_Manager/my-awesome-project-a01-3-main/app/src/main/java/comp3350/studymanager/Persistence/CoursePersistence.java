package comp3350.studymanager.Persistence;

import java.util.ArrayList;

import comp3350.studymanager.Object.Course;

public interface CoursePersistence {
    void addCourse(ArrayList<Course> currentCourse);
    ArrayList<Course> listAllCourses();
    boolean deleteCourse(Course remove);
}
