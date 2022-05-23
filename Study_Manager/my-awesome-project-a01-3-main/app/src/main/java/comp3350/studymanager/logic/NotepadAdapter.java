package comp3350.studymanager.logic;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import comp3350.studymanager.Object.NotepadBean;
import comp3350.studymanager.R;

public class NotepadAdapter extends BaseAdapter{
    private final List<NotepadBean>list;
    private final LayoutInflater layoutInflater;

    public NotepadAdapter(Context context, List<NotepadBean>list){
        layoutInflater=LayoutInflater.from(context);
        this.list=list;
    }

    @Override
    public int getCount() {

        return list==null?0:list.size();
    }

    @Override
    public Object getItem(int position) {

        return list.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @SuppressLint("InflateParams")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView==null){
            convertView=layoutInflater.inflate(R.layout.notepad_item,null);
            viewHolder= new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder=(ViewHolder) convertView.getTag();
        }
        NotepadBean notepadBean=(NotepadBean)getItem(position);
        viewHolder.tvNotepadContent.setText(notepadBean.getNotepadContent());
        viewHolder.tvNotepadTime.setText(notepadBean.getNotepadTime());
        return convertView;
    }

    static class ViewHolder{
        TextView tvNotepadContent;
        TextView tvNotepadTime;
        public ViewHolder(View view){
            tvNotepadContent=view.findViewById(R.id.item_content);
            tvNotepadTime=view.findViewById(R.id.item_time);

        }
    }
}
