//MainWindow.java
package myapp;

import myapp.pages.CreateAccountPage;
import myapp.pages.HomePage;
import myapp.pages.Menu;
import atm.UserManager;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
	CardLayout layout = new CardLayout();
	JPanel mainPanel = new JPanel(layout);
	
	private Menu menuPage;
	
	public MainWindow() {
	    setTitle("Demo");
	    setSize(600, 400);
	    ImageIcon icon = new ImageIcon(MainWindow.class.getResource("/images/demo.png"));
        setIconImage(icon.getImage());
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	    UserManager userManager = new UserManager();
	    mainPanel.add(new HomePage(this, userManager), "home");
	    menuPage = new Menu(this, userManager);
        mainPanel.add(menuPage, "menu");
	    //mainPanel.add(new Menu(this, userManager), "menu");
	    mainPanel.add(new CreateAccountPage(this, userManager), "create");
	
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
		
	public static void main(String[] args) {
		new MainWindow();
	}
}