package org.example;

import java.sql.*;
import java.util.Scanner;
import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static String[] userInfo() {
        System.out.print("Enter your email address: \n>");
        String username = scanner.nextLine();
        System.out.print("Enter your password: \n>");
        String password = scanner.nextLine();
        return new String[]{username, password};
    }

    public static String[] registerInfo() {
        System.out.print("Enter your 'preferred' first name: \n>");
        String firstname = scanner.nextLine();
        System.out.print("Enter your last name: \n>");
        String lastname = scanner.nextLine();
        System.out.print("Enter your email address: \n>");
        String email = scanner.nextLine();
        System.out.print("Enter your password: \n>");
        String accountPassword = scanner.nextLine();
        return new String[]{firstname, lastname, email, accountPassword};
    }

    public static void main(String[] args) throws SQLException {
        NameSort.fname_search("Mike");
        String loggedIn = "Unsuccessful";
        System.out.println("------Welcome to Databank!------");
        while (loggedIn.equals("Unsuccessful")) {
            System.out.print("Do you want to Login or Register?\n>");
            String userInput = scanner.nextLine();
            switch (userInput) {
                case "Login":
                    loggedIn = regLog.login(userInfo());
                    break;
                case "login":
                    loggedIn = regLog.login(userInfo());
                    break;
                case " Login":
                    loggedIn = regLog.login(userInfo());
                    break;
                case " login":
                    loggedIn = regLog.login(userInfo());
                    break;
        //------------------------ Register --------------------------------
                case "Register":
                    regLog.registration(registerInfo());
                    break;
                case "register":
                    loggedIn = regLog.login(registerInfo());
                    break;
                case " Register":
                    loggedIn = regLog.login(registerInfo());
                    break;
                case " register":
                    loggedIn = regLog.login(registerInfo());
                    break;
            }
        }
        System.out.println("LoggedIn Succesfully");
        System.out.println(loggedIn);
        System.out.println("------Welcome to Databank!------");
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
            if (accessInput.equals("Deposit") || accessInput.equals("DEPOSIT") || accessInput.equals("deposit")) {
                System.out.println("'Deposit' not yet available!");
            } else if (accessInput.equals("Withdraw") || accessInput.equals("WITHDRAW") || accessInput.equals("withdraw")) {
                System.out.println("'Withdraw' not yet available!");
            } else if (accessInput.equals("Balance") || accessInput.equals("BALANCE") || accessInput.equals("balance")) {
                System.out.println("'Balance' not yet available!");
            } else if (accessInput.equals("View") || accessInput.equals("VIEW") || accessInput.equals("view")) {
                System.out.println("'View' not yet available!");
            } else if (accessInput.equals("Log out") || accessInput.equals("Logout") || accessInput.equals("log out") || accessInput.equals("logout")) {
                break;
            } else {
                System.out.println("INVALID!");
            }
        }

    }
}