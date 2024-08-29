package dao;

import db.MyConnection;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class UserDAO {
    public static boolean isExists(String email) throws SQLException {
        Connection connection = MyConnection.getConnection();
        String query = "SELECT 1 FROM users WHERE email = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();

            // Check if the ResultSet has any rows
            return rs.next(); // If there is a result, the email exists
        } finally {
            // Close the ResultSet and PreparedStatement
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
        }
    }


    public static int saveUser(User user) throws SQLException {
        Connection connection = MyConnection.getConnection();
        PreparedStatement ps =connection.prepareStatement("insert into users values(default, ?, ?)");
        ps.setString(1, user.getName());
        ps.setString(2, user.getEmail());
        return ps.executeUpdate();
    }
}


/*public class UserDAO {
    public static boolean isExists(String email)throws SQLException {
        Connection connection = MyConnection.getConnection();
        PreparedStatement ps = connection.prepareStatement("select email from users");
      ResultSet rs =   ps.executeQuery();
        while (rs.next()) {
            String e = rs.getString(1);
            if(e.equals(email))
                return true;
        }
        return false;
    }
    public static int saveUser(User user) throws SQLException {
        Connection connection = MyConnection.getConnection();
        PreparedStatement ps = connection.prepareStatement( "INSERT INTO users (name, email) VALUES (?, ?)");
        ps.setString(1, user.getName());
        ps.setString(2,user.getEmail());
         return ps.executeUpdate();
    }

}*/
/*
public class UserDAO {

    // Check if an email already exists in the users table
    public static boolean isExists(String email) throws SQLException {
        Connection connection = MyConnection.getConnection();
        String query = "SELECT email FROM users WHERE email = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, email);
        ResultSet rs = ps.executeQuery();

        // Return true if the email is found
        return rs.next();
    }

    // Save a new user in the users table
    public static int saveUser(User user) throws SQLException {
        Connection connection = MyConnection.getConnection();
        String query = "INSERT INTO users (name, email) VALUES (?, ?)";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, user.getName());
        ps.setString(2, user.getEmail());

        // Execute the insert and return the number of rows affected
        return ps.executeUpdate();
    }
}

        package dao;

import db.MyConnection;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;*/

