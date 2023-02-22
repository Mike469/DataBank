package org.example;
import java.io.Console;

import javax.naming.Name;
import java.sql.*;
import java.util.Scanner;
import java.util.*;

import static org.example.CustomerFuncs.*;

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
        String loggedIn = "Unsuccessful";
        System.out.println("------Welcome to Databank!------");
        while (loggedIn.equals("Unsuccessful")) {
            System.out.print("Do you want to Login or Register?\n>");
            String userInput = scanner.nextLine();
            if (userInput == null || userInput.trim().isEmpty()) {
                System.out.println("Invalid Input.");
            }
            else if (userInput.trim().matches("(?i)login|register")) {
                switch (userInput.toLowerCase().trim()) {
                    case "login" -> loggedIn = regLog.login(userInfo());
                    case "register" -> regLog.registration(registerInfo());
                }
        }}
        if (loggedIn.equals("kevinadmin@gmail.com")) {
            while (true) {
                Scanner scan = new Scanner(System.in);

                System.out.println("What needs to be accessed?");
                System.out.println("1. User data");
                System.out.println("2. Fee processing");
                System.out.print("3. Logout \n> ");
                String userInput = scan.nextLine().toUpperCase();
                if (userInput.equals("1")) {
                    Scanner scan1 = new Scanner(System.in);
                    System.out.println("User data search format");
                    System.out.println("1. Find specific user");
                    System.out.print("2. Read all data \n> ");
                    String userInput1 = scan1.nextLine().toUpperCase();
                    if (userInput1.equals("1")) {
                        Scanner scan2 = new Scanner(System.in);
                        System.out.println("How do you want to find user?");
                        System.out.println("1. First name");
                        System.out.print("2. Last name \n> ");
                        String userInput2 = scan2.nextLine().toUpperCase();
                        if (userInput2.equals("1")) {
                            Scanner scan3 = new Scanner(System.in);
                            System.out.print("Enter name: ");
                            String userInput3 = scan3.nextLine();

                            NameSort.fname_search(userInput3);

                        } else if (userInput2.equals("2")) {
                            Scanner scan3 = new Scanner(System.in);
                            System.out.print("Enter name: ");
                            String userInput3 = scan3.nextLine();
                            NameSort.lname_search(userInput3);
                        } else {System.out.println("\u001B[31mNot a authorized command\u001B[0m");}
                    } else if (userInput1.equals("2")) {
                        Scanner scan2 = new Scanner(System.in);
                        System.out.println("Sort user data.");
                        System.out.println("1. alphabetically");
                        System.out.print("2. descending \n> ");
                        String userInput2 = scan2.nextLine().toUpperCase();
                        if (userInput2.equals("1")) {
                            NameSort.a_z();
                        } else if (userInput2.equals("2")) {
                            NameSort.z_a();
                        } else {System.out.println("\u001B[31mNot a authorized command\u001B[0m");}
                    }
                } else if (userInput.equals("2")) {
                    Scanner scan1 = new Scanner(System.in);
                    System.out.println("Select fee's to apply to customers.");
                    System.out.println("1. Garbage Collector Fee");
                    System.out.print("2. Comercial StackOverflow Fee \n> ");
                    String userInput1 = scan1.nextLine();
                    if (userInput1.equals("1")) {
                        tax.GarbageCollectorFee();
                    }
                    else if(userInput1.equals("2")){
                        tax.ComercialStackOverflowFee();
                    }
                    else {System.out.println("\u001B[31mNot a authorized command\u001B[0m");}
                }
                else if(userInput.equals("3")){break;}
                else {System.out.println("\u001B[31mNot a authorized command\u001B[0m");}
            }
        } else{
                System.out.println("LoggedIn Succesfully");
                System.out.println(loggedIn);
                System.out.println("------Welcome " + emailToName(loggedIn).substring(0,1).toUpperCase() + emailToName(loggedIn).substring(1).toLowerCase() +"!------");
                System.out.println("While logged in you can:");
                while (true) {
                    System.out.println("- DEPOSIT");
                    System.out.println("- WITHDRAW");
                    System.out.println("- BALANCE");
                    System.out.println("- [VIEW] ACCOUNT");
                    System.out.println("- LOGOUT");
                    System.out.print("> ");
                    String accessInput = scanner.nextLine();
                    if (accessInput.trim().equalsIgnoreCase("deposit")) {
                        System.out.print("How much money do you wanna deposit?\n>");
                        String amount = scanner.nextLine();
                        deposit(Integer.parseInt(amount), loggedIn);
                    } else if (accessInput.trim().equalsIgnoreCase("withdraw")) {
                        withdraw(loggedIn);
                    } else if (accessInput.trim().equalsIgnoreCase("balance")) {
                        System.out.println("Total Balance: $" + total(emailConversion(loggedIn)));
                    } else if (accessInput.trim().equalsIgnoreCase("view")) {
                        view(loggedIn);
                    } else if (accessInput.trim().equalsIgnoreCase("logout")) {
                        break;
                    } else {
                        System.out.println("INVALID!");
                    }
                }
            }
        }
    }

