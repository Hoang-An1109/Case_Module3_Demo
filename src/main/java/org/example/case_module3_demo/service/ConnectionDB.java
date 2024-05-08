package org.example.case_module3_demo.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    public static final String jdbcURL = "jdbc:mysql://localhost:3306/boarding_house_management?useUnicode=yes&characterEncoding=UTF-8";
    public static final String jdbcUsername = "root";
    public static final String jdbcPassword = "hoangan1109";
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (ClassNotFoundException e) {
            System.out.println("Kết nối không thành công.");
            throw new RuntimeException(e);
        } catch (SQLException e) {
            System.out.println("Kết nối không thành công");
            throw new RuntimeException(e);
        }
        System.out.println("Kết nối thành công");
        return connection;
    }
}
