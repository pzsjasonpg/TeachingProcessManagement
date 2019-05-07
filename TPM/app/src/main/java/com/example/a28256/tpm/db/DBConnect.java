package com.example.a28256.tpm.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DBConnect {

    public static Connection getConn(){

        Connection connection = null;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://47.100.26.141:3306/teaching_process_management";
        String user = "$pzs";
        String password = "$pzs";

        try {
            //1.加载驱动
            Class.forName(driver);
            //2. 连接数据库
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

}
