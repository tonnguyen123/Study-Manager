package comp3350.studymanager.logic;

import java.util.ArrayList;

import comp3350.studymanager.Object.Grade;
import comp3350.studymanager.Persistence.GradePersistence;

public class GradeBusiness {



    private GradePersistence gradeChecks;

    public GradeBusiness() {
        gradeChecks = AccessServices.getGradePersistence();
    }

    public GradeBusiness(final GradePersistence gradeChecks) {
        this();
        this.gradeChecks = gradeChecks;
    }

    public ArrayList<Grade> getGradeList(String courseName) {
        return gradeChecks.getGradeList(courseName);
    }

    public void deleteGradesofCourse(String courseName) {
        gradeChecks.deleteGradesofCourse(courseName);
    }


    public void addGrade(Grade newGrade) {
        gradeChecks.addGrade(newGrade);
    }
}
