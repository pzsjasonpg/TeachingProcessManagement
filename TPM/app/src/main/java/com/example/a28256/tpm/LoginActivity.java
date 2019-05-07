package com.example.a28256.tpm;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a28256.tpm.dao.StudentDao;
import com.example.a28256.tpm.dao.TeacherDao;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_login_back;
    private EditText et_user;
    private EditText et_password;
    private CheckBox ckb_issave;
    private Button btn_student_login;
    private Button btn_teacher_login;

    private SharedPreferences sp;

    private Context context;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        context = this;

        btn_login_back = (Button) findViewById(R.id.btn_login_back);
        et_user = (EditText) findViewById(R.id.et_login_user);
        et_password = (EditText) findViewById(R.id.et_login_password);
        ckb_issave = (CheckBox) findViewById(R.id.ckb_issave);
        btn_student_login = (Button) findViewById(R.id.btn_student_login);
        btn_teacher_login = (Button) findViewById(R.id.btn_teacher_login);


        btn_student_login.setOnClickListener(this);
        btn_teacher_login.setOnClickListener(this);
        btn_login_back.setOnClickListener(this);

        //判断是否记住过用户密码，即判断SharedPerference保存的文件是否存在
        sp = getSharedPreferences("info", MODE_PRIVATE);
        boolean isChecked = sp.getBoolean("isChecked", false);
        //读取文件中用户信息
        if (isChecked){
            et_user.setText(sp.getString("user",""));
            et_password.setText(sp.getString("password",""));
            ckb_issave.setChecked(true);
        }


    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.btn_login_back:
                finish();
                break;
            case R.id.btn_student_login:
               try {
                   //保存用户信息
                   loginSaveInfoBySP();
                   new Thread(new Runnable() {
                       @Override
                       public void run() {
                           //登录过程
                           //1、判断学生用户是否在数据库中注册
                           StudentDao studentDao = StudentDao.getStudentDao();
                           if (!et_user.getText().toString().equals("")){
                               boolean hasUserInDB = studentDao.hasUserInDB(Integer.parseInt(et_user.getText().toString()));
                               if (hasUserInDB){
                                   //2、登录成功
                                   runOnUiThread(new Runnable() {
                                       @Override
                                       public void run() {
                                           Toast.makeText(getApplicationContext(),"学生登录成功",Toast.LENGTH_SHORT).show();
                                       }
                                   });

                                   Intent intent1 = new Intent(context,ContentActivity.class);
                                   startActivity(intent1);
                               } else {
                                   //登录失败
                                   runOnUiThread(new Runnable() {
                                       @Override
                                       public void run() {
                                           Toast.makeText(getApplicationContext(),"学生用户没有注册",Toast.LENGTH_SHORT).show();
                                       }
                                   });
                               }
                           }

                       }
                   }).start();
               } catch (Exception e){
                   Toast.makeText(getApplicationContext(),"后台建设升级中",Toast.LENGTH_SHORT).show();
               }
                break;
            case R.id.btn_teacher_login:
                try {
                    loginSaveInfoBySP();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            //登录过程
                            //1、判断老师用户是否在数据库中注册
                            TeacherDao teacherDao = TeacherDao.getTeacherDao();
                            if (!et_user.getText().toString().equals("")){
                                boolean hasUserInDB = teacherDao.hasUserInDB(Integer.parseInt(et_user.getText().toString()));
                                if (hasUserInDB){
                                    //2、登录成功
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            Toast.makeText(getApplicationContext(),"老师登录成功",Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                    Intent intent1 = new Intent(context,ContentActivity.class);
                                    startActivity(intent1);
                                } else {
                                    //登录失败
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            Toast.makeText(getApplicationContext(),"教师用户没有注册",Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                }
                            }

                        }
                    }).start();
                } catch (Exception e){
                    Toast.makeText(getApplicationContext(),"后台建设升级中",Toast.LENGTH_SHORT).show();
                }
                break;

            default:
        }
    }

    public void loginSaveInfoBySP(){
        String user = et_user.getText().toString().trim();
        String password = et_password.getText().toString().trim();


        //user和密码非空判断
        if (TextUtils.isEmpty(user) || TextUtils.isEmpty(password)){
            Toast.makeText(getApplicationContext(),"用户和密码不能为空",Toast.LENGTH_SHORT).show();
        } else {
            SharedPreferences.Editor edit = sp.edit();
            boolean isChecked = ckb_issave.isChecked();

            //根据chekbox，如果保存用户信息
            if (isChecked){
                edit.putString("user",user);
                edit.putString("password",password);
            }
            edit.putBoolean("isChecked",isChecked);
            edit.commit();
        }
    }
}
