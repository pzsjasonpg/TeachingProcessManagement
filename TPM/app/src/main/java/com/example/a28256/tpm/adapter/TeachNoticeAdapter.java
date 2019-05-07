package com.example.a28256.tpm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.a28256.tpm.R;
import com.example.a28256.tpm.entity.TeachNotice;

import java.util.List;

public class TeachNoticeAdapter extends ArrayAdapter<TeachNotice> {

    private int resourseId;
    private View view;

    public TeachNoticeAdapter(Context context, int resource, List<TeachNotice> objects) {
        super(context, resource, objects);
        resourseId = resource;
    }


    @Override
    public View getView(int position,View convertView, ViewGroup parent) {
        TeachNotice item = (TeachNotice) getItem(position);
        //获取实例化布局
        if (convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourseId, parent, false);
        } else {
            view = convertView;
        }
        //找到两个TextView，title/date
        TextView title = (TextView) view.findViewById(R.id.tv_teachnotice_title);
        TextView date = (TextView) view.findViewById(R.id.tv_teachnotice_date);
        //设置title和date
        title.setText(item.getTitle());
        date.setText(item.getDate());

        return view;
    }


}
