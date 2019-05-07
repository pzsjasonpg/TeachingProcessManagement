package com.example.a28256.tpm;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.a28256.tpm.dao.StudentDao;
import com.example.a28256.tpm.db.DBConnect;
import com.example.a28256.tpm.entity.EduStudent;
import com.example.a28256.tpm.entity.EduTeacher;

import java.sql.Connection;
import java.util.StringTokenizer;

public class StudentRegisetActivity extends AppCompatActivity implements View.OnClickListener,Runnable {

    private Button btn_back;
    private Button btn_registerSubmit;

    private EditText username;
    private EditText studentno;
    private EditText password;
    private EditText school;
    private EditText college;
    private EditText pro;
    private EditText stuClass;
    private RadioGroup sex;
    private EditText age;
    private EditText birth;
    private EditText nation;
    private EditText minzu;
    private EditText card;
    private EditText place;
    private EditText teachtime;
    private EditText email;
    private EditText phone;

    private EduStudent eduStudent;

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {

            if (msg.what == 1){
                String registerSucess = (String) msg.obj;
                Toast.makeText(getApplicationContext(),registerSucess,Toast.LENGTH_LONG).show();
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_regiset);

        if (eduStudent == null){
            eduStudent = new EduStudent();
        }

        btn_back = (Button) findViewById(R.id.btn_login_student_register_back);
        btn_registerSubmit = (Button) findViewById(R.id.tv_sturegister_submit);

        //获取EditView中的字符信息
        username = (EditText) findViewById(R.id.et_sturegister_username);
        studentno = (EditText) findViewById(R.id.et_sturegister_studentno);
        password = (EditText) findViewById(R.id.et_sturegister_password);
        school = (EditText) findViewById(R.id.et_sturegister_school);
        college = (EditText) findViewById(R.id.et_sturegister_college);
        pro = (EditText) findViewById(R.id.et_sturegister_pro);
        stuClass = (EditText) findViewById(R.id.et_sturegister_class);
        sex = (RadioGroup) findViewById(R.id.radiogroup_sturegister_sex);
        age = (EditText) findViewById(R.id.et_sturegister_age);
        birth = (EditText) findViewById(R.id.et_sturegister_birth);
        nation = (EditText) findViewById(R.id.et_sturegister_nation);
        minzu = (EditText) findViewById(R.id.et_sturegister_minzu);
        card = (EditText) findViewById(R.id.et_sturegister_card);
        place = (EditText) findViewById(R.id.et_sturegister_place);
        teachtime = (EditText) findViewById(R.id.et_sturegister_teachtime);
        email = (EditText) findViewById(R.id.et_sturegister_email);
        phone = (EditText) findViewById(R.id.et_sturegister_phone);

        sex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                //获取选中的id
                int checkedRadioButtonId = group.getCheckedRadioButtonId();
                RadioButton radioSex = (RadioButton) findViewById(checkedRadioButtonId);
                //获取内容
                String sexString = radioSex.getText().toString().toString();
                if (!TextUtils.isEmpty(sexString)){
                    if (sexString.equals("男")){
                        eduStudent.setStuSex("m"+"");
                    } else {
                        eduStudent.setStuSex("f"+"");
                    }
                }

//                String sexString = null;
//                sexString = checkedId == R.id.rb_sturegister_male ? "m" : "f";
//                if (!TextUtils.isEmpty(sexString)){
//                    EduTeacher.setStuSex(sexString);
//                }
                Log.d("Student_sexString",sexString);

            }
        });

        btn_back.setOnClickListener(this);
        btn_registerSubmit.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.btn_login_student_register_back:
                finish();
                break;
            case R.id.tv_sturegister_submit:
                try {
                    Thread thread = new Thread(this);
                    thread.start();
                } catch (Exception e){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(), "后台服务升级建设中", Toast.LENGTH_LONG).show();
                        }
                    });
                }
                break;
        }
    }

    public EduStudent initStudent(){

        //得到EditText的信息,并设置EduTeacher
        String usernameText = username.getText().toString();
        if (!TextUtils.isEmpty(usernameText)){
            eduStudent.setStuName(usernameText);
        }
        Log.d("Student_usernameText",usernameText);

        String studentnoText = studentno.getText().toString();
        if (!TextUtils.isEmpty(studentnoText)){
            eduStudent.setStuNo(Integer.parseInt(studentnoText));
        }
        Log.d("Student_studentnoText",studentnoText);

        String passwordText = password.getText().toString();
        if (!TextUtils.isEmpty(passwordText)){
            eduStudent.setStuPassword(passwordText);
        }
        Log.d("Student_passwordText",passwordText);

        String schoolText = school.getText().toString();
        if (!TextUtils.isEmpty(schoolText)){
            eduStudent.setStuSchool(schoolText);
        }
        Log.d("Student_schoolText",schoolText);

        String collegeText = college.getText().toString();
        if (!TextUtils.isEmpty(collegeText)){
            eduStudent.setStuCollege(collegeText);
        }
        Log.d("Student_collegeText",collegeText);

        String proText = pro.getText().toString();
        if (!TextUtils.isEmpty(proText)){
            eduStudent.setStuPro(proText);
        }
        Log.d("Student_proText",proText);

        String stuClassText = stuClass.getText().toString();
        if (!TextUtils.isEmpty(stuClassText)){
            int classInt = Integer.parseInt(stuClassText);
            eduStudent.setStuClass(classInt);
        }
        Log.d("Student_stuClassText",stuClassText);



        String ageText = age.getText().toString();
        if (!TextUtils.isEmpty(ageText)){
            int ageInt = Integer.parseInt(ageText);
            eduStudent.setStuAge(ageInt);
        }
        Log.d("Student_ageText",ageText);

        String birthText = birth.getText().toString();
        if (!TextUtils.isEmpty(birthText)){
            eduStudent.setStuBirth(birthText);
        }
        Log.d("Student_birthText",birthText);

        String nationText = nation.getText().toString();
        if (!TextUtils.isEmpty(nationText)){
            eduStudent.setStuNation(nationText);
        }
        Log.d("Student_nationText",nationText);

        String minzuText = minzu.getText().toString();
        if (!TextUtils.isEmpty(minzuText)){
            eduStudent.setminZu(minzuText);
        }
        Log.d("Student_minzuText",minzuText);

        String cardText = card.getText().toString();
        if (!TextUtils.isEmpty(cardText)){
            eduStudent.setStuCard(cardText);
        }
        Log.d("Student_cardText",cardText);

        String placeText = place.getText().toString();
        if (!TextUtils.isEmpty(placeText)){
            eduStudent.setStuPlace(placeText);
        }
        Log.d("Student_placeText",placeText);

        String teachtimeText = teachtime.getText().toString();
        if (!TextUtils.isEmpty(teachtimeText)){
            eduStudent.setStuTeachTime(teachtimeText);
        }
        Log.d("Student_teachtimeText",teachtimeText);

        String emailText = email.getText().toString();
        if (!TextUtils.isEmpty(emailText)){
            eduStudent.setStuEmail(emailText);
        }
        Log.d("Student_emailText",emailText);

        String phoneText = phone.getText().toString();
        if (!TextUtils.isEmpty(phoneText)){
            eduStudent.setStuPhone(phoneText);
        }
        Log.d("Student_phoneText",phoneText);



        return eduStudent;
    }

    @Override
    public void run() {
        EduStudent eduStudent = initStudent();
        //创建dao对象
        StudentDao studentDao = StudentDao.getStudentDao();
        //注册学生表信息
        boolean isAddStuInfoSucess = studentDao.addStuInfo(eduStudent);
        if (isAddStuInfoSucess) {
            Message message = new Message();
            message.what = 1;
            message.obj = "学生信息注册成功";
            handler.sendMessage(message);
        } else {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getApplicationContext(), "注册失败", Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}
