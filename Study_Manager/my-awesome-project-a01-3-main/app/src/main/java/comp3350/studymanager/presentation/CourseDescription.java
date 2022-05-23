package comp3350.studymanager.presentation;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import comp3350.studymanager.Object.Course;
import comp3350.studymanager.R;

public class CourseDescription extends AppCompatActivity {
    TextView courseName;
    Button emailProf;
    Button calender;
    Button notes;
    Button to_do_list;
    Button gpa_calculator;
    Course course;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.course_detail);

        courseName = findViewById(R.id.textView);
        emailProf = findViewById(R.id.button9);
        emailProf.setBackgroundColor(Color.BLACK);
        calender = findViewById(R.id.button6);
        calender.setBackgroundColor(Color.YELLOW);
        notes = findViewById(R.id.button7);
        notes.setBackgroundColor(Color.GREEN);
        to_do_list = findViewById(R.id.button8);
        to_do_list.setBackgroundColor(Color.RED);
        gpa_calculator = findViewById(R.id.button5);
        gpa_calculator.setBackgroundColor(Color.CYAN);


        course = (Course) getIntent().getSerializableExtra("COURSE");

        courseName.setText(course.getCourseName()+ "-" + course.getSection());
        courseName.setTextSize(30);
        courseName.setTypeface(null, Typeface.BOLD);

        calender.setOnClickListener(view -> {

            Intent newIntent=new Intent(CourseDescription.this,calenderView.class);
            startActivity(newIntent);
            finish();
        });

        notes.setOnClickListener(view -> {

            Intent newIntent=new Intent(CourseDescription.this,NotepadActivity.class);
            startActivity(newIntent);
            finish();
        });

        gpa_calculator.setOnClickListener(view -> {
            Intent gpaIntent = new Intent(CourseDescription.this,GPA_FirstPage.class);
            startActivity(gpaIntent);
        });

        emailProf.setOnClickListener(view ->{
            Intent newIntent=new Intent(CourseDescription.this, MainActivity.class);
            startActivity(newIntent);
            finish();
        });

        to_do_list.setOnClickListener(view -> {

            Intent newIntent=new Intent(CourseDescription.this,todoListActivity.class);
            startActivity(newIntent);
            finish();
        });

    }




}