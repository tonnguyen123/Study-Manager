package comp3350.studymanager.presentation;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import comp3350.studymanager.R;

public class CreateClassSchedule extends AppCompatActivity {


    Button reset;
    CheckBox monday;
    CheckBox tuesday;
    CheckBox wednesday;
    CheckBox thursday;
    CheckBox friday;
    CheckBox saturday;
    CheckBox sunday;
    EditText startD;
    EditText startM;
    EditText startY;
    EditText endD;
    EditText endM;
    EditText endY;
    EditText startT;
    EditText endT;

    Button addAll;

    public static String AllString;
    public static String transferedString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_class_schedule);

        initiateEditTexts();

        initiateCheckBox();

        startSchedule();
        reset = findViewById(R.id.resetButton);
        reset.setBackgroundColor(Color.RED);

        reset.setOnClickListener(view ->{
            startD.getText().clear();
            startM.getText().clear();
            startY.getText().clear();
            endD.getText().clear();
            endM.getText().clear();
            endY.getText().clear();
            startT.getText().clear();
            endT.getText().clear();
            monday.setChecked(false);
            tuesday.setChecked(false);
            wednesday.setChecked(false);
            thursday.setChecked(false);
            friday.setChecked(false);
            saturday.setChecked(false);
            sunday.setChecked(false);

        });

    }

    public void initiateEditTexts(){
        addAll = findViewById(R.id.Finalize);
        addAll.setBackgroundColor(Color.BLUE);
        startD = findViewById(R.id.DaySt);
        startM = findViewById(R.id.MthSt);
        startY =findViewById(R.id.YrSt);
        endD = findViewById(R.id.DayEnd);
        endM = findViewById(R.id.MthEnd);
        endY = findViewById(R.id.YrEnd);

        startT = findViewById(R.id.EditStartTime);
        endT =  findViewById(R.id.EditEndTime);
    }


    public void initiateCheckBox(){
        monday = findViewById(R.id.MonD);
        tuesday = findViewById(R.id.TueD);
        wednesday = findViewById(R.id.WedD);
        thursday = findViewById(R.id.ThuD);
        friday = findViewById(R.id.FriD);
        saturday = findViewById(R.id.SatD);
        sunday = findViewById(R.id.SunD);
    }

    public void startSchedule(){


        addAll.setOnClickListener(view -> {

            if(EditTextsNotEmpty() && CheckDayNoEmpty()){
                int startDay = Integer.parseInt(startD.getText().toString());
                int startMonth = Integer.parseInt(startM.getText().toString());
                int startYear = Integer.parseInt(startY.getText().toString());

                int endDay = Integer.parseInt(endD.getText().toString());
                int endMth = Integer.parseInt(endM.getText().toString());
                int endYear = Integer.parseInt(endY.getText().toString());


                if(checkStartPoint(startDay, startMonth, startYear) && checkStartPoint(endDay, endMth, endYear)){
                    if(isValidRangeDate(startDay, startMonth, startYear, endDay, endMth, endYear)){
                        AllString = startMonth + "-" + startDay + "-" + startYear + "/" + endMth + "-" + endDay + "-" + endYear;
                        String ClassStart = startT.getText().toString();
                        String ClassEnd = endT.getText().toString();
                        if(checkTime(ClassStart, ClassEnd)){
                            AllString += "/"+ ClassStart + "/" + ClassEnd;
                            String classDays = checkClassDate();
                            if(classDays != null){
                                AllString += classDays;
                                Toast.makeText(CreateClassSchedule.this, AllString, Toast.LENGTH_SHORT).show();
                                Intent newIntent = new Intent();

                                newIntent.putExtra(transferedString,AllString);
                                setResult(RESULT_OK,newIntent);
                                finish();
                            }
                            else{
                                Toast.makeText(CreateClassSchedule.this, "Wrong info", Toast.LENGTH_SHORT).show();
                            }
                        }

                    }
                    else{
                        Toast.makeText(CreateClassSchedule.this, "Please make sure end date of class is after start date of the class", Toast.LENGTH_SHORT).show();
                    }

                }
                else{
                    Toast.makeText(CreateClassSchedule.this, "Please check the time and date selection to make sure correct information", Toast.LENGTH_SHORT).show();
                }
            }
            else{
                Toast.makeText(CreateClassSchedule.this, "Please fill information in all places to continue", Toast.LENGTH_SHORT).show();
            }
        });

    }


    public String checkClassDate(){

        String checkDates = "/";
        if(monday.isChecked()){
            checkDates += "monday/";
        }
        if(tuesday.isChecked()){
            checkDates += "tuesday/";
        }
        if(wednesday.isChecked()){
            checkDates += "wednesday/";
        }
        if(thursday.isChecked()){
            checkDates += "thursday/";
        }
        if(friday.isChecked()){
            checkDates += "friday/";
        }
        if(saturday.isChecked()){
            checkDates += "saturday/";
        }
        if(sunday.isChecked()){
            checkDates += "sunday/";
        }
        return checkDates;
    }


    public boolean checkTime(String ClassStartT, String ClassEndT) {
        boolean checkT = false;
        if (ClassStartT.isEmpty() || ClassEndT.isEmpty()) {
            Toast.makeText(CreateClassSchedule.this, "Please enter the class time to continue", Toast.LENGTH_SHORT).show();
        } else {
            if(ClassStartT.contains(":") && ClassEndT.contains(":")){
                String[] splitStart = ClassStartT.split(":");
                String[] splitEnd = ClassEndT.split(":");
                int startHour = Integer.parseInt(splitStart[0]);
                int startMin = Integer.parseInt(splitStart[1]);
                int endHour = Integer.parseInt(splitEnd[0]);
                int endMin = Integer.parseInt(splitEnd[1]);
                if (startHour > 23) {
                    Toast.makeText(CreateClassSchedule.this, "The class start time need to be between 0:00 to 23:59", Toast.LENGTH_SHORT).show();
                } else if (startHour >= 0) {

                    if (endHour >= 0 && endHour <= 23) {
                        if (endMin >= 0 && startMin >= 0 && endMin <= 59) {
                            if (startHour < endHour) {
                                checkT = true;

                            } else if (startHour == endHour) {
                                if (endMin > startMin) {
                                    checkT = true;

                                } else {
                                    Toast.makeText(CreateClassSchedule.this, "The class start time need to be before the end class time", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(CreateClassSchedule.this, "The class start time need to be before the end class time", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(CreateClassSchedule.this, "The class  time needs to be between 0:00 to 23:59", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(CreateClassSchedule.this, "The class start time needs to be between 0:00 to 23:59", Toast.LENGTH_SHORT).show();
                    }
                }

                Toast.makeText(CreateClassSchedule.this, "Start time " + ClassStartT + " End time is " + ClassEndT, Toast.LENGTH_SHORT).show();

            }
            else{
                Toast.makeText(CreateClassSchedule.this, "Please enter class's start time in format HOUR:MIN", Toast.LENGTH_SHORT).show();
            }
        }
        return checkT;
    }

    public boolean isValidRangeDate(int startDay, int startMo, int startYear, int endDay, int endMo, int endYear){
        boolean check;
        if(startDay <= endDay && startMo <= endMo && startYear <= endYear){
            check = true;
        }
        else{
            if(startMo < endMo){
                check = true;
            }
            else {
                check = false;
                Toast.makeText(CreateClassSchedule.this, "Please make sure end date of class is after the start date of the class", Toast.LENGTH_SHORT).show();
            }
        }
        return check;
    }


    public boolean checkStartPoint(int day, int month, int year){
        boolean result = false;
        if(year >= 2022){
            if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12 ){
                if(day > 0 && day <= 31){
                    result = true;
                }
                else{
                    result = false;
                    Toast.makeText(CreateClassSchedule.this, "The daate needs to be between 1st and 31st for the chosen month", Toast.LENGTH_SHORT).show();
                }
            }
            else if (month == 2){
                if(year%4 == 0){
                    if(day > 1 && day <= 28){
                        result = true;
                    }
                    else{
                        result = false;
                        Toast.makeText(CreateClassSchedule.this, "The date needs to be between 1st and 28th for Feb of " + year, Toast.LENGTH_SHORT).show();
                    }
                }
                else if (day > 1 && day <= 27) {
                    result = true;
                } else {
                    result = false;
                    Toast.makeText(CreateClassSchedule.this, "The date needs to be between 1st and 27th for Feb of " + year, Toast.LENGTH_SHORT).show();
                }
            }
            else if (month == 4 || month == 6 || month == 9 || month == 11){
                if(day > 0 && day <= 30){
                    result = true;

                }
                else{
                    result = false;
                    Toast.makeText(CreateClassSchedule.this, "The daate needs to be between 1st and 31st for the chosen month", Toast.LENGTH_SHORT).show();
                }

            }
            else{
                Toast.makeText(CreateClassSchedule.this, "the date is " + month + " " + day + " " + year, Toast.LENGTH_SHORT).show();
                Toast.makeText(CreateClassSchedule.this, "The month needs to be between Janurary and December " , Toast.LENGTH_SHORT).show();
            }

        }
        else{
            Toast.makeText(CreateClassSchedule.this, "The year needs to be greater than 2022", Toast.LENGTH_SHORT).show();
        }

        return result;
    }

    public boolean EditTextsNotEmpty(){
        boolean FillAll = true;
        if(startD.getText().toString().isEmpty() || endD.getText().toString().isEmpty() || startT.getText().toString().isEmpty() || endT.getText().toString().isEmpty()){
            FillAll = false;
            Toast.makeText(CreateClassSchedule.this, "Please fill all time information to continue", Toast.LENGTH_SHORT).show();
        }

        return FillAll;
    }

    public boolean CheckDayNoEmpty(){
        boolean checkAll = true;
        if(!monday.isChecked() && !tuesday.isChecked() && !wednesday.isChecked() && !thursday.isChecked() && !friday.isChecked()
                && !saturday.isChecked() && !sunday.isChecked()){
            Toast.makeText(CreateClassSchedule.this, "Please check which day for class in the week to continue", Toast.LENGTH_SHORT).show();
            checkAll = false;
        }
        return  checkAll;
    }

}
