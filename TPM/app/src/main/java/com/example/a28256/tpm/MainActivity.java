package com.example.a28256.tpm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_login = null;
    Button btn_register = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去掉标题栏,还有任务栏
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //实现全屏
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        btn_login = (Button) findViewById(R.id.btn_login);
        btn_register = (Button) findViewById(R.id.btn_register);

        btn_login.setOnClickListener(this);
        btn_register.setOnClickListener(this);

    }



    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.btn_login:
                Intent intent = new Intent("com.example.a28256.tpmlogin.LOGINACTION");
                intent.addCategory("com.example.a28256.tpmlogin.LOGINCATEGORY");
                startActivity(intent);
                break;
            case R.id.btn_register:
                Intent intent1 = new Intent("com.example.a28256.tpmlogin.REGISTERACTION");
                intent1.addCategory("com.example.a28256.tpmlogin.REGISTERCATEGORY");
                startActivity(intent1);
                break;
                default:

        }
    }
}
