package com.example.a28256.tpm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.a28256.tpm.fragment.Fragment1;
import com.example.a28256.tpm.fragment.Fragment2;
import com.example.a28256.tpm.fragment.Fragment3;
import com.example.a28256.tpm.fragment.Fragment4;
import com.example.a28256.tpm.fragment.Fragment5;

public class ContentActivity extends AppCompatActivity {

    private BottomBar bottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        //初始化底部导航栏
        initBottomBar();
    }

    public void initBottomBar(){
        bottomBar = (BottomBar) findViewById(R.id.bottom_bar);
        bottomBar.setContainer(R.id.fl_container)
                .setTitleBeforeAndAfterColor("#999999","#ff5d5e")
                .addItem(Fragment1.class,
                        "首页",
                        R.drawable.item1_before,
                        R.drawable.item1_after)
                .addItem(Fragment2.class,
                        "功能",
                        R.drawable.item2_before,
                        R.drawable.item2_after)
                .addItem(Fragment3.class,
                        "考勤",
                        R.drawable.item2_before,
                        R.drawable.item2_after)
                .addItem(Fragment4.class,
                        "工具",
                        R.drawable.item2_before,
                        R.drawable.item2_after)
                .addItem(Fragment5.class,
                        "我的",
                        R.drawable.item3_before,
                        R.drawable.item3_after)
                .build();
    }
}
