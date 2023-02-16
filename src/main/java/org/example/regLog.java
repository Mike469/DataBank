package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class regLog {
    public static void registration(String[] userPass) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/databank", "postgres", "Sept0905");
            PreparedStatement st = connection.prepareStatement("INSERT INTO register (first_name, last_name, email_address, password) VALUES (?,?,?,?)");
            st.setString(1, userPass[0]);
            st.setString(2, userPass[1]);
            st.setString(3, userPass[2]);
            st.setString(4, userPass[3]);
            st.executeUpdate();
            System.out.println("Successful");
        }catch (Exception e) {
            System.out.println(e);
            System.out.println("Unsuccessful");
        }
    }

    public static String login(String[] userPass) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/databank", "postgres", "Sept0905");
            PreparedStatement st = connection.prepareStatement("SELECT email_address, password FROM register");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                if (rs.getString("email_address").equals(userPass[0]) && rs.getString("password").equals(userPass[1])) {
                    return userPass[0];
                };
            }
            rs.close();
            st.close();
            return "Unsuccessful";
        }catch (Exception e ) {
            System.out.println(e);
            System.out.println("Unsuccessful");
            return "Unsuccessful";
        }
    }
}
