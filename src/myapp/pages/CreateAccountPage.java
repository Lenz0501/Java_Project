// CreateAccountPage.java
package myapp.pages;

import javax.swing.*;
import java.awt.*;

import myapp.MainWindow;
import atm.UserManager;
import atm.User;

public class CreateAccountPage extends JPanel {
	public CreateAccountPage(MainWindow main, UserManager manager) {
		/*
		setLayout(new GridLayout(5, 1, 10, 10));
		setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
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
        
        // initial amount
        JPanel row4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel label4 = new JLabel("Initial Amount:");
        JTextField balanceField = new JTextField();
        balanceField.setPreferredSize(fieldSize);
        row4.add(label4);
        row4.add(balanceField);
        
        label1.setPreferredSize(new Dimension(150, 30));
        label2.setPreferredSize(new Dimension(150, 30));
        label3.setPreferredSize(new Dimension(150, 30));
        label4.setPreferredSize(new Dimension(150, 30));
        
        JPanel row5 = new JPanel();
        row5.setLayout(new BoxLayout(row5, BoxLayout.X_AXIS));
        row5.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 20));
        
        JPanel leftBottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton backButton = new JButton("< Back to Menu");
		backButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		backButton.setPreferredSize(new Dimension(160, 30));
		backButton.addActionListener( e ->{
        	System.out.println("Back Button clicked.");
        	main.switchPage("menu");
        });
		leftBottomPanel.add(backButton);
		row5.add(leftBottomPanel);
        
        //JPanel row5 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JPanel rightBottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton createButton = new JButton("Create Account");
		createButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        createButton.addActionListener( e ->{
        	String user = usernameField.getText();
            char[] passwordChars = passwordField.getPassword();
            String pass = new String(passwordChars);
            char[] cpasswordChars = confirmPasswordField.getPassword();
            String cpass = new String(cpasswordChars);
            String initialAmount = balanceField.getText().trim();
            int amount = initialAmount.isEmpty() ? 0:Integer.parseInt(initialAmount);
        	
            if (user.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter username.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (pass.isEmpty() || cpass.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter password.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (!pass.equals(cpass)) {
                JOptionPane.showMessageDialog(null, "Passwords do not match. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                System.out.println("Successfully Created Account.");
                // 新增帳戶並拿回 newUser 物件
                User newUser = manager.addUser(user, pass, amount);

                // 把新帳戶ID顯示出來
                System.out.println("✅ 帳戶新增成功！");
                System.out.println("👉 請記住您的帳號ID：" + newUser.getId());
                
                usernameField.setText("");
                passwordField.setText("");
                confirmPasswordField.setText("");
                balanceField.setText("");
                
                main.switchPage("home");
            }
        });
        rightBottomPanel.add(createButton);
		row5.add(rightBottomPanel);

        add(row1);
        add(row2);
        add(row3);
        add(row4);
        add(row5);
        */
		setLayout(new BorderLayout());
		
		// ===== TOP =====
		JPanel topPanel = new JPanel();
		JLabel titleLabel = new JLabel("Create Account");
		titleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 35));
		topPanel.add(titleLabel);
		add(topPanel, BorderLayout.NORTH);
		
		// ===== CENTER =====
		JPanel middlePanel = new JPanel(new GridBagLayout());
		middlePanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
		GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        
        JLabel label1 = new JLabel("Username :");
        JTextField usernameField = new JTextField();
        JLabel label2 = new JLabel("Password :");
        JPasswordField passwordField = new JPasswordField();
        JLabel label3 = new JLabel("Confirm Password :");
        JPasswordField confirmPasswordField = new JPasswordField();
        JLabel label4 = new JLabel("Initial Amount :");
        JTextField balanceField = new JTextField();
        JLabel label5 = new JLabel("Admin Identity :");
        JCheckBox  adminCheck  = new JCheckBox();
        
        // 通用樣式
        Font labelFont = new Font("Segoe UI", Font.PLAIN, 20);
        label1.setFont(labelFont);
        label2.setFont(labelFont);
        label3.setFont(labelFont);
        label4.setFont(labelFont);
        label5.setFont(labelFont);
        Font fieldFont = new Font("Dialog", Font.PLAIN, 18);
        usernameField.setFont(fieldFont);
        passwordField.setFont(fieldFont);
        confirmPasswordField.setFont(fieldFont);
        balanceField.setFont(fieldFont);
        
        // 輸入框大小
        Dimension fieldSize = new Dimension(200, 30);
        usernameField.setPreferredSize(fieldSize);
        passwordField.setPreferredSize(fieldSize);
        confirmPasswordField.setPreferredSize(fieldSize);
        balanceField.setPreferredSize(fieldSize);
        
        // 欄1：標籤，欄2：輸入框
        gbc.gridx = 0; gbc.gridy = 0;
        middlePanel.add(label1, gbc);
        gbc.gridx = 1;
        middlePanel.add(usernameField, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        middlePanel.add(label2, gbc);
        gbc.gridx = 1;
        middlePanel.add(passwordField, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        middlePanel.add(label3, gbc);
        gbc.gridx = 1;
        middlePanel.add(confirmPasswordField, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        middlePanel.add(label4, gbc);
        gbc.gridx = 1;
        middlePanel.add(balanceField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 4;
        middlePanel.add(label5, gbc);
        gbc.gridx = 1;
        middlePanel.add(adminCheck, gbc);
        
        add(middlePanel, BorderLayout.CENTER);

		// ===== BOTTOM =====
		JPanel bottomPanel = new JPanel(new BorderLayout());
		bottomPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

		// 返回按鈕
		JButton backButton = new JButton("< Back to Menu");
		backButton.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		backButton.setPreferredSize(new Dimension(180, 40));
		bottomPanel.add(backButton, BorderLayout.WEST);

		// 開戶按鈕
        JButton createButton = new JButton("Create Account");
		createButton.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		createButton.setPreferredSize(new Dimension(180, 40));
		bottomPanel.add(createButton, BorderLayout.EAST);
		
		// 按鈕程序
		backButton.addActionListener( e ->{
        	System.out.println("Back Button clicked.");
        	main.switchPage("menu");
        });
		createButton.addActionListener( e ->{
        	String user = usernameField.getText();
            char[] passwordChars = passwordField.getPassword();
            String pass = new String(passwordChars);
            char[] cpasswordChars = confirmPasswordField.getPassword();
            String cpass = new String(cpasswordChars);
            String initialAmount = balanceField.getText().trim();
            int amount = initialAmount.isEmpty() ? 0:Integer.parseInt(initialAmount);
        	
            if (user.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter username.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (pass.isEmpty() || cpass.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter password.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (!pass.equals(cpass)) {
                JOptionPane.showMessageDialog(null, "Passwords do not match. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                System.out.println("Successfully Created Account.");
                
                String roleString = adminCheck.isSelected() ? "admin" : "general";
                manager.addUser(user, pass, amount, roleString);
                
                usernameField.setText("");
                passwordField.setText("");
                confirmPasswordField.setText("");
                balanceField.setText("");
                
                main.switchPage("home");
            }
        });
		add(bottomPanel, BorderLayout.SOUTH);
	}
}