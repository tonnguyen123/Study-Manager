package comp3350.studymanager.presentation;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import comp3350.studymanager.Object.Course;
import comp3350.studymanager.R;

public class SelectedCourse extends AppCompatActivity implements View.OnClickListener {
    RelativeLayout relativeLayout;
    Button[] btn;
    ArrayList<Course> list;
    String details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selected_courselist);

        relativeLayout = findViewById(R.id.relativeLayout);
        list = (ArrayList<Course>) getIntent().getSerializableExtra("COURSELIST");
        btn =new Button[list.size()];

        for(int i = 0; i < list.size(); i++){
            btn[i] = new Button(this);
            LinearLayout.LayoutParams layoutParams = new  LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 250);
            int topMargin = i * 250;
            layoutParams.setMargins(80, topMargin, 80, 0);
            btn[i].setId(i);
            btn[i].setLayoutParams(layoutParams);
            details = list.get(i).getCourseName() +"\n"+ list.get(i).getInstructorName() +"\n" +
                    list.get(i).getSection();
            btn[i].setText(details);
            btn[i].setOnClickListener(this);
            @SuppressLint("UseCompatLoadingForDrawables") Drawable img = relativeLayout.getContext().getDrawable(R.drawable.ic_baseline_navigate_next_24);
            btn[i].setCompoundDrawablesWithIntrinsicBounds(null, null, img, null);

            relativeLayout.addView(btn[i]);
        }
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, CourseDescription.class);
        intent.putExtra("COURSE",list.get(view.getId()));
        startActivity(intent);
    }
}
