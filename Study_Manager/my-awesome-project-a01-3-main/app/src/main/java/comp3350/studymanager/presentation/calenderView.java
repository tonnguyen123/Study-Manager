package comp3350.studymanager.presentation;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import comp3350.studymanager.Object.Event;
import comp3350.studymanager.R;
import comp3350.studymanager.logic.EventBusiness;
import sun.bob.mcalendarview.MCalendarView;
import sun.bob.mcalendarview.listeners.OnDateClickListener;
import sun.bob.mcalendarview.vo.DateData;


public class calenderView extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    //CalendarView calendar;
    MCalendarView CALENDARView;
    Button EventButton;
    DateData chosenDate;
    DateData preveiousClickedDate;
    LinearLayout showNotes;
    LayoutInflater layoutInflater;
    View addInfo;

    String DayNote;
    String MonthNote;

    public EventBusiness eventCheck = null;

    ArrayList<Event> Events;


    int noteOrder = 5;




    ActivityResultLauncher<Intent> startForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @SuppressLint({"InflateParams", "SetTextI18n"})
        @RequiresApi(api = Build.VERSION_CODES.M)
        @Override
        public void onActivityResult(ActivityResult result) {
            if(result != null && result.getResultCode() == RESULT_OK){
                if(result.getData() != null && result.getData().getStringExtra(AddReminder.transferedMsg) != null){

                    String noteShow = result.getData().getStringExtra(AddReminder.transferedMsg);

                     layoutInflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                     addInfo = layoutInflater.inflate(R.layout.added_info, null);
                    Button showCourse =  addInfo.findViewById(R.id.note_info);
                    Button deleteButton = addInfo.findViewById(R.id.delete);

                    Events.get(Events.size()-1).NoteCreated = noteShow;
                    Event newEvent = new Event(noteShow, Events.get(Events.size()-1).year, Events.get(Events.size()-1).month, Events.get(Events.size()-1).date);
                    Log.d("Note is ", noteShow);
                    boolean checkUpdate = eventCheck.addEvent(newEvent);
                    if(checkUpdate){
                        Log.d("Check "," Successfully");
                    }
                    else{
                        Log.d("Check ","Failed");
                    }

                    showCourse.setText(Events.get(Events.size()-1).NoteCreated);
                    deleteButton.setText("Delete");

                    showNotes.addView(addInfo);


                    DayEventSearch(chosenDate);

                    Toast.makeText(calenderView.this, noteShow + " Day " + DayNote + " Month " + MonthNote + " Year ", Toast.LENGTH_SHORT).show();

                }
            }
        }
    });


    ActivityResultLauncher<Intent> startForResult2 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
        if(result != null && result.getResultCode() == RESULT_OK){
            if(result.getData() != null && result.getData().getStringExtra(CreateClassSchedule.transferedString) != null){

                String noteShow = result.getData().getStringExtra(CreateClassSchedule.transferedString);
                String[] input = GETINFO(noteShow);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    markClassDates(input);
                }


                Toast.makeText(calenderView.this, "Note is " + noteShow, Toast.LENGTH_SHORT).show();

            }
        }
    });


    @RequiresApi(api = Build.VERSION_CODES.O)
    public void markClassDates(String [] spliInfo){
        String start = spliInfo[0];
        String end = spliInfo[1];
        String startClass = spliInfo[2];
        String endClass = spliInfo[3];
        ArrayList<String> weekDays = new ArrayList<>(Arrays.asList(spliInfo).subList(4, spliInfo.length));
        String message = "Class starts from " + startClass + " and ends at " + endClass;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M-d-yyyy");


        //convert String to LocalDate
        LocalDate localStartDate = LocalDate.parse(start, formatter);
        LocalDate localEndDate = LocalDate.parse(end, formatter);
        Log.d("Test is ", localStartDate.toString());
        Log.d("Test 2 is ", localEndDate.toString());

        markAllClassDates(message,weekDays, localStartDate, localEndDate);




    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void markAllClassDates(String message, ArrayList<String> weekDays, LocalDate localStartDate, LocalDate localEndDate){
        for(String dayClass : weekDays){
            Log.d("Class Day is " , dayClass);
            markEachClassDay(message,dayClass, localStartDate,localEndDate);
        }


    }

    public void markEachClassDay(String message,String day,LocalDate localStartDate, LocalDate localEndDate){

        long numOfDays = 0;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            numOfDays = ChronoUnit.DAYS.between(localStartDate, localEndDate);
        }
        List<LocalDate> daysRange = null;

        switch (day) {
            case "monday":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    daysRange = Stream.iterate(localStartDate, date -> date.plusDays(1)).limit(numOfDays).filter(date -> date.getDayOfWeek() == DayOfWeek.MONDAY).collect(Collectors.toList());
                }
                break;
            case "tuesday":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    daysRange = Stream.iterate(localStartDate, date -> date.plusDays(1)).limit(numOfDays).filter(date -> date.getDayOfWeek() == DayOfWeek.TUESDAY).collect(Collectors.toList());
                }
                break;
            case "wednesday":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    daysRange = Stream.iterate(localStartDate, date -> date.plusDays(1)).limit(numOfDays).filter(date -> date.getDayOfWeek() == DayOfWeek.WEDNESDAY).collect(Collectors.toList());
                }
                break;
            case "thursday":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    daysRange = Stream.iterate(localStartDate, date -> date.plusDays(1)).limit(numOfDays).filter(date -> date.getDayOfWeek() == DayOfWeek.THURSDAY).collect(Collectors.toList());
                }
                break;
            case "friday":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    daysRange = Stream.iterate(localStartDate, date -> date.plusDays(1)).limit(numOfDays).filter(date -> date.getDayOfWeek() == DayOfWeek.FRIDAY).collect(Collectors.toList());
                }
                break;
            case "saturday":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    daysRange = Stream.iterate(localStartDate, date -> date.plusDays(1)).limit(numOfDays).filter(date -> date.getDayOfWeek() == DayOfWeek.SATURDAY).collect(Collectors.toList());
                }
                break;
            default:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    daysRange = Stream.iterate(localStartDate, date -> date.plusDays(1)).limit(numOfDays).filter(date -> date.getDayOfWeek() == DayOfWeek.SUNDAY).collect(Collectors.toList());
                }
                break;
        }


        assert daysRange != null;
        for(LocalDate monday : daysRange){
            String StringDay = monday.toString();
            String[] splitDay = StringDay.split("-");
            int classYear = Integer.parseInt(splitDay[0]);
            int classMonth = Integer.parseInt(splitDay[1]);
            int classDayy = Integer.parseInt(splitDay[2]);

            Event newEvent = new Event(message,String.valueOf(classYear),String.valueOf(classMonth),String.valueOf(classDayy));
            Events.add(newEvent);
            boolean addToTable = eventCheck.addEvent(newEvent);

            if(addToTable){
                Log.d("Added ","Successfully");
            }




            CALENDARView.markDate(classYear,classMonth,classDayy);
            Log.d("Monday is ", StringDay);

        }

    }

    public String [] GETINFO(String information){
        String [] splitInfo = information.split("/");
        Log.d("Full string is ", information);

        for (String s : splitInfo) {

            Log.d("Info is ", s);
            Toast.makeText(calenderView.this, "Note is " + s, Toast.LENGTH_SHORT).show();
        }
        return splitInfo;

    }







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        eventCheck = new EventBusiness();
//        copyDatabaseToDevice();
        getSupportActionBar();
        setContentView(R.layout.activity_main);

        CALENDARView = findViewById(R.id.calendar);
        CALENDARView.setBackgroundColor(Color.YELLOW);
        showNotes = findViewById(R.id.container);
        Events = new ArrayList<>();

        //markNotedDATES();


        EventButton = findViewById(R.id.ButtonAdd);
        EventButton.setBackgroundColor(Color.BLUE);

        DateData randomDate = new DateData(2020, 1, 2);
        DayEventSearch(randomDate);

        CALENDARView.setOnDateClickListener(new OnDateClickListener() {
            @Override

            public void onDateClick(View view, DateData date) {
                DateData temp = chosenDate;

                CALENDARView.markDate(date.getYear(),date.getMonth(),date.getDay());
                if(preveiousClickedDate == null) {
                    if(temp != null){
                        preveiousClickedDate = temp;
                    }
                    else{
                        preveiousClickedDate = date;
                    }

                }


                //CALENDARView.markDate(date.getYear(),date.getMonth(),date.getDay());
                SendDate(date);
                if(preveiousClickedDate != chosenDate){
                    CALENDARView.unMarkDate(preveiousClickedDate.getYear(),preveiousClickedDate.getMonth(),preveiousClickedDate.getDay());
                    preveiousClickedDate = null
                    ;
                }

                DayEventSearch(date);


            }
        });
    }

    @SuppressLint({"SetTextI18n", "InflateParams"})
    public void DayEventSearch(DateData clickedDate) {

        ArrayList<String> DateNotes = new ArrayList<>();

        ArrayList<Event> Eventss = eventCheck.listAllEvents();


        if (Eventss.size() > 0){
            for (int i = 0; i < Eventss.size(); i++) {
                int eventDay = Integer.parseInt(Eventss.get(i).date);
                int eventMonth = Integer.parseInt(Eventss.get(i).month);
                int eventYear = Integer.parseInt(Eventss.get(i).year);

                Log.d("Test listAllEvent is", Eventss.get(i).NoteCreated);
                showNotes.removeAllViews();
                CALENDARView.markDate(eventYear,eventMonth,eventDay);
                Toast.makeText(calenderView.this, "The search  date now is " + eventMonth + "/" + eventDay + "/" + eventYear, Toast.LENGTH_SHORT).show();
                if (eventDay == clickedDate.getDay() && eventMonth == clickedDate.getMonth() && eventYear == clickedDate.getYear()) {
                    DateNotes.add(Eventss.get(i).NoteCreated);
                    Toast.makeText(calenderView.this, "Note is " + Eventss.get(i).NoteCreated, Toast.LENGTH_SHORT).show();
                }
            }
        if (DateNotes.size() > 0) {

            for (int i = 0; i < DateNotes.size(); i++) {
                    layoutInflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    addInfo = layoutInflater.inflate(R.layout.added_info, null);
                    Button showNote = addInfo.findViewById(R.id.note_info);
                    Button delete = addInfo.findViewById(R.id.delete);
                    showNote.setText(DateNotes.get(i));
                    delete.setText("Delete");
                    showNotes.addView(addInfo);

                    delete.setOnClickListener(view -> {
                        if(addInfo != null && addInfo.getParent() != null) {
                            ((LinearLayout) addInfo.getParent()).removeView(addInfo);
                            Toast.makeText(calenderView.this, "Note removed is " + showNote.getText().toString(), Toast.LENGTH_SHORT).show();
                            DateNotes.remove(showNote.getText().toString());
                            removeEvent(showNote.getText().toString());
                            Event removedEvent = new Event(showNote.getText().toString(), String.valueOf(chosenDate.getYear()), String.valueOf(chosenDate.getMonth()), String.valueOf(chosenDate.getDay()));
                            eventCheck.deleteEvent(removedEvent);
                            DateNotes.remove(removedEvent);


                        }
                    });


                }




        }
    }
    }

    public void removeEvent(String event){
        int outLoop = 0;
        for(int i  = 0; i < Events.size() && outLoop != 1; i++){
            if(Events.get(i).NoteCreated.equalsIgnoreCase(event)){
                outLoop = 1;
                Events.remove(i);
            }
        }
    }


    private void SendDate(DateData date) {
        chosenDate = date;

    }

    public  void showPopup(View v) {
        PopupMenu popup = new PopupMenu(this,v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.popup_menu);
        popup.show();
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public  boolean onMenuItemClick(MenuItem item){
        int act1 = 0;
        switch (item.getItemId()){
            case R.id.add_due :
                act1 = 1;
                if(chosenDate != null) {
                    Intent intent = new Intent(calenderView.this, AddReminder.class);
                    CALENDARView.markDate(chosenDate.getYear(), chosenDate.getMonth(), chosenDate.getDay());
                    Bundle bundle = new Bundle();
                    int chosenYr = chosenDate.getYear();
                    int chosenMth = chosenDate.getMonth();
                    int chosenDay = chosenDate.getDay();

                    bundle.putInt("Day", chosenDay);
                    bundle.putInt("Month", chosenMth);
                    bundle.putInt("Year", chosenYr);

                    intent.putExtras(bundle);
                    Event newEvent = new Event(String.valueOf(noteOrder),String.valueOf(chosenYr),String.valueOf(chosenMth),String.valueOf(chosenDay));
                    Events.add(newEvent);


                    startForResult.launch(intent);


                }
                else{
                    Toast.makeText(calenderView.this,  "Please choose the date to add event or note on", Toast.LENGTH_SHORT).show();
                    break;
                }

            case R.id.add_class:
                if(act1 != 1) {
                    Intent intent2 = new Intent(calenderView.this, CreateClassSchedule.class);
                    startForResult2.launch(intent2);
                }

                //type what add_due item will do
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + item.getItemId());
        }


        return false;
    }
}