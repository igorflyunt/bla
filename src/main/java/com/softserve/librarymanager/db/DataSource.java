package com.softserve.librarymanager.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DataSource {
    private static final String DRIVER ="com.mysql.jdbc.Driver";
    private static final String USER_NAME = "root";
    private static final String USER_PASSWORD = "root";
    private static final String URL = "jdbc:mysql://localhost:3306/librarymanager?autoReconnect=true&useSSL=false";

    private static Connection dbConnection;

    static {
        try {
            Class.forName(DRIVER);
            dbConnection = DriverManager.getConnection(URL, USER_NAME, USER_PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private DataSource() { }

    public static Connection getDbConnection() {
        return dbConnection;
    }
}
