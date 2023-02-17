package org.example;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Scanner;
import java.util.*;


public class GUI implements ActionListener {
    private static JLabel userLabel;
    private static JTextField userText;
    private static JLabel passwordLabel;
    private static JPasswordField passwordText;
    private static JButton button;
    private static JLabel success;


    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/databank", "postgres", "Sept0905");
    }
    static Scanner scanner = new Scanner(System.in);
    public static String[] userInfo() {
        JPanel panel = new JPanel();
        JFrame frame =  new JFrame();
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        panel.setLayout(null);

        userLabel = new JLabel("Email:");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        passwordText = new JPasswordField();
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);

        button = new JButton("Login");
        button.setBounds(10, 80, 80, 25);
        button.addActionListener(new GUI());
        panel.add(button);

        success = new JLabel("");
        success.setBounds(10, 110, 300, 25);
        panel.add(success);

        frame.setVisible(true);

        System.out.print("Enter your email address: \n>");
        String username = scanner.nextLine();
        System.out.print("Enter your password: \n>");
        String password = scanner.nextLine();
        return new String[]{username, password};
    }

    public static String[] registerInfo() {
        JPanel panel = new JPanel();
        JFrame frame =  new JFrame();
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        panel.setLayout(null);

        userLabel = new JLabel("Email:");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        passwordText = new JPasswordField();
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);

        button = new JButton("Login");
        button.setBounds(10, 80, 80, 25);
        button.addActionListener(new GUI());
        panel.add(button);

        success = new JLabel("");
        success.setBounds(10, 110, 300, 25);
        panel.add(success);

        frame.setVisible(true);
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
        JPanel panel = new JPanel();
        JFrame frame =  new JFrame();
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        panel.setLayout(null);

        userLabel = new JLabel("Email:");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        passwordText = new JPasswordField();
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);

        button = new JButton("Login");
        button.setBounds(10, 80, 80, 25);
        button.addActionListener(new GUI());
        panel.add(button);

        success = new JLabel("");
        success.setBounds(10, 110, 300, 25);
        panel.add(success);

        frame.setVisible(true);

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

    @Override
    public void actionPerformed(ActionEvent e) {
        String user = userText.getText();
        String password = passwordText.getText();
        System.out.println(user + ", " + password);

        if(user.equals("Alex") && password.equals("1231")) {
            success.setText("Login successful!");
        } else {
            success.setText("Unsuccessful!");
        }
    }



}
