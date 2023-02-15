package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        boolean loggedIn = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("------Welcome to Databank!------");
        while (!loggedIn) {
            System.out.print("Do you want to Login or Register?\n>");
            String userInput = scanner.nextLine();
            System.out.println(userInput);
            switch (userInput) {
                case "Login":
                    System.out.println("Joe");
                case "Register":
                    System.out.print("Enter your email address: \n>");
                    String username = scanner.nextLine();
                    System.out.print("Enter your password: \n>");
                    String password = scanner.next();
                    loggedIn = regLog.registration(username, password);
            }
        }
    }
}