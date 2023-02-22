package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.example.Main.scanner;

public class CustomerFuncs {
    public static Connection connection;

    static {
        try {
            connection = ConnectDB.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static int emailConversion(String email) throws SQLException {
        PreparedStatement st = connection.prepareStatement("SELECT id FROM register WHERE email_address = ?");
        st.setString(1, email);
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            return rs.getInt("id");
        }
        rs.close();
        st.close();
        return 1;
    }

    public static String emailToName(String email) throws SQLException {
        PreparedStatement st = connection.prepareStatement("SELECT first_name FROM register where email_address = ?");
        st.setString(1, email);
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            return rs.getString("first_name");
        }
        rs.close();
        st.close();
        return "User";
    }
    public static int total(int id) throws SQLException {
        PreparedStatement st = connection.prepareStatement("Select total FROM customer WHERE register_id = ?");
        st.setInt(1, id);
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            return rs.getInt("total");
        }
        rs.close();
        st.close();
        return 0;
    }
    public static void withdraw(String email) throws SQLException {
        System.out.print("How much money do you wanna withdraw?\n>");
        String amount = scanner.nextLine();
        PreparedStatement st = connection.prepareStatement("UPDATE customer SET total = ? WHERE register_id = ?");
        int withdrawl = total(emailConversion(email)) - Integer.parseInt(amount);
        st.setInt(1, withdrawl);
        st.setInt(2, emailConversion(email));
        st.executeUpdate();
    }

    public static void deposit(int amount, String email) throws SQLException {
        PreparedStatement st = connection.prepareStatement("UPDATE customer SET total = ? WHERE register_id = ?");
        int deposit = amount + total(emailConversion(email));
        st.setInt(1, deposit);
        st.setInt(2, emailConversion(email));
        st.executeUpdate();
    }

    public static void view(String email) throws SQLException {
        PreparedStatement st = connection.prepareStatement("SELECT account_num, total FROM customer WHERE register_id = ?");
        st.setInt(1, emailConversion(email));
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            System.out.println("Account Number: #" + rs.getString("account_num") + "\nTotal Amount: $" + rs.getString("total"));
        }
        rs.close();
        st.close();
    }
}
