package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static String[] userInfo() {
        System.out.print("Enter your email address: \n>");
        String username = scanner.nextLine();
        System.out.print("Enter your password: \n>");
        String password = scanner.nextLine();
        return new String[]{username, password};
    }
    public static void main(String[] args) {
        String loggedIn = "Unsuccessful";
        System.out.println("------Welcome to Databank!------");
        while (loggedIn.equals("Unsuccessful")) {
            System.out.print("Do you want to Login or Register?\n>");
            String userInput = scanner.nextLine();
            switch (userInput) {
                case "Login":
                    loggedIn = regLog.login(userInfo());
                    break;
                case "Register":
                    regLog.registration(userInfo());
                    break;
            }
        }
        System.out.println(loggedIn);
    }
}