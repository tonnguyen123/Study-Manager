package comp3350.studymanager.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import comp3350.studymanager.R;

public class semesterSelection extends AppCompatActivity {
    private Spinner Spin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semester_selection);

        Spin= findViewById(R.id.spinner1);
        Button nextPagebtn = findViewById(R.id.nextPagebtn);

        String[]Item= new String[]{"Winter2022","Fall2021","Summer2021","Winter2021"};
        ArrayAdapter<String> adopt= new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, Item);
        Spin.setAdapter(adopt);
        Spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override

            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                Spin.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        nextPagebtn.setOnClickListener((View v) -> {
            Intent newIntent=new Intent(semesterSelection.this,CourseSelection.class);
            startActivity(newIntent);

        });




    }
}
