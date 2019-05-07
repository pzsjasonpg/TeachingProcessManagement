package com.example.a28256.tpm.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.a28256.tpm.fragment.TeachNoticeFragment1;
import com.example.a28256.tpm.fragment.Test2Fragment1;
import com.example.a28256.tpm.fragment.Test3Fragment1;
import com.example.a28256.tpm.fragment.Test4Fragment1;
import com.example.a28256.tpm.fragment.Test5Fragment1;

import java.util.List;

public class Fragment1Adapter extends FragmentStatePagerAdapter {

    public static final String TAB_TAG = "@dream@";

    private List<String> mTitles;

    public Fragment1Adapter(FragmentManager fm, List<String> mTitles) {
        super(fm);
        this.mTitles = mTitles;
    }

    @Override
    public Fragment getItem(int i) {
        String[] title = mTitles.get(i).split(TAB_TAG);
        //初始化Fragment数据
        switch (i){
            case 0:
                TeachNoticeFragment1 contentFragment1 = new TeachNoticeFragment1();
                //给fragment1_content.xml中的TextView设置内容
                contentFragment1.setTitle(title[0]);
                return contentFragment1;
            case 1:
                Test2Fragment1 test2Fragment1 = new Test2Fragment1();
                return test2Fragment1;
            case 2:
                Test3Fragment1 test3Fragment1 = new Test3Fragment1();
                return test3Fragment1;
            case 3:
                Test4Fragment1 test4Fragment1 = new Test4Fragment1();
                return test4Fragment1;
            case 4:
                Test5Fragment1 test5Fragment1 = new Test5Fragment1();
                return test5Fragment1;
        }

        return null;


    }

    @Override
    public int getCount() {
        return mTitles.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position).split(TAB_TAG)[0];
    }




}
