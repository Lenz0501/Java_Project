//MainWindow.java
package myapp;

import myapp.pages.BalancePage;
import myapp.pages.CreateAccountPage;
import myapp.pages.DepositPage;
import myapp.pages.HomePage;
import myapp.pages.Menu;
import myapp.pages.WithdrawPage;
import myapp.pages.RecentTransactionPage;
import atm.UserManager;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
	CardLayout layout = new CardLayout();
	JPanel mainPanel = new JPanel(layout);
	
	private Menu menuPage;
	private BalancePage balancePage;
	private DepositPage depositPage;
	private WithdrawPage withdrawPage;
	private RecentTransactionPage recentTransactionPage;
	
	public MainWindow() {
	    setTitle("ATM Simulation System");
	    setSize(900, 600);
	    ImageIcon icon = new ImageIcon(MainWindow.class.getResource("/images/atm-machine.png"));
        setIconImage(icon.getImage());
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	    UserManager userManager = new UserManager();
	    
	    mainPanel.add(new HomePage(this, userManager), "home");
	    
	    menuPage = new Menu(this, userManager);
        mainPanel.add(menuPage, "menu");
        
	    mainPanel.add(new CreateAccountPage(this, userManager), "create");
	    
	    balancePage = new BalancePage(this, userManager);
	    mainPanel.add(balancePage, "balance");
	    
	    depositPage = new DepositPage(this, userManager);
	    mainPanel.add(depositPage, "deposit");
	    
	    withdrawPage = new WithdrawPage(this, userManager);
	    mainPanel.add(withdrawPage, "withdraw");
	    
	    recentTransactionPage = new RecentTransactionPage(this, userManager);
	    mainPanel.add(recentTransactionPage, "transaction");
	
		add(mainPanel);
	    layout.show(mainPanel, "home");
		
	    setVisible(true);
	}
		
	public void switchPage(String name) {
		layout.show(mainPanel, name);
	}
	
	public Menu getMenuPage() {
        return menuPage;
    }
	
	public BalancePage getBalancePage() {
        return balancePage;
    }
	
	public DepositPage getDepositPage() {
        return depositPage;
    }
	
	public WithdrawPage getWithdrawPage() {
        return withdrawPage;
    }
	
	public RecentTransactionPage getTransactionPage() {
        return recentTransactionPage;
    }
		
	public static void main(String[] args) {
		new MainWindow();
	}
}
