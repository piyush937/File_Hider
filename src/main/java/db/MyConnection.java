package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
    public static Connection connection = null;

    // The return type 'Connection' was missing.
    public static Connection getConnection() {
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establishing the connection
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/File_Hider?useSSL=false", "root", "#cr7texf2vw");

            // Connection successful message
            System.out.println("Connection ho gya ESTABILISH");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

        return connection; // Return the connection
    }

    // Method to close the connection
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close(); // Closing the connection
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    // Main method to test the connection
    public static void main(String[] args) {
        MyConnection.getConnection();
    }
}
