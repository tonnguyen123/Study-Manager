package comp3350.studymanager.presentation;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import comp3350.studymanager.R;

public class AddReminder extends AppCompatActivity {
    TimePicker currentTime;
    Button addButton;
    EditText noteInput;

    public static String transferedMsg;



    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_reminder);

        currentTime = findViewById(R.id.clock);
        addButton = findViewById(R.id.saveButton);
        noteInput = findViewById(R.id.make_note);

        Bundle bundle = getIntent().getExtras();
        int EventDay = bundle.getInt("Day");
        int EventYr = bundle.getInt("Year");
        int EventMth = bundle.getInt("Month");
        Toast.makeText(AddReminder.this, " " + EventDay + " " + EventMth + " " + EventYr, Toast.LENGTH_SHORT).show();

        addButton.setOnClickListener(view -> {
            if(noteInput.getText().toString().isEmpty()){
                Toast.makeText(AddReminder.this, "Please Enter the note or event to save", Toast.LENGTH_SHORT).show();
            }
            else{
                String time ="";
                int currentHour = currentTime.getHour();
                if(currentHour > 12 && currentHour < 24){
                    currentHour -= 12;
                    time += currentHour + ":" + currentTime.getMinute() + " PM";
                }

                else{
                    if(currentHour == 24){
                        currentHour = 0;
                    }
                    time += currentHour + ":" + currentTime.getMinute() + " AM";
                }
                String Note = EventYr + "/"+ EventMth + "/" + EventDay + " "  + noteInput.getText().toString()  + " at " + time;


               // Toast.makeText(AddReminder.this, Note, Toast.LENGTH_SHORT).show();
                Intent newIntent = new Intent();

                newIntent.putExtra(transferedMsg,Note);


                setResult(RESULT_OK,newIntent);
                finish();

            }
        });
        DisplayAllTime();
    }


    private void DisplayAllTime(){

    }
}