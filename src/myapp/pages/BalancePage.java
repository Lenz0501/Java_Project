// BalancePage.java
package myapp.pages;

import myapp.MainWindow;
import atm.User;
import atm.UserManager;

import javax.swing.*;
import java.awt.*;

public class BalancePage extends JPanel {
	private User currentUser;
	private JLabel balanceDisplayLabel;
	
	public BalancePage(MainWindow main, UserManager manager) {
		setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(600, 40));
        
        JPanel middlePanel = new JPanel();
        middlePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 130));
        middlePanel.setPreferredSize(new Dimension(600, 290));
        
        JPanel bottomPanel = new JPanel();
        //bottomPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.X_AXIS));
        bottomPanel.setPreferredSize(new Dimension(600, 40));
        //bottomPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 20));
		
		JLabel titleLabel = new JLabel("Balance");
		titleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 24));
		topPanel.add(titleLabel);

		balanceDisplayLabel = new JLabel();
		balanceDisplayLabel.setFont(new Font("Dialog", Font.PLAIN, 16));
		middlePanel.add(balanceDisplayLabel);
		
		JPanel leftBottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton backButton = new JButton("< Back to Menu");
		backButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		backButton.setPreferredSize(new Dimension(160, 30));
		backButton.addActionListener( e ->{
        	System.out.println("Back Button clicked.");
        	main.switchPage("menu");
        });
		leftBottomPanel.add(backButton);
		bottomPanel.add(leftBottomPanel);
		
		JPanel rightBottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton logoutButton = new JButton("Logout");
		logoutButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		logoutButton.setPreferredSize(new Dimension(160, 30));
		logoutButton.addActionListener( e ->{
        	System.out.println("Logout Button clicked.");
        	manager.saveToCSV();
        	main.switchPage("home");
        });
		rightBottomPanel.add(logoutButton);
		bottomPanel.add(rightBottomPanel);
		
		add(topPanel);
		add(middlePanel);
		add(bottomPanel);
	}
	
	public void setBalance(User user) {
        this.currentUser = user;
        balanceDisplayLabel.setText("Current Balance： $" + currentUser.getBalance());
    }
}