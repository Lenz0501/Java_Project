// HomePage.java
package myapp.pages;

import myapp.MainWindow;
import javax.swing.*;
import java.awt.*;

public class HomePage extends JPanel {
	public HomePage(MainWindow main) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(600, 40));
        topPanel.setBackground(Color.WHITE);
        JLabel titleLabel = new JLabel("ATM Simulation System");
        titleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        topPanel.add(titleLabel);
        
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setPreferredSize(new Dimension(600, 360));
        /*JButton toMenu = new JButton("To menu");
        toMenu.addActionListener(e -> main.switchPage("menu"));
        bottomPanel.add(toMenu);*/

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // username
        JPanel userRow = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel userLabel = new JLabel("Username:");
        JTextField username = new JTextField(15);
        userRow.add(userLabel);
        userRow.add(username);

        // password
        JPanel passRow = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel passLabel = new JLabel("Password:");
        JPasswordField password = new JPasswordField(15);
        passRow.add(passLabel);
        passRow.add(password);

        // button row
        JPanel buttonRow = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> {
        	main.switchPage("menu");
            String user = username.getText();
            char[] passwordChars = password.getPassword();
            String pass = new String(passwordChars);
            System.out.println("Username: " + user);
            System.out.println("Password: " + pass);
        	username.setText("");
            password.setText("");
        });
        JButton resetButton = new JButton("Reset");
        buttonRow.add(submitButton);
        resetButton.addActionListener(e -> {
            username.setText("");
            password.setText("");
        });
        buttonRow.add(resetButton);

        centerPanel.add(userRow);
        centerPanel.add(Box.createVerticalStrut(10));
        centerPanel.add(passRow);
        centerPanel.add(Box.createVerticalStrut(20));
        centerPanel.add(buttonRow);

        bottomPanel.add(new JScrollPane(centerPanel), BorderLayout.CENTER);
        
        bottomPanel.add(Box.createHorizontalStrut(50), BorderLayout.WEST);
        bottomPanel.add(Box.createHorizontalStrut(50), BorderLayout.EAST);
        bottomPanel.add(Box.createVerticalStrut(50), BorderLayout.NORTH);
        bottomPanel.add(Box.createVerticalStrut(50), BorderLayout.SOUTH);
        
        add(topPanel);
        add(bottomPanel);
    }
}