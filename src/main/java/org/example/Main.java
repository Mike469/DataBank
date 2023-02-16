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
        System.out.print("Enter your last name: \n>");
        String accountPassword = scanner.nextLine();
        return new String[]{firstname, lastname, email, accountPassword};
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
                    regLog.registration(registerInfo());
                    break;
            }
        }
        System.out.println("LoggedIn Succesfully");
        System.out.println(loggedIn);
//        System.out.println("------Welcome to Databank!------");
//        System.out.println("While logged in you can:");
//        System.out.println("DEPOSIT");
//        System.out.println("");
//        System.out.println("");

    }
}