package comp3350.studymanager.logic;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;

import comp3350.studymanager.Object.Course;
import comp3350.studymanager.R;

public class CourseList implements Serializable {
    Context mContext;
    AccessCourse accessCourse;
    ArrayList<Course> courseList = new ArrayList<>();
    public void createList(Context context,AccessCourse accessCourse) {
        mContext = context;
        this.accessCourse = accessCourse;

        String line1, line2, line3,line4;
        Course course;

        try {
            InputStream is = context.getResources().openRawResource(R.raw.sample);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));

            line1 = reader.readLine();
            while (line1 != null) {
                line2 = reader.readLine();
                line3 = reader.readLine();
                line4 = reader.readLine();
                if (line2 != null && line3 != null && line4 != null) {
                    course = new Course(line1,line2,line3,line4);
                    courseList.add(course);
                }
                line1 = reader.readLine();
            }
            accessCourse.insertCourse(courseList);
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
            ioe.printStackTrace();
        }
    }
}
