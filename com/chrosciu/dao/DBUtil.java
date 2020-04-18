package com.chrosciu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class DBUtil {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/school?useSSL=false&characterEncoding=utf8&serverTimezone=UTC";
    private static final String DB_USER = "user";
    private static final String DB_PASS = "user";

    public static Connection connect() throws SQLException {
        Connection conn = DriverManager.getConnection(
                DB_URL,
                DB_USER,
                DB_PASS);
        return conn;
    }
}