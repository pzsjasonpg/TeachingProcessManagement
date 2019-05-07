package com.example.a28256.tpm.fragment;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.a28256.tpm.R;
import com.example.a28256.tpm.zxing.activity.CaptureActivity;

public class Fragment3 extends Fragment {

    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment3, container, false);
        Button btn_zxing = (Button) view.findViewById(R.id.btn_zxing);
        btn_zxing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //添加相机权限
                if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.CAMERA},1);
                } else {
                    Intent intent = new Intent(getContext(), CaptureActivity.class);
                    startActivity(intent);
                }
            }
        });
        return view;
    }
}
