package com.augmentum.examonline.until;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.augmentum.examonline.exception.DbException;
public class DbUtil {

    public static Connection getConnection() {
        try {
            Class.forName(PropertiesUtil.getProperty("jdbc.driver"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String jdcUrl = PropertiesUtil.getProperty("jdbc.url");
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(jdcUrl, PropertiesUtil.getProperty("jdbc.user"), PropertiesUtil.getProperty("jdbc.password"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new DbException();
        }
        return conn;
    }

    public static void close (ResultSet rs, PreparedStatement stmt, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}