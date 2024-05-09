/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.db;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import configuration.Configuration;

/**
 *
 * @author Mare
 */
public class DBConnection {

    private static DBConnection instance;

    private Connection connection;

    private DBConnection() {
        try {
            if (connection==null || connection.isClosed()) {
                String url = Configuration.getInstance().getProperty("url");
                String user = Configuration.getInstance().getProperty("user");
                String password = Configuration.getInstance().getProperty("password");

                connection = DriverManager.getConnection(url, user, password);
                connection.setAutoCommit(false);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static DBConnection getInstance() {
        if (instance == null) {
            instance = new DBConnection();
        }

        return instance;
    }

    public Connection getConnection() {
        try {
            if (connection==null || connection.isClosed()) {
                String url = Configuration.getInstance().getProperty("url");
                String user = Configuration.getInstance().getProperty("user");
                String password = Configuration.getInstance().getProperty("password");

                connection = DriverManager.getConnection(url, user, password);
                connection.setAutoCommit(false);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return connection;
    }
}
