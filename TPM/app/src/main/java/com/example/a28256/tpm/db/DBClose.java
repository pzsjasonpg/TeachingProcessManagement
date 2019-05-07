package com.example.a28256.tpm.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBClose {

    public static void addConnect(PreparedStatement preparedStatement, Connection connection){
        try {
        if (preparedStatement != null) {
            preparedStatement.close();
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (connection != null){
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public  static  void queryClose(PreparedStatement ps, ResultSet rs, Connection conn){
        try{
            if (ps != null){
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (rs != null){
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (conn != null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
