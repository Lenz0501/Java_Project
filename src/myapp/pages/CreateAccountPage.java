// CreateAccountPage.java
package myapp.pages;

import javax.swing.*;
import java.awt.*;

import myapp.MainWindow;

public class CreateAccountPage extends JPanel {
	public CreateAccountPage(MainWindow main) {
		
		setLayout(new GridLayout(5, 1, 10, 10));
        
        // 輸入框大小
        Dimension fieldSize = new Dimension(200, 30);
        
        // username
        JPanel row1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel label1 = new JLabel("Username:");
        JTextField usernameField = new JTextField();
        usernameField.setPreferredSize(fieldSize);
        row1.add(label1);
        row1.add(usernameField);
        
        // password
        JPanel row2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel label2 = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();
        passwordField.setPreferredSize(fieldSize);
        row2.add(label2);
        row2.add(passwordField);
        
        // confirm password
        JPanel row3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel label3 = new JLabel("Confirm Password:");
        JPasswordField confirmPasswordField = new JPasswordField();
        confirmPasswordField.setPreferredSize(fieldSize);
        row3.add(label3);
        row3.add(confirmPasswordField);
        
        label1.setPreferredSize(new Dimension(150, 30));
        label2.setPreferredSize(new Dimension(150, 30));
        label3.setPreferredSize(new Dimension(150, 30));
        
        JPanel row4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton createButton = new JButton("Create Account");
        createButton.addActionListener( e ->{
        	String user = usernameField.getText();
            char[] passwordChars = passwordField.getPassword();
            String pass = new String(passwordChars);
            char[] cpasswordChars = confirmPasswordField.getPassword();
            String cpass = new String(passwordChars);
            System.out.println("Username: " + user);
            System.out.println("Password: " + pass);
            System.out.println("Password: " + cpass);
        	
            if(pass.compareTo(cpass)==0) {
            	System.out.println("Successly Create Account.");
            	main.switchPage("home");
            }
        });
        row4.add(createButton);

        add(row1);
        add(row2);
        add(row3);
        add(row4);
	}
}