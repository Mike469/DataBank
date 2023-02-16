package org.example;

import java.sql.*;

public class regLog {
    public static int random_accountNum() {
        int min = 10_000_000;
        int max = 90_000_000;
        return (int)Math.floor(Math.random() * (max - min + 1) + min);
    }

    public static int random_totalMoney() {
        int min = 100_000;
        int max = 1_000_000;
        return (int)Math.floor(Math.random() * (max - min + 1) + min);
    }
    public static void registration(String[] userPass) {
        try {
<<<<<<< HEAD
=======
<<<<<<< HEAD
            Connection connection = Main.getConnection();
            PreparedStatement st = connection.prepareStatement("INSERT INTO register (first_name, last_name, email_address, password) VALUES (?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
=======
>>>>>>> main
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/databank", "postgres", "Sept0905");
            PreparedStatement st = connection.prepareStatement("INSERT INTO register (first_name, last_name, email_address, password) VALUES (?,?,?,?)");
>>>>>>> 25e01b099173ea27b0f14701970e72ddadec7dd8
            st.setString(1, userPass[0]);
            st.setString(2, userPass[1]);
            st.setString(3, userPass[2]);
            st.setString(4, userPass[3]);
            st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();
            int registerId = 0;
            if (rs.next()) {
                registerId = rs.getInt(1);
            }
            PreparedStatement st2 = connection.prepareStatement("INSERT INTO customer (account_num, total, register_id) VALUES (?,?,?)");
            st2.setInt(1,random_accountNum());
            st2.setInt(2,random_totalMoney());
            st2.setInt(3,registerId);
            st2.executeUpdate();
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
