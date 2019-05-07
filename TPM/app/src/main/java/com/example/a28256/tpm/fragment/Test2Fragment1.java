package com.example.a28256.tpm.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.a28256.tpm.R;

public class Test2Fragment1 extends Fragment {


    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment1_test2, container, false);
        TextView textView = (TextView) view.findViewById(R.id.tv_test2);
        textView.setText("test2");
        return view;
    }
}
