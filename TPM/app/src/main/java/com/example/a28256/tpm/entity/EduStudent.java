package com.example.a28256.tpm.entity;

import java.sql.Timestamp;

/**
 * 学生实体类
 */
public final class EduStudent {
/**
 * CREATE TABLE `edu_student` (
 *   `StuId` int(8) NOT NULL AUTO_INCREMENT,
 *   `StuName` varchar(20) DEFAULT NULL COMMENT '学生名称',
 *   `StuNo` int(10) DEFAULT NULL COMMENT '学号',
 *   `StuPassword` varchar(20) DEFAULT NULL COMMENT '学生密码',
 *   `StuSchool` varchar(20) NOT NULL COMMENT '学校',
 *   `StuCollege` varchar(20) NOT NULL COMMENT '学院',
 *   `StuPro` varchar(20) NOT NULL COMMENT '专业',
 *   `StuClass` int(10) NOT NULL COMMENT '班级',
 *   `StuSex` char(2) DEFAULT NULL COMMENT '性别',
 *   `StuAge` int(4) DEFAULT NULL COMMENT '年龄',
 *   `StuBirth` varchar(20) DEFAULT NULL COMMENT '出生日期',
 *   `StuNation` varchar(10) DEFAULT NULL COMMENT '国籍',
 *   `StuminZu` varchar(10) DEFAULT NULL COMMENT '民族',
 *   `StuCard` varchar(20) DEFAULT NULL COMMENT '身份证',
 *   `StuPlace` varchar(30) DEFAULT NULL COMMENT '出生地',
 *   `StuTeachTime` varchar(20) DEFAULT NULL COMMENT '教育时间',
 *   `StuEmail` varchar(20) DEFAULT NULL COMMENT '学生邮箱',
 *   `StuPhone` varchar(15) DEFAULT NULL COMMENT '学生电话',
 *   `StuHeadImage` varchar(30) DEFAULT NULL COMMENT '学生头像',
 *   `EditTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
 *   `StuOther` varchar(20) DEFAULT NULL COMMENT '其他备注',
 *   PRIMARY KEY (`StuId`)
 * ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */

    private int stuId;
    private String stuName;
    private int stuNo;
    private String stuPassword;
    private String stuSchool;
    private String stuCollege;
    private String stuPro;
    private int stuClass;
    private String stuSex;
    private int stuAge;
    private String stuBirth;
    private String stuNation;
    private String stuMinZu;
    private String stuCard;
    private String stuPlace;
    private String stuTeachTime;
    private String stuEmail;
    private String stuPhone;
    private String stuHeadImage;
    private Timestamp editTime;
    private String stuOther;


    public EduStudent() {
    }

    //根据学号设置密码
    public EduStudent(int stuNo, String stuPassword) {
        this.stuNo = stuNo;
        this.stuPassword = stuPassword;
    }

    //根据姓名设置密码
    public EduStudent(String stuName, String stuPassword) {
        this.stuName = stuName;
        this.stuPassword = stuPassword;
    }

    //展示姓名、学号、密码
    public EduStudent(String stuName, int stuNo, String stuPassword) {
        this.stuName = stuName;
        this.stuNo = stuNo;
        this.stuPassword = stuPassword;
    }


    //展示其他信息
    public EduStudent(String stuPro, int stuClass, String stuSex, int stuAge, String stuBirth,
                      String stuNation, String stuMinZu, String stuCard, String stuPlace,
                      String stuTeachTime, String stuEmail, String stuPhone, String stuHeadImage,
                      Timestamp editTime, String stuOther) {
        this.stuPro = stuPro;
        this.stuClass = stuClass;
        this.stuSex = stuSex;
        this.stuAge = stuAge;
        this.stuBirth = stuBirth;
        this.stuNation = stuNation;
        this.stuMinZu = stuMinZu;
        this.stuCard = stuCard;
        this.stuPlace = stuPlace;
        this.stuTeachTime = stuTeachTime;
        this.stuEmail = stuEmail;
        this.stuPhone = stuPhone;
        this.stuHeadImage = stuHeadImage;
        this.editTime = editTime;
        this.stuOther = stuOther;
    }

