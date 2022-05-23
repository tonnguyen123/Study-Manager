package comp3350.studymanager.presentation;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import comp3350.studymanager.Object.Grade;
import comp3350.studymanager.R;
import comp3350.studymanager.logic.GradeBusiness;


public class GradeTypes extends AppCompatActivity {
    int numGrade;
    int wantedGrade;
    public GradeBusiness gradeCheck;
    String resultMessage;
    boolean calculated = false;


    ArrayList<Integer> gradeID;
    ArrayList<EditText> listOfGradeID;

    ArrayList<EditText> actGrades;
    ArrayList<EditText> gradePercentages;

    ArrayList<Grade> GradeInfo;

    String title;


    Button getPlan;
    Button saveGrade;

    TextView nameCourse;
    LinearLayout gradeTypes;




    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade_types);

        gradeTypes = findViewById(R.id.container2);
        nameCourse = findViewById(R.id.courseN);




        gradeCheck = new GradeBusiness();
        Bundle bundle = getIntent().getExtras();

        numGrade = bundle.getInt("num_of_grade");
        wantedGrade = bundle.getInt("desired_grade");
        title = bundle.getString("course_name");

        Log.d("Course in GradeTypes", title + " wanted grade "+ wantedGrade + " number of grade is " + numGrade);


        nameCourse.setText(title);

        createGradeTypes(numGrade);

        getPlan = findViewById(R.id.button5);
        getPlan.setBackgroundColor(Color.GREEN);
        saveGrade =  findViewById(R.id.gradeSave);
        saveGrade.setBackgroundColor(Color.BLUE);



        getPlan.setOnClickListener(view -> calculated = CalculateGrade());

        saveGrade.setOnClickListener(v -> saveAllGrades());




    }

    public  void saveAllGrades(){
        if(calculated) {
            int earnedGrade = 0;
            int gradePercent = 0;
            gradeCheck.deleteGradesofCourse(title);
            if (GradeInfo.size() != 0) {
                for (Grade current : GradeInfo) {
                    String nameGrade = current.gradeN.getText().toString();
                    if (!current.RealGrade.getText().toString().isEmpty()) {
                        earnedGrade = Integer.parseInt(current.RealGrade.getText().toString());
                    }
                    if (!current.GradeConitribution.getText().toString().isEmpty()) {
                        gradePercent = Integer.parseInt(current.GradeConitribution.getText().toString());
                    }
                    nameGrade += "/" + resultMessage;

                    Grade newGrade = new Grade(title, nameGrade, earnedGrade, gradePercent);
                    gradeCheck.addGrade(newGrade);


                    Intent comeback = new Intent(GradeTypes.this, Create_GPA_Plan_Activity.class);
                    comeback.putExtra("course_Title", title);
                    startActivity(comeback);

                }
            }
        }
        else{
            showMsg("please fill in all information and click GET RESULT before saving.");
        }

    }

    public void createGradeTypes(int GradeNum) {
        gradeID = new ArrayList<>();
        listOfGradeID = new ArrayList<>();
        actGrades = new ArrayList<>();
        gradePercentages = new ArrayList<>();
        GradeInfo = new ArrayList<>();


        for (int i = 0; i < GradeNum; i++) {
            LayoutInflater layoutInflater = (LayoutInflater) GradeTypes.this.getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            @SuppressLint("InflateParams") final View gradeInfo = layoutInflater.inflate(R.layout.grade_input_info, null);

            EditText gradeName = gradeInfo.findViewById(R.id.name_grade);
            EditText actualGrade = gradeInfo.findViewById(R.id.grade_earned);
            EditText gradePercentage = gradeInfo.findViewById(R.id.grade_contribution);
            listOfGradeID.add(gradeName);
            actGrades.add(actualGrade);
            gradePercentages.add(gradePercentage);
            Grade newGrade = new Grade(gradeName,actualGrade,gradePercentage);
            GradeInfo.add(newGrade);


            gradeTypes.addView(gradeInfo);



        }
    }

    public int checkContribution(){
        int total = 0;
        for(int i =0 ; i < GradeInfo.size(); i++){
            if(!GradeInfo.get(i).GradeConitribution.getText().toString().isEmpty()) {
                total += Double.parseDouble(GradeInfo.get(i).GradeConitribution.getText().toString());
            }
            else{
                showMsg("Please fill information inside fields to continue");
            }
        }
        return total;
    }

    public boolean CalculateGrade() {
        int notEarnedGrade = 0;

        boolean allFilled = true;
        double totalContribution = checkContribution();


        double totalPercentage = 0;
        if(totalContribution == 100.00) {
            for (int i = 0; i < GradeInfo.size() && allFilled; i++) {

                if (!GradeInfo.get(i).gradeN.getText().toString().isEmpty()) {
                    if (!GradeInfo.get(i).RealGrade.getText().toString().isEmpty()) {
                        double eanred_grade = Double.parseDouble(GradeInfo.get(i).RealGrade.getText().toString());
                        if (eanred_grade <= 100) {
                            if (!GradeInfo.get(i).GradeConitribution.getText().toString().isEmpty()) {
                                double grade_contribution = Double.parseDouble(GradeInfo.get(i).GradeConitribution.getText().toString());
                                totalPercentage += eanred_grade * grade_contribution / 100;
                            } else {
                                allFilled = false;

                            }
                        } else {
                            showMsg("Please fill the grade up to 100% only");
                        }

                    } else {
                        if (!GradeInfo.get(i).GradeConitribution.getText().toString().isEmpty()) {
                            notEarnedGrade += Integer.parseInt(GradeInfo.get(i).GradeConitribution.getText().toString());
                        }

                    }
                } else {
                    allFilled = false;
                    showMsg("Please enter all names of all grade");
                }
            }

            if(allFilled) {
                double neededGrade = wantedGrade - totalPercentage;
                double neededPercentage = neededGrade / notEarnedGrade * 100;

                AlertDialog.Builder result = new AlertDialog.Builder(GradeTypes.this);
                result.setCancelable(true);
                resultMessage = " total earned grade is " + totalPercentage + "% .\nIf you want to get " + wantedGrade + " % " + ",need " +
                        " " + neededPercentage + "% more in each grade partrition to reach the grade target";
                result.setMessage(resultMessage);




                result.setPositiveButton("OK", (dialog, which) -> dialog.cancel());

                result.setNegativeButton("Reset and try again.", (dialog, which) -> {
                    clearFilledMessages(listOfGradeID);
                    clearFilledMessages(actGrades);
                    clearFilledMessages(gradePercentages);
                });
                result.show();

            }

            else{
                showMsg("Please make sure all fields are filled to continue.");
            }

        }
        else{
            showMsg("Please make sure total grade contribution is equal to 100% only");
        }

        return allFilled;


    }

    public void clearFilledMessages(ArrayList<EditText> a){
        for (EditText i : a){
            i.getText().clear();
        }
    }

    public void showMsg(String msg){
        Toast.makeText(GradeTypes.this,msg,Toast.LENGTH_LONG).show();
    }
}