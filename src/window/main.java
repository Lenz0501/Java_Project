package window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class main {
	public static void main(String[] args) {
        JFrame frame = new JFrame("demo");
        JLabel label = new JLabel("ATM Simulation System");
        
        frame.add(label);
        

        frame.setLayout(new FlowLayout());
        frame.setSize(600, 400);
        ImageIcon icon = new ImageIcon(main.class.getResource("/images/demo.png"));
        frame.setIconImage(icon.getImage());
        frame.setVisible(true);
	}

}
