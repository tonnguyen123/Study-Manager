package comp3350.studymanager.Persistence;

import java.util.ArrayList;

import comp3350.studymanager.Object.Grade;

public interface GradePersistence {
    void addGrade(Grade grade);
    ArrayList<Grade> getGradeList(final String course);
    void deleteGradesofCourse(String removeedCourse);
}
