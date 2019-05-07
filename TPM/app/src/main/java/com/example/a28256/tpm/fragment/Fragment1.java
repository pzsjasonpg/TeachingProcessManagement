package com.example.a28256.tpm.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a28256.tpm.R;
import com.example.a28256.tpm.adapter.Fragment1Adapter;

import java.util.Arrays;

public class Fragment1 extends Fragment {

    private View viewContent;
    private TabLayout tab_essence;
    private ViewPager vp_essence;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewContent = inflater.inflate(R.layout.fragment1,container,false);
        initContentView(viewContent);
        initData();

        return viewContent;
    }

    public void initContentView(View viewContent){
        tab_essence = (TabLayout) viewContent.findViewById(R.id.tab_essence);
        vp_essence = (ViewPager) viewContent.findViewById(R.id.vp_essence);
    }

    public void initData(){
        //获取标签数据
        String[] titles = getResources().getStringArray(R.array.home_video_tab);

        //创建一个viewpager的adapter
        Fragment1Adapter adapter = new Fragment1Adapter(getFragmentManager(), Arrays.asList(titles));
        this.vp_essence.setAdapter(adapter);

        //将TabLayout和ViewPapger关联起来
        this.tab_essence.setupWithViewPager(this.vp_essence);

    }
}
