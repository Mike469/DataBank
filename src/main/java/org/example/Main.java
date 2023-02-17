package org.example;
import javax.swing.*;
import java.sql.*;
import java.util.Scanner;
import java.util.*;


public class Main {
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/databank", "postgres", "Sept0905");
    }
    static Scanner scanner = new Scanner(System.in);
    public static String[] userInfo() {

// -------------------Mike's Login Stuff----------------------------
        System.out.print("Enter your email address: \n>");
        String username = scanner.nextLine();
        System.out.print("Enter your password: \n>");
        String password = scanner.nextLine();
        return new String[]{username, password};
    }

    public static String[] registerInfo() {
        System.out.print("Enter your 'preferred' first name:\n>");
        String firstname = scanner.nextLine();
        System.out.print("Enter your last name: \n>");
        String lastname = scanner.nextLine();
        System.out.print("Enter your email address: \n>");
        String email = scanner.nextLine();
        System.out.print("Enter your password: \n>");
        String accountPassword = scanner.nextLine();
        return new String[]{firstname, lastname, email, accountPassword};
    }

    public static void main(String[] args) {

        String loggedIn = "Unsuccessful";
        System.out.println("------Welcome to Databank!------");
        while (loggedIn.equals("Unsuccessful")) {
            System.out.print("Do you want to Login or Register?\n>");
            String userInput = scanner.nextLine();
            userInput = userInput.toLowerCase();
            userInput = userInput.trim();
            switch (userInput) {
                case "login":
                    loggedIn = regLog.login(userInfo());
                    break;
                case "register":
                    regLog.registration(registerInfo());
                    break;
            }
        }
        System.out.println("Logged In Succesfully");
        System.out.println(loggedIn);
        // Welcome message should say welcome to the specific user
        System.out.println("------Welcome User------");
        //--------------------------------------------------------
        System.out.println("While logged in you can:");
        System.out.println("- DEPOSIT");
        System.out.println("- WITHDRAW");
        System.out.println("- BALANCE");
        System.out.println("- [VIEW] ACCOUNT HISTORY");
        System.out.println("- LOGOUT");
        String loggedOut = "No";
        while (loggedOut.equals("No")) {
            System.out.print("> ");
            String accessInput = scanner.nextLine();
            accessInput = accessInput.toLowerCase();
            accessInput = accessInput.trim();
            if (accessInput.equals("deposit")) {
                System.out.println("Deposit not yet available!");
            } else if (accessInput.equals("withdraw")) {
                System.out.println("Withdraw not yet available!");
            } else if (accessInput.equals("balance")) {
                System.out.println("Balance not yet available!");
            } else if (accessInput.equals("view")) {
                System.out.println("View not yet available!");
            } else if (accessInput.equals("logout")) {
                break;
            } else {
                System.out.println("INVALID!");
            }
        }
    }

}