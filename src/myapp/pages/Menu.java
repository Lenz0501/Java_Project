//SettingsPage.java
package myapp.pages;

import myapp.MainWindow;
import javax.swing.*;
import java.awt.*;

public class Menu extends JPanel {
	public Menu(MainWindow main) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(600, 40));
        topPanel.setBackground(Color.WHITE);
        JLabel titleLabel = new JLabel("ATM Simulation System");
        titleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        topPanel.add(titleLabel);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setPreferredSize(new Dimension(600, 360));
        bottomPanel.setLayout(new GridLayout(4, 2, 20, 20 ));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(10,20,20,20));
        bottomPanel.setBackground(Color.WHITE);

        JButton balanceButton = new JButton("Balance");
        balanceButton.addActionListener( e ->{
        	System.out.println("Balance Button clicked.");
        });
        JButton depositButton = new JButton("Deposit");
        depositButton.addActionListener( e ->{
        	System.out.println("Deposit Button clicked.");
        });
        JButton withdrawalButton = new JButton("Withdrawal");
        withdrawalButton.addActionListener( e ->{
        	System.out.println("Withdrawal Button clicked.");
        });
        JButton transactionButton = new JButton("Recent Transaction");
        transactionButton.addActionListener( e ->{
        	System.out.println("Recent Transaction Button clicked.");
        });
        JButton logoutButton = new JButton("Logout");
        logoutButton.addActionListener( e ->{
        	System.out.println("Logout Button clicked.");
        	main.switchPage("home");
        });
        bottomPanel.add(balanceButton);
        bottomPanel.add(depositButton);
        bottomPanel.add(withdrawalButton);
        bottomPanel.add(transactionButton);
        bottomPanel.add(logoutButton);
        
        for (int i = 0; i < 3; i++) {
            bottomPanel.add(new JLabel(""));
        }

        add(topPanel);
        add(bottomPanel);
	}
}