    //设置除id,EditTime,Other外所有属性,就是APP注册上的信息
    public EduStudent(String stuName, int stuNo, String stuPassword, String stuSchool,
                      String stuCollege, String stuPro, int stuClass, String stuSex,
                      int stuAge, String stuBirth, String stuNation, String stuMinZu,
                      String stuCard, String stuPlace, String stuTeachTime, String stuEmail,
                      String stuPhone, String stuHeadImage) {
        this.stuName = stuName;
        this.stuNo = stuNo;
        this.stuPassword = stuPassword;
        this.stuSchool = stuSchool;
        this.stuCollege = stuCollege;
        this.stuPro = stuPro;
        this.stuClass = stuClass;
        this.stuSex = stuSex;
        this.stuAge = stuAge;
        this.stuBirth = stuBirth;
        this.stuNation = stuNation;
        this.stuMinZu = stuMinZu;
        this.stuCard = stuCard;
        this.stuPlace = stuPlace;
        this.stuTeachTime = stuTeachTime;
        this.stuEmail = stuEmail;
        this.stuPhone = stuPhone;
        this.stuHeadImage = stuHeadImage;
        this.editTime = editTime;
    }

    //设置所有属性
    public EduStudent(int stuId, String stuName, int stuNo, String stuPassword, String stuSchool,
                      String stuCollege, String stuPro, int stuClass, String stuSex,
                      int stuAge, String stuBirth, String stuNation, String stuMinZu,
                      String stuCard, String stuPlace, String stuTeachTime, String stuEmail,
                      String stuPhone, String stuHeadImage, Timestamp editTime, String stuOther) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.stuNo = stuNo;
        this.stuPassword = stuPassword;
        this.stuSchool = stuSchool;
        this.stuCollege = stuCollege;
        this.stuPro = stuPro;
        this.stuClass = stuClass;
        this.stuSex = stuSex;
        this.stuAge = stuAge;
        this.stuBirth = stuBirth;
        this.stuNation = stuNation;
        this.stuMinZu = stuMinZu;
        this.stuCard = stuCard;
        this.stuPlace = stuPlace;
        this.stuTeachTime = stuTeachTime;
        this.stuEmail = stuEmail;
        this.stuPhone = stuPhone;
        this.stuHeadImage = stuHeadImage;
        this.editTime = editTime;
        this.stuOther = stuOther;
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public int getStuNo() {
        return stuNo;
    }

    public void setStuNo(int stuNo) {
        this.stuNo = stuNo;
    }

    public String getStuPassword() {
        return stuPassword;
    }

    public void setStuPassword(String stuPassword) {
        this.stuPassword = stuPassword;
    }

    public String getStuSchool() {
        return stuSchool;
    }

    public void setStuSchool(String stuSchool) {
        this.stuSchool = stuSchool;
    }

    public String getStuCollege() {
        return stuCollege;
    }

    public void setStuCollege(String stuCollege) {
        this.stuCollege = stuCollege;
    }

    public String getStuPro() {
        return stuPro;
    }

    public void setStuPro(String stuPro) {
        this.stuPro = stuPro;
    }

    public int getStuClass() {
        return stuClass;
    }

    public void setStuClass(int stuClass) {
        this.stuClass = stuClass;
    }

    public String getStuSex() {
        return stuSex;
    }

    public void setStuSex(String stuSex) {
        this.stuSex = stuSex;
    }

    public int getStuAge() {
        return stuAge;
    }

    public void setStuAge(int stuAge) {
        this.stuAge = stuAge;
    }

    public String getStuBirth() {
        return stuBirth;
    }

    public void setStuBirth(String stuBirth) {
        this.stuBirth = stuBirth;
    }

    public String getStuNation() {
        return stuNation;
    }

    public void setStuNation(String stuNation) {
        this.stuNation = stuNation;
    }

    public String getStuMinZu() {
        return stuMinZu;
    }

    public void setminZu(String stuMinZu) {
        this.stuMinZu = stuMinZu;
    }

    public String getStuCard() {
        return stuCard;
    }

    public void setStuCard(String stuCard) {
        this.stuCard = stuCard;
    }

    public String getStuPlace() {
        return stuPlace;
    }

    public void setStuPlace(String stuPlace) {
        this.stuPlace = stuPlace;
    }

    public String getStuTeachTime() {
        return stuTeachTime;
    }

    public void setStuTeachTime(String stuTeachTime) {
        this.stuTeachTime = stuTeachTime;
    }

    public String getStuEmail() {
        return stuEmail;
    }

    public void setStuEmail(String stuEmail) {
        this.stuEmail = stuEmail;
    }

    public String getStuPhone() {
        return stuPhone;
    }

    public void setStuPhone(String stuPhone) {
        this.stuPhone = stuPhone;
    }

    public String getStuHeadImage() {
        return stuHeadImage;
    }

    public void setStuHeadImage(String stuHeadImage) {
        this.stuHeadImage = stuHeadImage;
    }

    public Timestamp getEditTime() {
        return editTime;
    }

    public void setEditTime(Timestamp editTime) {
        this.editTime = editTime;
    }

    public String getStuOther() {
        return stuOther;
    }

    public void setStuOther(String stuOther) {
        this.stuOther = stuOther;
    }

}
