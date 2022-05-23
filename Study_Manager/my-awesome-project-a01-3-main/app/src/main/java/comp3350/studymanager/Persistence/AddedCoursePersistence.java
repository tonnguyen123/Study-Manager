package comp3350.studymanager.Persistence;

import java.util.ArrayList;

import comp3350.studymanager.Object.Course;

public interface AddedCoursePersistence{
    void addCourse(Course currentCourse);
    ArrayList<Course> getAddedCourseList();
    boolean deleteCourse(Course remove);
}
