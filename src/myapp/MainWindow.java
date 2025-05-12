//MainWindow.java
package myapp;

import myapp.pages.CreateAccountPage;
import myapp.pages.HomePage;
import myapp.pages.Menu;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
	CardLayout layout = new CardLayout();
	JPanel mainPanel = new JPanel(layout);
	
	public MainWindow() {
	    setTitle("Demo");
	    setSize(600, 400);
	    ImageIcon icon = new ImageIcon(MainWindow.class.getResource("/images/demo.png"));
        setIconImage(icon.getImage());
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	    mainPanel.add(new HomePage(this), "home");
	    mainPanel.add(new Menu(this), "menu");
	    mainPanel.add(new CreateAccountPage(this), "create");
	
		add(mainPanel);
	    layout.show(mainPanel, "home");
		
	    setVisible(true);
	}
		
	public void switchPage(String name) {
		layout.show(mainPanel, name);
	}
		
	public static void main(String[] args) {
		new MainWindow();
	}
}