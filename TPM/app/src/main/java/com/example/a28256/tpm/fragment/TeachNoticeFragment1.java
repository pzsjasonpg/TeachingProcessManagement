package com.example.a28256.tpm.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a28256.tpm.R;
import com.example.a28256.tpm.adapter.Fragment1Adapter;
import com.example.a28256.tpm.adapter.TeachNoticeAdapter;
import com.example.a28256.tpm.entity.TeachNotice;


import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TeachNoticeFragment1 extends Fragment {

    private View viewContent;
    //设置存储标题和日期的数据
    private List<TeachNotice> titleDateList = new ArrayList<>();

    //私有属性---要设置setter，getter
    private int mType = 0;
    private String mTitle;

    private static final String TAG = "TeachNoticeFragment1";


    public void setType(int mType) {
        this.mType = mType;
    }
    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //布局文件中只有一个居中的TextView
        viewContent = inflater.inflate(R.layout.fragment1_content,container,false);
        TextView textView = (TextView) viewContent.findViewById(R.id.tv_content);
        textView.setText(this.mTitle);


        //设置ListView作为子activity
        ListView lv_teachnotice = (ListView) viewContent.findViewById(R.id.lv_teachnotice);
        //设置数据
        initListViewData();

        //设置adapter
        TeachNoticeAdapter teachNoticeAdapter = new TeachNoticeAdapter(getActivity(), R.layout.item_listview_teachnotice, titleDateList);
        //找到ListView,
        ListView listView = (ListView) viewContent.findViewById(R.id.lv_teachnotice);
        listView.setAdapter(teachNoticeAdapter);

        //设置点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //得到url
                String url = titleDateList.get(position).getUrl();
                Intent intent = new Intent("com.example.a28256.tpmcontent.WebviewContentActivity.ACTION");
                intent.addCategory("com.example.a28256.tpmcontent.WebviewContentActivity.WEBVIEWCONTENTCATEGORY");
                intent.putExtra("url",url);
                startActivity(intent);

            }
        });

        return viewContent;
    }

    public void initListViewData(){
        InputStream inputStream = null;
        BufferedReader bufferedReader = null;
        try {
            inputStream = getResources().getAssets().open("urlAndTitleAndDate.txt");
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"gbk"));
            String line = "";
            while ((line = bufferedReader.readLine()) != null){
                String[] split = line.split("####");
                String url = split[0];
                String title = split[1];
                String date = split[2];

                TeachNotice teachNotice = new TeachNotice(title, date,url);
                titleDateList.add(teachNotice);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
//        TeachNotice teachNotice1 = new TeachNotice("this is name","201501604");
//        titleDateList.add(teachNotice1);
//        TeachNotice teachNotice2 = new TeachNotice("what is your name","1997-07-03");
//        titleDateList.add(teachNotice2);
//        TeachNotice teachNotice3 = new TeachNotice("what is your name12","1997-07-03");
//        titleDateList.add(teachNotice3);
//        TeachNotice teachNotice4 = new TeachNotice("what is your name32","1997-07-03");
//        titleDateList.add(teachNotice4);
//        TeachNotice teachNotice5 = new TeachNotice("what is your name43","1997-07-03");
//        titleDateList.add(teachNotice5);
//        TeachNotice teachNotice6 = new TeachNotice("what is your name54","1997-07-03");
//        titleDateList.add(teachNotice6);
//        TeachNotice teachNotice7 = new TeachNotice("what is your name65","1997-07-03");
//        titleDateList.add(teachNotice7);
//        TeachNotice teachNotice8 = new TeachNotice("what is your name236","1997-07-03");
//        titleDateList.add(teachNotice8);
//        TeachNotice teachNotice9 = new TeachNotice("what is your name7542","1997-07-03");
//        titleDateList.add(teachNotice9);
//        TeachNotice teachNotice10 = new TeachNotice("what is your name42346","1997-07-03");
//        titleDateList.add(teachNotice10);

    }
}
