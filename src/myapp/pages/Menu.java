//Menu.java
package myapp.pages;

import myapp.MainWindow;
import javax.swing.*;
import java.awt.*;

import atm.UserManager;
import atm.User;

public class Menu extends JPanel {
	private User currentUser;
	private JLabel userLabel;

	private JPanel centerPanel;
	private MainWindow main;
    private UserManager manager;
	
	public Menu(MainWindow main, UserManager manager) {
		setLayout(new BorderLayout());
		this.main = main;
        this.manager = manager;
		
		// ===== TOP =====
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.setPreferredSize(new Dimension(600, 50));
        // topPanel.setBackground(Color.WHITE);
        userLabel = new JLabel(" Welcome (Guest)");
        userLabel.setFont(new Font("Segoe UI", Font.PLAIN, 26));
        topPanel.add(userLabel);
        add(topPanel, BorderLayout.NORTH);
        
        // ===== CENTER =====
        centerPanel = new JPanel(new GridLayout(3, 2, 20, 20 ));
        centerPanel.setPreferredSize(new Dimension(600, 360));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(10,30,30,30));
        add(centerPanel, BorderLayout.CENTER);

        add(centerPanel, BorderLayout.CENTER);
	}
	
	public void setUser(User user) {
        this.currentUser = user;
        //System.out.println("👤 Current user: " + user.getUsername());
        userLabel.setText(" Welcome, " + currentUser.getUsername());
        // 你也可以更新畫面上的 Label、資訊之類的
        
        centerPanel.removeAll();
        
        Font buttonFont = new Font("Segoe UI", Font.PLAIN, 24);
        JButton balanceButton = new JButton("Balance");
        balanceButton.setFont(buttonFont);
        balanceButton.addActionListener( e ->{
        	System.out.println("Balance Button clicked.");
        	main.getBalancePage().setBalance(currentUser);
        	main.switchPage("balance");
        });
        centerPanel.add(balanceButton);
        
        JButton depositButton = new JButton("Deposit");
        depositButton.setFont(buttonFont);
        depositButton.addActionListener( e ->{
        	System.out.println("Deposit Button clicked.");
        	main.getDepositPage().setDeposit(currentUser);
        	main.switchPage("deposit");
        });
        centerPanel.add(depositButton);
        
        JButton withdrawalButton = new JButton("Withdrawal");
        withdrawalButton.setFont(buttonFont);
        withdrawalButton.addActionListener( e ->{
        	System.out.println("Withdrawal Button clicked.");
        	main.getWithdrawPage().setWithdraw(currentUser);
        	main.switchPage("withdraw");
        });
        centerPanel.add(withdrawalButton);
        
        boolean admin = "admin".equalsIgnoreCase(currentUser.getRole());
        if(admin) {
	        JButton transactionButton = new JButton("Recent Transaction");
	        transactionButton.setFont(buttonFont);
	        transactionButton.addActionListener( e ->{
	        	System.out.println("Recent Transaction Button clicked.");
	        	main.getTransactionPage().refreshTable();
	        	main.switchPage("transaction");
	        });
	        centerPanel.add(transactionButton);
        
        	JButton createAccountButton = new JButton("Create Account");
        	createAccountButton.setFont(buttonFont);
        	createAccountButton.addActionListener( e ->{
            	System.out.println("Create Account Button clicked.");
            	main.switchPage("create");
            });
        	centerPanel.add(createAccountButton);
        }
        
        JButton logoutButton = new JButton("Logout");
        logoutButton.setFont(buttonFont);
        logoutButton.addActionListener( e ->{
        	System.out.println("Logout Button clicked.");
        	manager.saveToCSV();
        	main.switchPage("home");
        });
        centerPanel.add(logoutButton);
        
        int emptyBoxNum=2;
        if(admin) emptyBoxNum-=2;
        for (int i = 0; i < emptyBoxNum; i++) {
        	centerPanel.add(new JLabel(""));
        }
        
        centerPanel.revalidate();
        centerPanel.repaint();
    }
}