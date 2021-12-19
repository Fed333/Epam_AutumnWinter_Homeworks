package com.epam.studying.model;

import java.sql.Connection;

public class Model {
    private Connection connection;

    public Model(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }
}
