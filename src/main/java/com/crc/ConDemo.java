package com.crc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * @Author CRC
 * @Date 2020/7/23
 * @Describe
 */
public class ConDemo {
    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://127.0.0.1/sys";
    private static String username = "root";
    private static String password = "admin";

    public static Connection mysqlconn() {
        //连接数据库
        Connection conn = null;
        try {
            conn = null;
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }
}
