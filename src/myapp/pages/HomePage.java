// HomePage.java
package myapp.pages;

import myapp.MainWindow;
import javax.swing.*;

import atm.User;
import atm.UserManager;

import java.awt.*;

public class HomePage extends JPanel {
	public HomePage(MainWindow main) {
		UserManager manager = new UserManager();
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(600, 40));
        topPanel.setBackground(Color.WHITE);
        JLabel titleLabel = new JLabel("ATM Simulation System");
        titleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        topPanel.add(titleLabel);
        
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setPreferredSize(new Dimension(600, 360));

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
            // 移植TestATM
            String user = username.getText();
            char[] passwordChars = password.getPassword();
            String pass = new String(passwordChars);

            if (manager.validate(user, pass)) {
            	User currentUser = manager.getUser(user);
                System.out.println("✅ 登入成功，歡迎 " + currentUser.getUsername());
                main.switchPage("menu");
    	        username.setText("");
    	        password.setText("");
            } else {
                System.out.println("❌ 帳號或密碼錯誤，請重新輸入");
                JOptionPane.showMessageDialog(null, "帳號或密碼錯誤，請重新輸入", "Error", JOptionPane.ERROR_MESSAGE);
            }
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