package com.example.a28256.tpm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a28256.tpm.dao.TeacherDao;
import com.example.a28256.tpm.entity.EduTeacher;

public class TeacherRegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText teacherNameEt;
    private EditText teacherNoEt;
    private EditText teacherPasswordEt;
    private EditText teacherGenderEt;
    private EditText teacherBirthEt;
    private EditText teacherInTimeEt;
    private EditText teacherCardEt;
    private EditText teacherPositionEt;
    private EditText teacherCollegeEt;
    private EditText teacherProveEt;
    private EditText teacherAddressEt;
    private EditText teacherEmailEt;
    private EditText teacherPhoneEt;
    private Button teacherRegister;
    private Button back;

    EduTeacher eduTeacher = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_register);

        //找到id
        back = (Button) findViewById(R.id.btn_teacher_register_back);

        teacherNameEt = (EditText) findViewById(R.id.et_teacher_register_teacher_name);
        teacherNoEt = (EditText) findViewById(R.id.et_teacher_register_teacher_no);
        teacherPasswordEt = (EditText) findViewById(R.id.et_teacher_register_teacher_password);
        teacherGenderEt = (EditText) findViewById(R.id.et_teacher_register_teacher_gender);
        teacherBirthEt = (EditText) findViewById(R.id.et_teacher_register_teacher_birth);
        teacherInTimeEt = (EditText) findViewById(R.id.et_teacher_register_teacher_in_time);
        teacherCardEt = (EditText) findViewById(R.id.et_teacher_register_teacher_card);
        teacherPositionEt = (EditText) findViewById(R.id.et_teacher_register_teacher_position);
        teacherCollegeEt = (EditText) findViewById(R.id.et_teacher_register_teacher_college);
        teacherProveEt = (EditText) findViewById(R.id.et_teacher_register_teacher_prove);
        teacherAddressEt = (EditText) findViewById(R.id.et_teacher_register_teacher_address);
        teacherEmailEt = (EditText) findViewById(R.id.et_teacher_register_teacher_email);
        teacherPhoneEt = (EditText) findViewById(R.id.et_teacher_register_teacher_phone);

        teacherRegister = (Button) findViewById(R.id.btn_teacher_register_register);

        //设置按钮监听事件
        back.setOnClickListener(this);
        teacherRegister.setOnClickListener(this);


        if (eduTeacher == null){
            eduTeacher = new EduTeacher();
        }

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.btn_teacher_register_back:
                finish();
                break;
            case R.id.btn_teacher_register_register:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                       try {
                           EduTeacher eduTeacher = initTeacher();
                           TeacherDao teacherDao = TeacherDao.getTeacherDao();
                           boolean isInsertSucess = teacherDao.addStuInfo(eduTeacher);
                           if (isInsertSucess){
                               runOnUiThread(new Runnable() {
                                   @Override
                                   public void run() {
                                       Toast.makeText(getApplicationContext(),"教师信息注册成功",Toast.LENGTH_LONG).show();
                                   }
                               });
                           } else {
                               runOnUiThread(new Runnable() {
                                   @Override
                                   public void run() {
                                       Toast.makeText(getApplicationContext(),"教师信息注册失败",Toast.LENGTH_LONG).show();
                                   }
                               });
                           }
                       } catch (Exception e){
                           runOnUiThread(new Runnable() {
                               @Override
                               public void run() {
                                   Toast.makeText(getApplicationContext(),"后台建设升级中",Toast.LENGTH_LONG).show();
                               }
                           });
                       }
                    }
                }).start();
        }
    }

    public EduTeacher initTeacher(){
        //数据库非空的字段不能不填
        String teacherName = teacherNameEt.getText().toString();
        String teacherNo = teacherNoEt.getText().toString();
        String teacherPassword = teacherPasswordEt.getText().toString();
        String teacherInTime = teacherInTimeEt.getText().toString();
        String teacherCollege = teacherCollegeEt.getText().toString();
        String teacherProve = teacherProveEt.getText().toString();
        String teacherPhone = teacherPhoneEt.getText().toString();
        if (TextUtils.isEmpty(teacherName) || TextUtils.isEmpty(teacherNo) || TextUtils.isEmpty(teacherPassword) || TextUtils.isEmpty(teacherInTime)
                || TextUtils.isEmpty(teacherCollege) || TextUtils.isEmpty(teacherProve) || TextUtils.isEmpty(teacherPhone)){
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getApplicationContext(),"必要的数据不能为空",Toast.LENGTH_LONG).show();
                }
            });
        } else {
            //必要数据都有
            eduTeacher.setTeacherName(teacherName);
            eduTeacher.setTeacherNo(Integer.parseInt(teacherNo));
            eduTeacher.setTeacherPassword(teacherPassword);
            eduTeacher.setTeacherInTime(teacherInTime);
            eduTeacher.setTeacherCollege(teacherCollege);
            eduTeacher.setTeacherProve(teacherProve);
            eduTeacher.setTeacherPhone(teacherPhone);
        }

        //可以为空的数据
        String teacherGender = teacherGenderEt.getText().toString();
        if (!TextUtils.isEmpty(teacherGender)){
            eduTeacher.setTeacherGender(teacherGender);
        }
        String teacherBirth = teacherBirthEt.getText().toString();
        if (!TextUtils.isEmpty(teacherBirth)){
            eduTeacher.setTeacherBirth(teacherBirth);
        }
        String teacherCard = teacherCardEt.getText().toString();
        if (!TextUtils.isEmpty(teacherCard)){
            eduTeacher.setTeacherCard(teacherCard);
        }
        String teacherPosition = teacherPositionEt.getText().toString();
        if (!TextUtils.isEmpty(teacherPosition)){
            eduTeacher.setTeacherPosition(teacherPosition);
        }
        String teacherAddress = teacherAddressEt.getText().toString();
        if (!TextUtils.isEmpty(teacherAddress)){
            eduTeacher.setteacherAddress(teacherAddress);
        }
        String teacherEmail = teacherEmailEt.getText().toString();
        if (!TextUtils.isEmpty(teacherEmail)){
            eduTeacher.setTeacherEmail(teacherEmail);
        }
        return  eduTeacher;

    }
}
