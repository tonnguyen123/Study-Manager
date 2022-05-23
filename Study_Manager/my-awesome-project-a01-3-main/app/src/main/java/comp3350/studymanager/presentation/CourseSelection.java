package comp3350.studymanager.presentation;

import static comp3350.studymanager.R.drawable.add;
import static comp3350.studymanager.R.drawable.save_note;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import comp3350.studymanager.Object.Course;
import comp3350.studymanager.R;
import comp3350.studymanager.logic.AccessAddedCourse;
import comp3350.studymanager.logic.AccessCourse;
import comp3350.studymanager.logic.CourseList;

public class CourseSelection extends AppCompatActivity implements View.OnClickListener {
    private ArrayList<Course> courses;
    private List<Course> courseList;
    private Button[] btn;
    private AccessAddedCourse accessAddedCourse;

    @SuppressLint({"UseCompatLoadingForDrawables", "ResourceAsColor"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.course_selection);

        courses = new ArrayList<>();
        accessAddedCourse = new AccessAddedCourse();
        courseList = new ArrayList<>();
        AccessCourse accessCourse = new AccessCourse();
        CourseList courseOffered = new CourseList();

        try {
            if(accessCourse.getCourseList().isEmpty()) {
                courseOffered.createList(this,accessCourse);
            }
            courseList.addAll(accessCourse.getCourseList());

            if (!accessAddedCourse.getCourseList().isEmpty() ) {
                courses.addAll(accessAddedCourse.getCourseList());
            }
            LinearLayout linearLayout = findViewById(R.id.linearLayout);
            btn = new Button[courseList.size()];
            for(int i = 0; i < courseList.size(); i++){
                btn[i] = new Button(this);
                LinearLayout.LayoutParams layoutParams = new  LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 250);
                layoutParams.setMargins(0, i, 40, 0);
                btn[i].setId(i);
                btn[i].setLayoutParams(layoutParams);
                String string = courseList.get(i).getCourseCode() + "\n" +courseList.get(i).getCourseName();
                btn[i].setText(string);
                btn[i].setOnClickListener(this);
                Drawable img;
                if (!courses.isEmpty()){
                    if (checkDuplicate(i)){
                        img = linearLayout.getContext().getResources().getDrawable(save_note);
                        btn[i].setCompoundDrawablesWithIntrinsicBounds(null, null, img, null);
                        btn[i].setBackgroundColor(R.color.black);
                    }
                    else{
                        img = linearLayout.getContext().getResources().getDrawable(add);
                        btn[i].setCompoundDrawablesWithIntrinsicBounds(null, null, img, null);
                    }
                }
                else {
                    img = linearLayout.getContext().getResources().getDrawable(add);
                    btn[i].setCompoundDrawablesWithIntrinsicBounds(null, null, img, null);
                }
                linearLayout.addView(btn[i]);
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }


    @SuppressLint("ResourceAsColor")
    @Override
    public void onClick(View view) {
        if(checkDuplicate(view.getId()))
            Toast.makeText(this, "Course already added", Toast.LENGTH_SHORT).show();
        else {
            accessAddedCourse.insertCourse(courseList.get(view.getId()));
            courses.add(courseList.get(view.getId()));
            btn[view.getId()].setBackgroundColor(R.color.black);
            @SuppressLint("UseCompatLoadingForDrawables") Drawable img = view.getContext().getResources().getDrawable(save_note);
            btn[view.getId()].setCompoundDrawablesWithIntrinsicBounds(null,null,img,null);
            Toast.makeText(this, "Course Added to the List", Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.courselist){
            Intent intent = new Intent(this, SelectedCourse.class);
            if (courses.size() != 0){
                intent.putExtra("COURSELIST", courses);
                startActivity(intent);
            }
            else{
                Toast.makeText(this, "Course Not Added yet", Toast.LENGTH_SHORT).show();
            }


        }
        return super.onOptionsItemSelected(item);
    }

    private boolean checkDuplicate(int id) {
        boolean result = false;
        for (int i = 0; i < courses.size(); i++) {
            if (courseList.get(id).getCourseCode().equals(courses.get(i).getCourseCode()) && !result){
                result = true;
            }
        }
        return result;
    }
}