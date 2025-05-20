// WithdrawaPage.java
package myapp.pages;

import myapp.MainWindow;
import atm.User;
import atm.UserManager;

import javax.swing.*;
import java.awt.*;

public class WithdrawPage extends JPanel {
	private User currentUser;
	
	public WithdrawPage(MainWindow main, UserManager manager) {
		/*setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(600, 40));
        
        JPanel middlePanel = new JPanel();
        middlePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 130));
        middlePanel.setPreferredSize(new Dimension(600, 275));
        
        JPanel bottomPanel = new JPanel();
        //bottomPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.X_AXIS));
        bottomPanel.setPreferredSize(new Dimension(600, 40));
        //bottomPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 20));
		
		JLabel titleLabel = new JLabel("Withdrawl");
		titleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 24));
		topPanel.add(titleLabel);

		JLabel balanceDisplayLabel = new JLabel("Enter withdraw amount :     ");
		balanceDisplayLabel.setFont(new Font("Dialog", Font.PLAIN, 16));
		JTextField amountField = new JTextField();
		amountField.setPreferredSize(new Dimension(200, 30));
		JButton depositBurtton = new JButton("Submit");
		depositBurtton.addActionListener( e ->{
        	int amount = Integer.parseInt(amountField.getText());
        	if (currentUser.withdraw(amount)) {
            	String displayString = "Balance: "+Integer.toString(currentUser.getBalance()+amount)+" --> "+currentUser.getBalance()+" (-"+amount+")";
        		JOptionPane.showMessageDialog(null, displayString, "Success", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("✅ 提款成功，目前餘額：" + currentUser.getBalance() + " 元");
            	manager.saveTransactionToCSV(currentUser ,"-"+amount);
                main.getBalancePage().setBalance(currentUser);
            	main.switchPage("balance");
            	amountField.setText("");
            } else {
            	JOptionPane.showMessageDialog(null, "Insufficient balance, withdrawal failed", "Failed", JOptionPane.WARNING_MESSAGE);
                System.out.println("❌ 餘額不足，提款失敗");
            }
        	System.out.println("Deposit Button clicked. \nAmount: "+amount);
        });
		middlePanel.add(balanceDisplayLabel);
		middlePanel.add(amountField);
		middlePanel.add(depositBurtton);
		
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
        	main.switchPage("home");
        });
		rightBottomPanel.add(logoutButton);
		bottomPanel.add(rightBottomPanel);
		
		add(topPanel);
		add(middlePanel);
		add(bottomPanel);*/

		setLayout(new BorderLayout());
		
		// ===== TOP =====
		JPanel topPanel = new JPanel();
		JLabel titleLabel = new JLabel("Withdrawl");
		titleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 35));
		topPanel.add(titleLabel);
		add(topPanel, BorderLayout.NORTH);
		
		// ===== CENTER =====
		JPanel middlePanel = new JPanel();
        middlePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 130));
        middlePanel.setPreferredSize(new Dimension(600, 275));
        
		/*JLabel balanceDisplayLabel = new JLabel("Enter withdraw amount :     ");
		balanceDisplayLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
		JTextField amountField = new JTextField();
		amountField.setFont(new Font("Dialog", Font.PLAIN, 18));
		amountField.setPreferredSize(new Dimension(200, 30));
		JButton depositBurtton = new JButton("Submit");
		depositBurtton.setFont(new Font("Dialog", Font.PLAIN, 18));
		depositBurtton.addActionListener( e ->{
        	int amount = Integer.parseInt(amountField.getText());
        	System.out.println("Deposit Button clicked. \nAmount: "+amount);
        	String displayString = "Balance: "+currentUser.getBalance()+" --> "+ Integer.toString(currentUser.getBalance()+amount)+" (+"+amount+")";
        	JOptionPane.showMessageDialog(null, displayString, "Success", JOptionPane.INFORMATION_MESSAGE);
        	currentUser.deposit(amount);
        	manager.saveTransactionToCSV(currentUser ,"+"+amount);
        	main.getBalancePage().setBalance(currentUser);
        	main.switchPage("balance");
        	amountField.setText("");
        });
		middlePanel.add(balanceDisplayLabel);
		middlePanel.add(amountField);
		middlePanel.add(depositBurtton);
		add(middlePanel,BorderLayout.CENTER);*/
        JLabel balanceDisplayLabel = new JLabel("Enter withdraw amount :     ");
		balanceDisplayLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
		JTextField amountField = new JTextField();
		amountField.setFont(new Font("Dialog", Font.PLAIN, 18));
		amountField.setPreferredSize(new Dimension(200, 30));
		JButton withdrawButton = new JButton("Submit");
		withdrawButton.setFont(new Font("Dialog", Font.PLAIN, 18));
		withdrawButton.addActionListener( e ->{
        	int amount = Integer.parseInt(amountField.getText());
        	if (currentUser.withdraw(amount)) {
            	String displayString = "Balance: "+Integer.toString(currentUser.getBalance()+amount)+" --> "+currentUser.getBalance()+" (-"+amount+")";
        		JOptionPane.showMessageDialog(null, displayString, "Success", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("✅ 提款成功，目前餘額：" + currentUser.getBalance() + " 元");
            	manager.saveTransactionToCSV(currentUser ,"-"+amount);
                main.getBalancePage().setBalance(currentUser);
            	main.switchPage("balance");
            	amountField.setText("");
            } else {
            	JOptionPane.showMessageDialog(null, "Insufficient balance, withdrawal failed", "Failed", JOptionPane.WARNING_MESSAGE);
                System.out.println("❌ 餘額不足，提款失敗");
            }
        	System.out.println("Deposit Button clicked. \nAmount: "+amount);
        });
		middlePanel.add(balanceDisplayLabel);
		middlePanel.add(amountField);
		middlePanel.add(withdrawButton);
		add(middlePanel,BorderLayout.CENTER);
		
		// ===== BOTTOM =====
		JPanel bottomPanel = new JPanel(new BorderLayout());
		bottomPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

		JButton backButton = new JButton("< Back to Menu");
		backButton.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		backButton.setPreferredSize(new Dimension(180, 40));
		backButton.addActionListener(e -> {
			main.switchPage("menu");
			amountField.setText("");
		});
		bottomPanel.add(backButton, BorderLayout.WEST);

		JButton logoutButton = new JButton("Logout");
		logoutButton.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		logoutButton.setPreferredSize(new Dimension(180, 40));
		logoutButton.addActionListener(e -> {
			manager.saveToCSV();
			main.switchPage("home");
			amountField.setText("");
		});
		bottomPanel.add(logoutButton, BorderLayout.EAST);
		add(bottomPanel, BorderLayout.SOUTH);
		
	}
	
	public void setWithdraw(User user) {
        this.currentUser = user;
        
    }
}