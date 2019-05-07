package com.example.a28256.tpm.entity;

import java.sql.Timestamp;

/**
 * CREATE TABLE `edu_teacher` (
 *   `TeId` int(8) NOT NULL AUTO_INCREMENT COMMENT '自增id',
 *   `TeName` varchar(10) NOT NULL COMMENT '教师名称',
 *   `TeNo` int(15) NOT NULL COMMENT '教职工编号',
 *   `TePassword` varchar(20) NOT NULL COMMENT '教师密码',
 *   `TeSex` char(2) DEFAULT NULL COMMENT '教师性别',
 *   `TeBirth` varchar(20) DEFAULT NULL COMMENT '出生年月',
 *   `TeIn` varchar(20) NOT NULL COMMENT '入职时间',
 *   `TeCard` varchar(20) DEFAULT NULL COMMENT '教师身份证',
 *   `TePosition` varchar(20) DEFAULT NULL COMMENT '教师身份（教授/副教授）',
 *   `TeColleage` varchar(20) NOT NULL COMMENT '教师学院',
 *   `TeProve` varchar(30) NOT NULL COMMENT '教师证件',
 *   `TeAdress` varchar(30) DEFAULT NULL COMMENT '地址',
 *   `TeEmail` varchar(20) DEFAULT NULL COMMENT '教师邮箱',
 *   `TePhone` varchar(20) NOT NULL COMMENT '联系方式',
 *   `TeOther` varchar(30) DEFAULT NULL COMMENT '其他信息',
 *   `EditTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
 *   PRIMARY KEY (`TeId`)
 * ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */

public final class EduTeacher {
    private int teacherId;
    private String teacherName;
    private int teacherNo;
    private String teacherPassword;
    private String teacherGender;
    private String teacherBirth;
    private String teacherInTime;
    private String teacherCard;
    private String teacherPosition;
    private String teacherCollege;
    private String teacherProve;
    private String teacherAddress;
    private String teacherEmail;
    private String teacherPhone;
    private String teacherOther;
    private Timestamp teacherTimestamp;

    public EduTeacher() {
    }

    public String getTeacherName() {
        return teacherName;
    }

    public int getTeacherNo() {
        return teacherNo;
    }

    public String getTeacherPassword() {
        return teacherPassword;
    }

    public String getTeacherGender() {
        return teacherGender;
    }

    public String getTeacherBirth() {
        return teacherBirth;
    }

    public String getTeacherInTime() {
        return teacherInTime;
    }

    public String getTeacherCard() {
        return teacherCard;
    }

    public String getTeacherPosition() {
        return teacherPosition;
    }

    public String getTeacherCollege() {
        return teacherCollege;
    }

    public String getTeacherProve() {
        return teacherProve;
    }

    public String getteacherAddress() {
        return teacherAddress;
    }

    public String getTeacherEmail() {
        return teacherEmail;
    }

    public String getTeacherPhone() {
        return teacherPhone;
    }

    public String getTeacherOther() {
        return teacherOther;
    }

    public Timestamp getTeacherTimestamp() {
        return teacherTimestamp;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public void setTeacherNo(int teacherNo) {
        this.teacherNo = teacherNo;
    }

    public void setTeacherPassword(String teacherPassword) {
        this.teacherPassword = teacherPassword;
    }

    public void setTeacherGender(String teacherGender) {
        this.teacherGender = teacherGender;
    }

    public void setTeacherBirth(String teacherBirth) {
        this.teacherBirth = teacherBirth;
    }

    public void setTeacherInTime(String teacherInTime) {
        this.teacherInTime = teacherInTime;
    }

    public void setTeacherCard(String teacherCard) {
        this.teacherCard = teacherCard;
    }

    public void setTeacherPosition(String teacherPosition) {
        this.teacherPosition = teacherPosition;
    }

    public void setTeacherCollege(String teacherCollege) {
        this.teacherCollege = teacherCollege;
    }

    public void setTeacherProve(String teacherProve) {
        this.teacherProve = teacherProve;
    }

    public void setteacherAddress(String teacherAddress) {
        this.teacherAddress = teacherAddress;
    }

    public void setTeacherEmail(String teacherEmail) {
        this.teacherEmail = teacherEmail;
    }

    public void setTeacherPhone(String teacherPhone) {
        this.teacherPhone = teacherPhone;
    }

    public void setTeacherOther(String teacherOther) {
        this.teacherOther = teacherOther;
    }

    public void setTeacherTimestamp(Timestamp teacherTimestamp) {
        this.teacherTimestamp = teacherTimestamp;
    }


}
