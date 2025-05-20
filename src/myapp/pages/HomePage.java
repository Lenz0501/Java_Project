// HomePage.java
package myapp.pages;

import myapp.MainWindow;
import javax.swing.*;

import atm.User;
import atm.UserManager;

import java.awt.*;

public class HomePage extends JPanel {
	public HomePage(MainWindow main, UserManager manager) {
		/*setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(600, 40));
        topPanel.setBackground(Color.WHITE);
        JLabel titleLabel = new JLabel("ATM Simulation System");
        titleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 35));
        topPanel.add(titleLabel);
        
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setPreferredSize(new Dimension(600, 360));

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));


        Font fieldFont = new Font("Dialog", Font.PLAIN, 18);
        Font labelFont = new Font("Segoe UI", Font.PLAIN, 20);
        Dimension fieldSize = new Dimension(200, 30);
        
        // username
        JPanel userRow = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel userLabel = new JLabel("Username:");
        userLabel.setFont(labelFont);
        JTextField username = new JTextField(15);
        username.setFont(fieldFont);
        username.setPreferredSize(fieldSize);
        userRow.add(userLabel);
        userRow.add(username);

        // password
        JPanel passRow = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel passLabel = new JLabel("Password:");
        passLabel.setFont(labelFont);
        JPasswordField password = new JPasswordField(15);
        password.setFont(fieldFont);
        password.setPreferredSize(fieldSize);
        passRow.add(passLabel);
        passRow.add(password);  //###
        
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
                main.getMenuPage().setUser(currentUser);
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
        add(bottomPanel);*/
		
		setLayout(new BorderLayout());
		
		// ===== TOP =====
		JPanel topPanel = new JPanel();
		JLabel titleLabel = new JLabel("ATM Simulation System");
		titleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 35));
		topPanel.add(titleLabel);
		add(topPanel, BorderLayout.NORTH);
		
		// ===== CENTER =====
		JPanel centerContainer = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(10, 10, 10, 10);

		Font fieldFont = new Font("Dialog", Font.PLAIN, 18);
		Font labelFont = new Font("Segoe UI", Font.PLAIN, 20);
		Dimension fieldSize = new Dimension(200, 30);

		// Username row
		JPanel userRow = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel userLabel = new JLabel("Username:");
		userLabel.setFont(labelFont);
		userLabel.setPreferredSize(new Dimension(150, 30));
		JTextField username = new JTextField(15);
		username.setFont(fieldFont);
		username.setPreferredSize(fieldSize);
		userRow.add(userLabel);
		userRow.add(username);
		gbc.gridy = 0;
		centerContainer.add(userRow, gbc);

		// Password row
		JPanel passRow = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel passLabel = new JLabel("Password:");
		passLabel.setFont(labelFont);
		passLabel.setPreferredSize(new Dimension(150, 30));
		JPasswordField password = new JPasswordField(15);
		password.setFont(fieldFont);
		password.setPreferredSize(fieldSize);
		passRow.add(passLabel);
		passRow.add(password);
		gbc.gridy = 1;
		centerContainer.add(passRow, gbc);

		// 空隙 (也可用 rigidArea)
		gbc.gridy = 2;
		centerContainer.add(Box.createVerticalStrut(20), gbc);

		// Button row
		JPanel buttonRow = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton submitButton = new JButton("Submit");
		submitButton.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		submitButton.setPreferredSize(new Dimension(120, 30));
		JButton resetButton = new JButton("Reset");
		resetButton.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		resetButton.setPreferredSize(new Dimension(120, 30));

		submitButton.addActionListener(e -> {
		    String user = username.getText();
		    char[] passwordChars = password.getPassword();
		    String pass = new String(passwordChars);

		    if (manager.validate(user, pass)) {
		        User currentUser = manager.getUserByUsername(user);
		        System.out.println("✅ 登入成功，歡迎 " + currentUser.getUsername());
		        main.getMenuPage().setUser(currentUser);
		        main.switchPage("menu");
		        username.setText("");
		        password.setText("");
		    } else {
		        System.out.println("❌ 帳號或密碼錯誤");
		        JOptionPane.showMessageDialog(null, "帳號或密碼錯誤，請重新輸入", "Error", JOptionPane.ERROR_MESSAGE);
		    }
		});
		resetButton.addActionListener(e -> {
		    username.setText("");
		    password.setText("");
		});
		buttonRow.add(submitButton);
		buttonRow.add(resetButton);
		gbc.gridy = 3;
		centerContainer.add(buttonRow, gbc);
		
		add(centerContainer,BorderLayout.CENTER);
    }
}