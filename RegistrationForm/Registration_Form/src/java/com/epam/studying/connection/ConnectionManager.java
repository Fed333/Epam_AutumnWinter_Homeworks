package com.epam.studying.connection;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {
    Properties property = new Properties();

    public ConnectionManager(FileInputStream fis) throws IOException {
        property.load(fis);
    }

    public Connection getConnection(){
        Connection connection = null;

        try{
            connection = DriverManager.getConnection(
                    property.getProperty("postgre.datasource.url"),
                    property.getProperty("postgre.datasource.username"),
                    property.getProperty("postgre.datasource.password")
            );
        }
        catch (SQLException e){
            System.err.println("Failed connection");
            e.printStackTrace();
        }
        return connection;
    }
}
