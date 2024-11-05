package com.ShopMan.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO723 {
    private String jdbcURL = "jdbc:sqlserver://localhost:1433;databaseName=ShopMan;encrypt=true;trustServerCertificate=true";
    private String jdbcUsername = "sa";
    private String jdbcPassword = "21062003";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
