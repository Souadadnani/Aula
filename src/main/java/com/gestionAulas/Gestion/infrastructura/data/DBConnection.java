package com.gestionAulas.Gestion.infrastructura.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {


    private static Connection connection;
    private static final String HOST="dbaurora.cluster-clb7qxolr0lc.us-east-1.rds.amazonaws.com";
    private static final int PORT = 3306;
    private static final String DB_NAME = "gestion_aulas";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "piramide";

    private DBConnection(){}

    public static Connection getInstance() {
        if(connection == null) {
            try {
                connection = DriverManager.getConnection(String.format("jdbc:mysql://%s:%d/%s", HOST, PORT, DB_NAME), USERNAME, PASSWORD);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }

}
