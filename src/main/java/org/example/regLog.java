package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class regLog {
    public static boolean registration(String username, String password) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/databank", "postgres", "root");
            PreparedStatement st = connection.prepareStatement("INSERT INTO register (email_address, password) VALUES (?,?)");
            st.setString(1, username);
            st.setString(2, password);
            st.executeUpdate();
            System.out.println("Successful");
            return true;
        }catch (Exception e) {
            System.out.println(e);
            System.out.println("Unsuccessful");
            return false;
        }
    }
}
