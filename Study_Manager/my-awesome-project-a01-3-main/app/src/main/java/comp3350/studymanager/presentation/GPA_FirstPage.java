package comp3350.studymanager.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import comp3350.studymanager.R;


public class GPA_FirstPage extends AppCompatActivity {
    Button addCourse;   // Button of add button
    EditText courseInfo;     // Input from user
    ArrayList<String> courseNames;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gpa_firstpage);

        getSupportActionBar();

        courseNames = new ArrayList<String>();
        courseInfo = findViewById(R.id.course);
        addCourse = findViewById(R.id.addButton);


        addCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String info = courseInfo.getText().toString();

                if (info.isEmpty()) {
                    Toast.makeText(GPA_FirstPage.this, "Please type the name of the course to add ", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (checkDuplicateCourse(info)) {   //If the new course's name is the same as previously added course's name
                        Log.i("xhh", "checkDuplicateCourse: " + info);
                        Toast.makeText(GPA_FirstPage.this, "This course's name has been previously created. Please Enter new different course's name ", Toast.LENGTH_LONG).show();
                    }

                    else {   // If the new course has the new name
                        Log.i("xhh", "new Course: " + info);
                        courseNames.add(info);
                        startCourse(info);
                        Toast.makeText(GPA_FirstPage.this, "Go to the course " + info, Toast.LENGTH_SHORT).show();

                    }
                }

            }
        });



    }



    public boolean checkDuplicateCourse (String courseName){

        if (!courseNames.isEmpty()){
            for (String check : courseNames){
                if(check.equals(courseName)){
                    return true;
                }
            }
        }
        return false;


    }

    public void startCourse(String courseName){

        Intent intent = new Intent(GPA_FirstPage.this, Create_GPA_Plan_Activity.class);
        Bundle bundle = new Bundle();

        bundle.putString("course_Title",courseName);
        intent.putExtras(bundle);


        GPA_FirstPage.this.startActivity(intent);
    }


}