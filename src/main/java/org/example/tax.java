package org.example;
import java.sql.*;
import java.sql.Connection;

public class tax {
    static float GarbageCollectorFee = 0.99f;
    static float ComercialStackOverflowFee = 0.85f;




    public static void GarbageCollectorFee() {
        Connection connection = null;
        Statement statement = null;
        // bottom is copypaste
        ConnectDB obj_connection = new ConnectDB();
        connection = obj_connection.get_connection();
        ResultSet rs = null;
        try {
            String query = "SELECT * FROM customer";
            statement = connection.createStatement();
            rs = statement.executeQuery(query);

            while(rs.next()){
                // need the id to change specific balance
                int idAccount = (rs.getInt(1));
                // prints the account number for validation

                // need the current total for math
                int currentTotal = (rs.getInt(3));
                // print the current total for validation

                // does the float math for new balance
                float newBalance = (currentTotal * GarbageCollectorFee);

                // updates the tables with bottom command
                String commandUpdateTax = "UPDATE customer SET total = '" + newBalance + "' WHERE id = '"+ idAccount + "'";
                // need a statement to run commandUpdateTax
                statement = connection.createStatement();
                // runs commandUpdateTax
                statement.executeUpdate(commandUpdateTax);
                // prints if worked or nah



            }
            System.out.println("Garbage Collector Fee has been applied.");

        } catch (Exception e) {System.out.println("Broken");}
    }
    public static void ComercialStackOverflowFee () {
        Connection connection = null;
        Statement statement = null;
        // bottom is copypaste
        ConnectDB obj_connection = new ConnectDB();
        connection = obj_connection.get_connection();
        ResultSet rs = null;
        try {
            String query = "SELECT * FROM customer";
            statement = connection.createStatement();
            rs = statement.executeQuery(query);

            while(rs.next()){
                // need the id to change specific balance
                int idAccount = (rs.getInt(1));
                // prints the account number for validation

                // need the current total for math
                int currentTotal = (rs.getInt(3));
                // print the current total for validation

                // does the float math for new balance
                float newBalance = (currentTotal * ComercialStackOverflowFee);

                // updates the tables with bottom command
                String commandUpdateTax = "UPDATE customer SET total = '" + newBalance + "' WHERE id = '"+ idAccount + "'";
                // need a statement to run commandUpdateTax
                statement = connection.createStatement();
                // runs commandUpdateTax
                statement.executeUpdate(commandUpdateTax);
                // prints if worked or nah



            }
            System.out.println("Comercial StackOverflow Fee has been applied.");

        } catch (Exception e) {System.out.println("Broken");}
    }

}
