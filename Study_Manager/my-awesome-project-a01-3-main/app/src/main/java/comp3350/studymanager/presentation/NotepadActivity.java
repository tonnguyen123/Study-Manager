package comp3350.studymanager.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import comp3350.studymanager.Object.NotepadBean;
import comp3350.studymanager.R;
import comp3350.studymanager.logic.NoteBusiness;
import comp3350.studymanager.logic.NotepadAdapter;


public class NotepadActivity extends AppCompatActivity {
    private ListView listView;
    private NoteBusiness noteBusiness;
    private List<NotepadBean> list;
    NotepadAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        noteBusiness = new NoteBusiness();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notepad);
        listView = findViewById(R.id.listview);
        ImageView imageView = findViewById(R.id.add);
        initData();
        imageView.setOnClickListener(v -> {
            Intent intent = new Intent(NotepadActivity.this, RecordActivity.class);
            startActivityForResult(intent, 1);
        });
    }

    public void initData() {
        showQueryData();
        listView.setOnItemClickListener((parent, view, position, id) -> {
            NotepadBean notepadBean = list.get(position);
            Intent intent = new Intent(NotepadActivity.this, RecordActivity.class);
            intent.putExtra("id", notepadBean.getId());
            intent.putExtra("content", notepadBean.getNotepadContent());
            intent.putExtra("time", notepadBean.getNotepadTime());
            NotepadActivity.this.startActivityForResult(intent, 1);
        });
        listView.setOnItemLongClickListener((parent, view, position, id) -> {
            AlertDialog dialog;
            AlertDialog.Builder builder = new AlertDialog.Builder(NotepadActivity.this)
                    .setMessage("Delete this record?")
                    .setPositiveButton("Ok", (dialog1, which) -> {
                        NotepadBean notepadBean = list.get(position);
                        if (noteBusiness.deleteData(notepadBean.getId())) {
                            list.remove(position);
                            adapter.notifyDataSetChanged();
                            Toast.makeText(NotepadActivity.this, "\n" +
                                    "successfully deleted", Toast.LENGTH_LONG).show();
                        }

                    })
                    .setNegativeButton("\n" +
                            "Cancel", (dialog12, which) -> dialog12.dismiss());
            dialog = builder.create();
            dialog.show();
            return true;
        });
    }

    private void showQueryData() {
        if (list != null) {
            list.clear();
        }
        list = noteBusiness.query();
        adapter = new NotepadAdapter(this, list);
        listView.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == 2) {
            showQueryData();
        }
    }


}