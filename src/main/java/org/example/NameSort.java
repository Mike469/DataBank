package org.example;

import java.sql.*;

import java.sql.Connection;

public class NameSort {
    public static void lname_search(String name){
        System.out.println("name search working");
        Connection connection = null; // 1
        Statement statement = null; // 2
        // bottom is copypaste
        ConnectDB obj_connection = new ConnectDB(); // 3
        connection = obj_connection.get_connection(); // 4
        ResultSet rs = null; // 5


        try {
            // below sql code
            String order_alph = "SELECT r.first_name, r.last_name, c.account_num, c.total " +
                    "FROM register r " +
                    "INNER JOIN customer c ON r.id = c.register_id " +
                    "WHERE r.last_name = '" + name  + "' " +
                    "ORDER BY r.last_name, r.first_name";
// actually to sql
            statement = connection.createStatement();
// we will grab below "rs"
            rs = statement.executeQuery(order_alph);

// while rs(rs is all customers now looping) is looping
            while(rs.next()){
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                int accountNum = rs.getInt("account_num");
                float total = rs.getFloat("total");

                System.out.println(lastName +" | " + firstName + " | " + accountNum + " | $" + total);



            }


        } catch (Exception e) {System.out.println("Broken");}
    }
    public static void fname_search(String name){
        System.out.println("name search working");
        Connection connection = null; // 1
        Statement statement = null; // 2
        // bottom is copypaste
        ConnectDB obj_connection = new ConnectDB(); // 3
        connection = obj_connection.get_connection(); // 4
        ResultSet rs = null; // 5


        try {
            // below sql code
            String order_alph = "SELECT r.first_name, r.last_name, c.account_num, c.total " +
                    "FROM register r " +
                    "INNER JOIN customer c ON r.id = c.register_id " +
                    "WHERE r.first_name = '" + name  + "' " +
                    "ORDER BY r.last_name, r.first_name";
// actually to sql
            statement = connection.createStatement();
// we will grab below "rs"
            rs = statement.executeQuery(order_alph);

// while rs(rs is all customers now looping) is looping
            while(rs.next()){
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                int accountNum = rs.getInt("account_num");
                float total = rs.getFloat("total");

                System.out.println(lastName +" | " + firstName + " | " + accountNum + " | $" + total);



            }


        } catch (Exception e) {System.out.println("Broken");}
    }

    public static void a_z() {
        System.out.println("a_z working");
        Connection connection = null; // 1
        Statement statement = null; // 2
        // bottom is copypaste
        ConnectDB obj_connection = new ConnectDB(); // 3
        connection = obj_connection.get_connection(); // 4
        ResultSet rs = null; // 5


        try {
            // below sql code
            String order_alph = "SELECT r.first_name, r.last_name, c.account_num, c.total " +
                    "FROM register r " +
                    "INNER JOIN customer c ON r.id = c.register_id " +
                    "ORDER BY r.last_name, r.first_name";
// actually to sql
            statement = connection.createStatement();
// we will grab below "rs"
            rs = statement.executeQuery(order_alph);

// while rs(rs is all customers now looping) is looping
            while(rs.next()){
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                int accountNum = rs.getInt("account_num");
                float total = rs.getFloat("total");

                System.out.println(lastName +" | " + firstName + " | " + accountNum + " | $" + total);



            }


        } catch (Exception e) {System.out.println("Broken");}
    }
    public static void z_a() {
        Connection connection = null;
        Statement statement = null;
        // bottom is copypaste
        ConnectDB obj_connection = new ConnectDB();
        connection = obj_connection.get_connection();
        ResultSet rs = null;
        try {
            // below sql code
            String order_bravo = "SELECT r.first_name, r.last_name, c.account_num, c.total " +
                    "FROM register r " +
                    "INNER JOIN customer c ON r.id = c.register_id " +
                    "ORDER BY r.last_name DESC ;";
            // actually to sql
            statement = connection.createStatement();
            rs = statement.executeQuery(order_bravo);


            // while rs is looping
            while(rs.next()){
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                int accountNum = rs.getInt("account_num");
                float total = rs.getFloat("total");

                System.out.println(lastName +" | " + firstName + " | " + accountNum + " | $" + total);

            }


        } catch (Exception e) {System.out.println("Broken");}
    }
}
