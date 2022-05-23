package comp3350.studymanager.presentation;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

import comp3350.studymanager.R;
import comp3350.studymanager.logic.NoteBusiness;

public class RecordActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView note_back;
    EditText content;
    ImageView delete;
    ImageView note_save;
    TextView note_time;
    TextView noteName;

    private final NoteBusiness noteBusiness = new NoteBusiness();
    private Integer id;


    public static String getTime() {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd/ HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        return simpleDateFormat.format(date);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        content = findViewById(R.id.note_content);
        note_time = findViewById(R.id.tv_time);
        noteName = findViewById(R.id.note_name);

        note_back = findViewById(R.id.note_back);
        delete = findViewById(R.id.delete);
        note_save = findViewById(R.id.note_save);


        note_back.setOnClickListener(this);
        delete.setOnClickListener(this);
        note_save.setOnClickListener(this);

        initData();

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.note_back:
                finish();
                break;
            case R.id.delete:
                content.setText(" ");
                break;
            case R.id.note_save:
                String noteContent = content.getText().toString().trim();
                if (id != -1) {

                    if (noteContent.length() > 0) {
                        if (noteBusiness.updateData(id, noteContent, getTime())) {
                            showToast("Successfully modified");
                            setResult(2);
                            finish();
                        } else {
                            showToast("fail to modified");
                        }
                    } else {
                        showToast("The modified record content cannot be empty");
                    }
                } else {
                    if (noteContent.length() > 0) {
                        if (-1 != (id = noteBusiness.insertData(noteContent, getTime()).getId())) {
                            showToast("Saved successful");
                            setResult(2);
                            finish();
                        } else {
                            showToast("fail to saved");
                        }
                    } else {
                        showToast("The content of the saved record cannot be empty");
                    }
                }
                break;
        }
    }

    @SuppressLint("SetTextI18n")
    private void initData() {
        noteName.setText("Add record");
        Intent intent = getIntent();
        if (intent != null) {
            id = intent.getIntExtra("id", -1);
            if (id >= 0) {
                noteName.setText("Modify record");
                content.setText(intent.getStringExtra("content"));
                note_time.setText(intent.getStringExtra("time"));
                note_time.setVisibility(View.VISIBLE);
            }
        }
    }

    public void showToast(String message) {
        Toast.makeText(RecordActivity.this, message, Toast.LENGTH_LONG).show();
    }
}
