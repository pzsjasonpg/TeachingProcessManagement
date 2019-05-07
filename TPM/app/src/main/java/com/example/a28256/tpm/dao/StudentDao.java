package com.example.a28256.tpm.dao;

import android.util.Log;

import com.example.a28256.tpm.db.DBClose;
import com.example.a28256.tpm.db.DBConnect;
import com.example.a28256.tpm.entity.EduStudent;
import com.example.a28256.tpm.entity.EduTeacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



/**
 * 数据库学生表操作
 */
public final class StudentDao {

    private static String TAG = "StudentDao";

    Connection conn = null;
    PreparedStatement ps = null;

    private static StudentDao studentDao = null;

    private StudentDao(){

    }

    //单例模式
    public static StudentDao getStudentDao(){
        if (studentDao == null){
            studentDao = new StudentDao();
            return studentDao;
        }
        return studentDao;
    }

    /**
     * 插入数据到数据库
     * @param eduStudent 学生信息对象
     * @return 是否成功插入数据到数据库表
     */
    public boolean addStuInfo(EduStudent eduStudent){
        boolean bool = false;
        conn = DBConnect.getConn();
        String sql = "INSERT INTO edu_student(StuName,StuNo,StuPassword,StuSchool,StuCollege," +
                "StuPro,StuClass,StuSex,StuAge,StuBirth," +
                "StuNation,StuMinzu,StuCard,StuPlace,StuTeachTime," +
                "StuEmail,StuPhone,StuHeadImage,EditTime,StuOther) VALUES(?,?,?,?,?," +
                "?,?,?,?,?," +
                "?,?,?,?,?," +
                "?,?,?,?,?) ";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,eduStudent.getStuName());
            ps.setInt(2,eduStudent.getStuNo());
            ps.setString(3,eduStudent.getStuPassword());
            ps.setString(4,eduStudent.getStuSchool());
            ps.setString(5,eduStudent.getStuCollege());
            ps.setString(6,eduStudent.getStuPro());
            ps.setInt(7,eduStudent.getStuClass());
            ps.setString(8,eduStudent.getStuSex());
            ps.setInt(9,eduStudent.getStuAge());
            ps.setString(10,eduStudent.getStuBirth());
            ps.setString(11,eduStudent.getStuNation());
            ps.setString(12,eduStudent.getStuMinZu());
            ps.setString(13,eduStudent.getStuCard());
            ps.setString(14,eduStudent.getStuPlace());
            ps.setString(15,eduStudent.getStuTeachTime());
            ps.setString(16,eduStudent.getStuEmail());
            ps.setString(17,eduStudent.getStuPhone());
            ps.setString(18,eduStudent.getStuHeadImage());
            ps.setTimestamp(19,eduStudent.getEditTime());
            ps.setString(20,eduStudent.getStuOther());

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


    public boolean updateStuInfo(int stuNO, EduStudent eduStudent){

        boolean bool = false;
        conn = DBConnect.getConn();

        String sql = "UPDATE edu_student SET StuPassword=? WHERE StuNo=?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,eduStudent.getStuPassword());
            ps.setInt(2,stuNO);

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

    public boolean hasUserInDB(int stuNo){
        boolean bool = false;
        conn = DBConnect.getConn();
        ResultSet resultSet = null;

        String sql = "SELECT * FROM edu_student WHERE StuNo = ?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,stuNo);
            resultSet = ps.executeQuery();
            if (resultSet.next()){
                bool = true;

                int stuNo1 = resultSet.getInt("StuNo");
                String stuPassword = resultSet.getString("StuPassword");
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
