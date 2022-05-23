package comp3350.studymanager.Object;

import java.io.Serializable;
import java.util.ArrayList;

public class Course implements Serializable {
    private final String courseName;
    private final String courseCode;
    private final String instructorName;
    private final String section;
    private final ArrayList<Instructor> instructors;//list of instructors that teach that course
    //this will be implemented in another iteration
    //list of semesters the course is offered
    private final ArrayList<String > sectionAvailable;//list of sections available for the course

    //constructor
    public Course(String courseCode, String courseName,String instructorName, String section) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.instructorName = instructorName;
        this.section = section;
        instructors = new ArrayList<>();
        sectionAvailable = new ArrayList<>();
    }
    //getters and setters

    public String getCourseName() {
        return courseName;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public String getSection() {
        return section;
    }

    public String getCourseCode(){
        return courseCode;
    }
}

