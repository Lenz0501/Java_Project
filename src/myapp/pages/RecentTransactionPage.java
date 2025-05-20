// RecentTransactionPage.java
package myapp.pages;

import myapp.MainWindow;
import atm.User;
import atm.UserManager;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;

public class RecentTransactionPage extends JPanel {
	private User currentUser;
	private JTable table;
	
	public RecentTransactionPage(MainWindow main, UserManager manager) {
		setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
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
		
		JLabel titleLabel = new JLabel("Recent Transaction");
		titleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 24));
		topPanel.add(titleLabel);

		middlePanel.setLayout(new BorderLayout());

        String[] columnNames = {"time", "ID", "username", "+/-", "balance"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);
        table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        table.setRowHeight(28);
        table.setAutoCreateRowSorter(true); // 可以點欄位排序
        table.getColumnModel().getColumn(0).setPreferredWidth(150);

        JScrollPane scrollPane = new JScrollPane(table);
        middlePanel.add(scrollPane, BorderLayout.CENTER);

        loadCSVToTable("transaction.csv", model);
		
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
		add(bottomPanel);
	}
	
	/*public void setWithdraw(User user) {
        this.currentUser = user;   
    }*/
	
	public void refreshTable() {
	    DefaultTableModel model = (DefaultTableModel) table.getModel();
	    model.setRowCount(0);
	    loadCSVToTable("transaction.csv", model);
	}
	
	private void loadCSVToTable(String filePath, DefaultTableModel model) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] rowData = line.split(",");
                Vector<String> rowVector = new Vector<>();
                for (String item : rowData) {
                    rowVector.add(item.trim());
                }
                model.addRow(rowVector);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "讀取交易資料失敗：" + e.getMessage(),
                    "錯誤", JOptionPane.ERROR_MESSAGE);
        }
    }
}