package comp3350.studymanager.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import comp3350.studymanager.R;


public class institutionPage extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_institution_page);

        Button addButton = findViewById(R.id.addBtn);
        


        addButton.setOnClickListener((View v) -> {

                Intent newIntent=new Intent(institutionPage.this,semesterSelection.class);
                startActivity(newIntent);
                finish();


        });

    



    }









}

