// HomePage.java
package myapp.pages;

import myapp.MainWindow;
import javax.swing.*;
import java.awt.*;

public class HomePage extends JPanel {
	public HomePage(MainWindow main) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(600, 40));
        topPanel.setBackground(Color.WHITE);
        JLabel titleLabel = new JLabel("ATM Simulation System");
        titleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        topPanel.add(titleLabel);
        
        JButton toSetting = new JButton("To menu");
        toSetting.addActionListener(e -> main.switchPage("menu"));
        topPanel.add(toSetting);
        
        add(topPanel);
    }
}