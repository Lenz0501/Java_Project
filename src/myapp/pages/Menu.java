//Menu.java
package myapp.pages;

import myapp.MainWindow;
import javax.swing.*;

import atm.UserManager;
import atm.User;

import java.awt.*;

public class Menu extends JPanel {
	private User currentUser;
	private JLabel userLabel;
	
	public Menu(MainWindow main, UserManager manager) {
		boolean admin = true;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(600, 40));
        topPanel.setBackground(Color.WHITE);
        JLabel titleLabel = new JLabel("ATM Simulation System");
        userLabel = new JLabel("Welcome (Guest)");
        titleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        topPanel.add(titleLabel);
        topPanel.add(userLabel);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setPreferredSize(new Dimension(600, 360));
        bottomPanel.setLayout(new GridLayout(4, 2, 20, 20 ));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(10,20,20,20));
        bottomPanel.setBackground(Color.WHITE);

        JButton balanceButton = new JButton("Balance");
        balanceButton.addActionListener( e ->{
        	System.out.println("Balance Button clicked.");
        });
        bottomPanel.add(balanceButton);
        
        JButton depositButton = new JButton("Deposit");
        depositButton.addActionListener( e ->{
        	System.out.println("Deposit Button clicked.");
        });
        bottomPanel.add(depositButton);
        
        JButton withdrawalButton = new JButton("Withdrawal");
        withdrawalButton.addActionListener( e ->{
        	System.out.println("Withdrawal Button clicked.");
        });
        bottomPanel.add(withdrawalButton);
        
        JButton transactionButton = new JButton("Recent Transaction");
        transactionButton.addActionListener( e ->{
        	System.out.println("Recent Transaction Button clicked.");
        });
        bottomPanel.add(transactionButton);
        
        if(admin) {
        	JButton createAccountButton = new JButton("Create Account");
        	createAccountButton.addActionListener( e ->{
            	System.out.println("Create Account Button clicked.");
            	main.switchPage("create");
            });
        	bottomPanel.add(createAccountButton);
        }
        
        JButton logoutButton = new JButton("Logout");
        logoutButton.addActionListener( e ->{
        	System.out.println("Logout Button clicked.");
        	main.switchPage("home");
        });
        bottomPanel.add(logoutButton);
        
        int emptyBoxNum=2;
        if(admin) emptyBoxNum--;
        for (int i = 0; i < emptyBoxNum; i++) {
            bottomPanel.add(new JLabel(""));
        }

        add(topPanel);
        add(bottomPanel);
	}
	
	public void setUser(User user) {
        this.currentUser = user;
        System.out.println("👤 Current user: " + user.getUsername());
        userLabel.setText("Welcome, " + currentUser.getUsername());
        // 你也可以更新畫面上的 Label、資訊之類的
    }
}