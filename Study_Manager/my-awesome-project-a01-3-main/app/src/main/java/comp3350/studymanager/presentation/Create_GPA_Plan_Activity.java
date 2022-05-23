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

public class Create_GPA_Plan_Activity extends AppCompatActivity {
    TextView courseTitle;
    Button createGrades;
    EditText GradeNum;
    EditText DesiredGrade;
    String nameOfCourse;

    LinearLayout showCourseGrade;

    ArrayList<Grade> gradesOfCourse;

    public GradeBusiness gradeChecks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        gradeChecks = new GradeBusiness();
        setContentView(R.layout.activity_create_gpa_plan);

        GradeNum = findViewById(R.id.numGrade);
        DesiredGrade = findViewById(R.id.GradeYouWant);


        setCourseTitle();

        createGrades = findViewById(R.id.button);
        createGrades.setBackgroundColor(Color.BLUE);
        String courseName = courseTitle.getText().toString();
        showCourseGPA(courseName);

        createGrades.setOnClickListener(view -> {

            if (!GradeNum.getText().toString().isEmpty() && !DesiredGrade.getText().toString().isEmpty()) {
                int numOfGrade = Integer.parseInt(GradeNum.getText().toString());
                int wantedGrade = Integer.parseInt(DesiredGrade.getText().toString());

                Log.d("Course ", courseName + " wanted grade " + wantedGrade + " number of grade is " + numOfGrade);
                Bundle bundle = new Bundle();

                bundle.putInt("num_of_grade", numOfGrade);
                bundle.putInt("desired_grade", wantedGrade);
                bundle.putString("course_name", courseName);

                Intent intent = new Intent(Create_GPA_Plan_Activity.this, GradeTypes.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
            else{
                Toast.makeText(Create_GPA_Plan_Activity.this, "Please fill all information to continue", Toast.LENGTH_SHORT).show();
            }

        });




    }

    @SuppressLint("SetTextI18n")
    public void showCourseGPA(String courseName){
        showCourseGrade = findViewById(R.id.courseGrades);
        gradesOfCourse = gradeChecks.getGradeList(courseName);
        if(gradesOfCourse.size()!= 0){
            LayoutInflater layoutInflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            @SuppressLint("InflateParams") final View gradeCourse = layoutInflater.inflate(R.layout.added_information, null);
            Button showCourse = gradeCourse.findViewById(R.id.courseinfo);

            String [] splitInfo = gradesOfCourse.get(0).GName.split("/");

            showCourse.setText("Saved GPA Plan with " + gradesOfCourse.size() + " types of grade");

            showCourse.setOnClickListener(v -> {
                AlertDialog.Builder showPlan = new AlertDialog.Builder(Create_GPA_Plan_Activity.this);
                showPlan.setCancelable(true);
                showPlan.setMessage(splitInfo[1]);
                showPlan.setPositiveButton("OK", (dialog, which) -> dialog.cancel());
                showPlan.show();

            });


            Button removeButton = gradeCourse.findViewById(R.id.delete);

            removeButton.setText("Delete GPA plan");
            removeButton.setOnClickListener(v -> {
                gradeChecks.deleteGradesofCourse(courseName);
                showCourseGrade.removeView(gradeCourse);
            });

            showCourseGrade.addView(gradeCourse);
        }
        else{
            Log.d("Found ", "nothing");
        }
    }



    @SuppressLint("SetTextI18n")
    public void setCourseTitle(){
        courseTitle = findViewById(R.id.courseName);

        Bundle bundle = getIntent().getExtras();
        nameOfCourse = bundle.getString("course_Title");
        if(nameOfCourse.contains("Course")){
            courseTitle.setText(nameOfCourse);
        }
        else {
            courseTitle.setText("Course " + nameOfCourse);
        }

    }
}