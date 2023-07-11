package org.example.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String JDBC_URL = "jdbc:h2:/Desktop/goit/h2/5";
    private static final String JDBC_USER = "sa";
    private static final String JDBC_PASSWORD = "";
    private static final Database INSTANCE = new Database();

    private static Database instance;
    private Connection connection;
    public Database() {
        try {
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static Database getInstance() {
        return INSTANCE;
    }

}