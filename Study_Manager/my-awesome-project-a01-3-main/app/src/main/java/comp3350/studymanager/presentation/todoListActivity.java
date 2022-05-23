package comp3350.studymanager.presentation;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import comp3350.studymanager.Object.Task;
import comp3350.studymanager.R;
import comp3350.studymanager.logic.TodoListBusiness;

public class todoListActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tv_time, tv_name;
    private CheckBox cb;
    private ImageView iv_delete;
    private PopupWindow mPopWindow;
    private List<Map<String, String>> list;
    private MyAdapter adapter;
    private ListView lv_user;
    private TodoListBusiness todoListBusiness;
    private FloatingActionButton bt_add;
    public boolean initial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        todoListBusiness = new TodoListBusiness();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todolist);
        bt_add = (FloatingActionButton) findViewById(R.id.bt_add);
        bt_add.setOnClickListener(this);
        lv_user = (ListView) findViewById(R.id.lv_user);
        list = new ArrayList<>();
        getData();
        adapter = new MyAdapter(
                this,
                list,
                R.layout.item,
                new String[]{"name"},
                new int[]{R.id.tv_name}
        );

        lv_user.setAdapter(adapter);
        lv_user.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int pos, long l) {
                AlertDialog.Builder builder = new AlertDialog.Builder(todoListActivity.this);
                builder.setMessage("Delete or not？");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        deleteList(list.get(pos).get("id"));
                        Toast.makeText(todoListActivity.this, "Delete Successfully", Toast.LENGTH_SHORT).show();
                        list.remove(pos);
                        adapter.notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("Cancel", null);
                builder.create().show();
                return true;
            }
        });

        adapter.setAltOnClickListener(new AltOnClickListener() {
            @Override
            public void altItem(View view, int pos) {
                if (list.get(pos).get("statue").equals("Done")) {
                    cb.setChecked(false);
                    altStatue("Todo", list.get(pos).get("id"));
                } else {
                    cb.setChecked(true);
                    altStatue("Done", list.get(pos).get("id"));
                }
            }
        });
    }

    private void altStatue(String s, String id) {
        todoListBusiness.altStatue(s, id);
    }

    public void deleteList(String i) {
        todoListBusiness.deleteList(i);
    }

    public void addList(Task i) {

        todoListBusiness.addList(i);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getData();
        adapter = new MyAdapter(
                this,
                list,
                R.layout.item,
                new String[]{"name"},
                new int[]{R.id.tv_name}
        );
        lv_user.setAdapter(adapter);
        adapter.setDeleteOnClickListener(new DeleteOnClickListener() {
            @Override
            public void deleteItem(View view, final int pos) {
                AlertDialog.Builder builder = new AlertDialog.Builder(todoListActivity.this);
                builder.setMessage("Delete or not？");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        deleteList(list.get(pos).get("id"));
                        Toast.makeText(todoListActivity.this, "Delete Successfully", Toast.LENGTH_SHORT).show();
                        list.remove(pos);
                        adapter.notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("Cancel", null);
                builder.create().show();
            }
        });

        adapter.setAltOnClickListener(new AltOnClickListener() {
            @Override
            public void altItem(View view, int pos) {
                if (list.get(pos).get("statue").equals("Done")) {
                    list.get(pos).put("statue", "Todo");
                    adapter.notifyDataSetChanged();
                    altStatue("Todo", list.get(pos).get("id"));
                } else {
                    list.get(pos).put("statue", "Done");
                    adapter.notifyDataSetChanged();
                    altStatue("Done", list.get(pos).get("id"));
                }
            }

        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_add:
                showPopupWindow();
                break;
        }
    }

    private void showPopupWindow() {
        View contentView = LayoutInflater.from(todoListActivity.this).inflate(R.layout.popupwindow_comment, null);
        final EditText editText = contentView.findViewById(R.id.popup_comment_edt);
        final TextView tv = contentView.findViewById(R.id.popup_comment_send_tv);
        mPopWindow = new PopupWindow(contentView,
                ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT, true);
        mPopWindow.setContentView(contentView);
        mPopWindow.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        final InputMethodManager inputMethodManager = (InputMethodManager) getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.showSoftInput(editText, 0);
        inputMethodManager.toggleSoftInput(1000, InputMethodManager.HIDE_NOT_ALWAYS);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputString = editText.getText().toString();
                Task note = new Task();
                note.setName(inputString);
                note.setStatue("Todo");
                addList(note);
                getData();
                adapter.notifyDataSetChanged();
                mPopWindow.dismiss();
                getWindow().setSoftInputMode(
                        WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
            }
        });
        mPopWindow.setFocusable(true);
        View rootview = LayoutInflater.from(this).inflate(R.layout.activity_todolist, null);
        mPopWindow.showAtLocation(rootview, Gravity.BOTTOM, 0, 0);
    }

    public interface DeleteOnClickListener {
        void deleteItem(View view, int pos);
    }

    public interface AltOnClickListener {
        void altItem(View view, int pos);
    }

    public class MyAdapter extends SimpleAdapter {
        AltOnClickListener altOnClickListener;
        DeleteOnClickListener deleteOnClickListener;

        public void setAltOnClickListener(AltOnClickListener altOnClickListener) {
            this.altOnClickListener = altOnClickListener;
        }

        public void setDeleteOnClickListener(DeleteOnClickListener deleteOnClickListener) {
            this.deleteOnClickListener = deleteOnClickListener;
        }

        public MyAdapter(Context context, List<? extends Map<String, ?>> data, int resource,
                         String[] from, int[] to) {
            super(context, data, resource, from, to);
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            View v = super.getView(position, convertView, parent);
            ViewHolder holder = null;
            if (convertView == null) {
                convertView = LayoutInflater.from(todoListActivity.this).inflate(R.layout.item, null);
                holder = new ViewHolder(convertView);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.cb.setChecked(false);
            holder.tv_name.setText(list.get(position).get("name"));
            if (list.get(position).get("statue").equals("Todo")) {
                holder.cb.setChecked(false);
                holder.tv_name.getPaint().setFlags(0);
                holder.tv_name.setTextColor(Color.BLACK);
            } else {
                holder.cb.setChecked(true);
                holder.tv_name.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
                holder.tv_name.setTextColor(Color.GRAY);
            }
            holder.cb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    altOnClickListener.altItem(view, position);
                }
            });
            holder.iv_delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    deleteOnClickListener.deleteItem(view, position);
                }
            });
            return convertView;
        }

        class ViewHolder {
            ImageView iv_delete;
            TextView tv_name;
            CheckBox cb;

            public ViewHolder(View v) {
                tv_name = v.findViewById(R.id.tv_name);
                cb = v.findViewById(R.id.cb);
                iv_delete = v.findViewById(R.id.iv_delete);
            }
        }
    }

    public List<Map<String, String>> getData() {
        list.clear();
        todoListBusiness.getData(list);

        return list;
    }
}
