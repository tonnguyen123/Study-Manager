package comp3350.studymanager.Object;

import android.widget.EditText;

public class Grade {
    public String GName;
    public int ActGrade;
    public int gradePercent;

    public EditText gradeN;
    public EditText RealGrade;
    public EditText GradeConitribution;
    public String courseName;

    public Grade(EditText name, EditText gradeEarned, EditText contribution){
        gradeN = name;
        RealGrade = gradeEarned;
       GradeConitribution = contribution;
    }

    public Grade(String course, String Name, int Earned_Grade, int GradeContribute){
        GName = Name;
        courseName = course;
        ActGrade = Earned_Grade;
        gradePercent = GradeContribute;
    }


    public String getGradeCourse(){
        return courseName;
    }
    public String getGName(){
        return GName;
    }

    public int getActGrade(){
        return ActGrade;
    }

    public int getGradePercent(){
        return gradePercent;
    }


    public void setActGrade(int g){
        ActGrade = g;
    }

    public void setGradePercent(int g){
        gradePercent = g;
    }

    public void setGName(String gn){
        GName = gn;
    }

    public void setCourseName(String cn){
        courseName = cn;
    }
}
