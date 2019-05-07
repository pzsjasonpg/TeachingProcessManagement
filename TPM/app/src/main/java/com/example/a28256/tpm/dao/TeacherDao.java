package com.example.a28256.tpm.dao;

import android.util.Log;

import com.example.a28256.tpm.db.DBClose;
import com.example.a28256.tpm.db.DBConnect;
import com.example.a28256.tpm.entity.EduTeacher;
import com.example.a28256.tpm.entity.EduTeacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public final class TeacherDao {

    private static String TAG = "TeacherDao";

    Connection conn = null;
    PreparedStatement ps = null;

    private static TeacherDao teacherDao;

    private TeacherDao(){

    }

    public static TeacherDao getTeacherDao(){
        if (teacherDao == null){
            teacherDao = new TeacherDao();
            return teacherDao;
        }
        return teacherDao;
    }


    /**
     * 插入数据到数据库
     * @param eduTeacher 老师信息对象
     * @return 是否成功插入数据到数据库表
     */
    public boolean addStuInfo(EduTeacher eduTeacher){
        boolean bool = false;
        conn = DBConnect.getConn();
        String sql = "INSERT INTO edu_teacher(TeName,TeNo,TePassword,TeSex,TeBirth," +
                "TeIn,TeCard,TePosition,TeColleage,TeProve," +
                "TeAdress,TeEmail,TePhone) VALUES(?,?,?,?,?," +
                "?,?,?,?,?," +
                "?,?,?) ";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,eduTeacher.getTeacherName());
            ps.setInt(2,eduTeacher.getTeacherNo());
            ps.setString(3,eduTeacher.getTeacherPassword());
            ps.setString(4,eduTeacher.getTeacherGender());
            ps.setString(5,eduTeacher.getTeacherBirth());
            ps.setString(6,eduTeacher.getTeacherInTime());
            ps.setString(7,eduTeacher.getTeacherCard());
            ps.setString(8,eduTeacher.getTeacherPosition());
            ps.setString(9,eduTeacher.getTeacherCollege());
            ps.setString(10,eduTeacher.getTeacherProve());
            ps.setString(11,eduTeacher.getteacherAddress());
            ps.setString(12,eduTeacher.getTeacherEmail());
            ps.setString(13,eduTeacher.getTeacherPhone());

            int rs = ps.executeUpdate();
            if (rs > 0){
                bool = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBClose.addConnect(ps,conn);
        }
        return bool;
    }

    public boolean hasUserInDB(int teNo){
        boolean bool = false;
        conn = DBConnect.getConn();
        ResultSet resultSet = null;

        String sql = "SELECT * FROM edu_teacher WHERE TeNo = ?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,teNo);
            resultSet = ps.executeQuery();
            if (resultSet.next()){
                bool = true;

                int stuNo1 = resultSet.getInt("TeNo");
                String stuPassword = resultSet.getString("TePassword");
                Log.d(TAG, "hasUserInDB: "+stuNo1+":"+stuPassword);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBClose.queryClose(ps,resultSet,conn);
        }
        return bool;
    }




}
