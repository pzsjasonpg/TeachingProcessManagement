package com.example.a28256.tpm;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_register_back;
    private EditText et_register_user;
    private EditText et_register_password;
    private Button btn_register_student_reg;
    private Button btn_register_teacher_reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btn_register_back = (Button)findViewById(R.id.btn_register_back);
        btn_register_student_reg = (Button)findViewById(R.id.btn_register_student_reg);
        btn_register_teacher_reg = (Button)findViewById(R.id.btn_register_teacher_reg);


        btn_register_student_reg.setOnClickListener(this);
        btn_register_teacher_reg.setOnClickListener(this );
        btn_register_back.setOnClickListener(this);


    }



    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.btn_register_back:
                finish();
                break;
            case R.id.btn_register_student_reg:
                Intent intent = new Intent("com.example.a28256.tpmlogin.STUDENTREGISTERACTION");
                intent.addCategory("com.example.a28256.tpmlogin.STUDENTREGISTERACTION");
                startActivity(intent);
                break;
            case  R.id.btn_register_teacher_reg:
                Intent intent1 = new Intent("com.example.a28256.tpmlogin.TEACHERREGISTERACTION");
                intent1.addCategory("com.example.a28256.tpmlogin.TEACHERREGISTERCATEGORY");
                startActivity(intent1);
                break;
                default:
        }
    }
}
